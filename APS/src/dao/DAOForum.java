package dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.models.FiltroModel;
import model.models.TagsMaisAtivasModel;
import model.models.UsuarioAtivoModel;
import model.models.UsuarioLoginModel;
import model.tables.PostagemModel;
import model.tables.TopicoModel;
import model.tables.UsuarioModel;


public class DAOForum {

	private static String msgErro;
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("forum");
	private static EntityManager manager;


	public static String getMsgErro() {
		String msgErroTemp = msgErro;
		msgErro = null;
		return msgErroTemp;
	}

	public static UsuarioModel conferirUsuario(UsuarioLoginModel usuario){
		try {
			manager = factory.createEntityManager();
			UsuarioModel usuarioEncontrado = null;
			if(factory != null & manager != null)
				usuarioEncontrado = manager.find(UsuarioModel.class, usuario.getUsuario());

			return usuarioEncontrado;
		} catch (Exception e){
			if(factory != null & manager != null)
				manager.getTransaction().rollback();

			e.printStackTrace();
			msgErro = "Ocorreu um erro ao conferir usuário.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static UsuarioModel conferirUsuario(String usuario){
		try {
			manager = factory.createEntityManager();
			UsuarioModel usuarioEncontrado = null;
			if(factory != null & manager != null)
				usuarioEncontrado = manager.find(UsuarioModel.class, usuario);

			return usuarioEncontrado;
		} catch (Exception e){
			if(factory != null & manager != null)
				manager.getTransaction().rollback();

			e.printStackTrace();
			msgErro = "Ocorreu um erro ao conferir usuário.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static boolean cadastrarUsuario(UsuarioModel usuario){
		try {
			UsuarioModel temp = conferirUsuario(usuario.getUsuario());
			if(temp == null){
				manager = factory.createEntityManager();
				if(factory != null & manager != null) {
					manager.getTransaction().begin();
					manager.persist(usuario);
					manager.getTransaction().commit();
				}
				return true;
			} else {
				msgErro = "Usuário já existe";
				return false;
			}
		} catch(Exception e){
			if(factory != null & manager != null)
				manager.getTransaction().rollback();

			msgErro = "Ocorreu um erro ao cadastrar usuário.\nMensagem do erro: " + e.getMessage();
			e.printStackTrace();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	public static boolean trocarSenha(UsuarioModel usuario){
		try {
			manager = factory.createEntityManager();
			if(factory != null & manager != null) {
				manager.getTransaction().begin();
				manager.merge(usuario);
				manager.getTransaction().commit();
			}
			return true;
		} catch(Exception e){
			if(factory != null & manager != null)
				manager.getTransaction().rollback();

			e.printStackTrace();
			msgErro = "Ocorreu um erro ao trocar a senha.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	public static List<TopicoModel> getTopicos(FiltroModel filtro) {
		String filtros = "";

		if(filtro.getUsuario() != null & !filtro.getUsuario().equals("")) {
			filtros += " usuario = " + filtro.getUsuario() + ",";
		}

		if(filtro.getData() != null & !filtro.getData().equals("")) {
			filtros += " data = " + filtro.getData() + ",";
		}

		if(filtro.getTag() != null & !filtro.getTag().equals("")) {
			filtros += " tag = " + filtro.getTag() + ",";
		}

		if(filtro.getTitulo() != null & !filtro.getTitulo().equals("")) {
			filtros += " titulo = " + filtro.getTitulo() + ",";
		}

		filtros.substring(0, filtros.length() - 1);

		if(filtro.getOrderDate() == FiltroModel.DESCENDENTE) {
			filtros += " order by data DESC";
		} else {
			filtros += " order by data ASC";
		}

		try {
			manager = factory.createEntityManager();
			List<TopicoModel> topicos = null;
			if(factory != null & manager != null)
				topicos = manager.createQuery("select * from topicos where" + filtros, TopicoModel.class).getResultList();

			return topicos;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao solicitar os tópicos.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}

	}

	public static List<PostagemModel> getPostagens(int idTopico) {
		try {
			manager = factory.createEntityManager();
			List<PostagemModel> postagens = null;
			if(factory != null & manager != null)
				postagens = manager.createQuery("select * from postagens where idTopico = " + idTopico + " order by data DESC", PostagemModel.class).getResultList();

			return postagens;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar as postagens.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static List<TopicoModel> getTopicosMaisCurtidos() {
		try {
			manager = factory.createEntityManager();
			List<TopicoModel> topicos = null;

			if(factory != null & manager != null)
				topicos = manager.createQuery("select * from topicos where qtdCurtidas > 0 order by qtdCurtidas DESC", TopicoModel.class).setMaxResults(10).getResultList();

			return topicos;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar os tópicos mais curtidos.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static List<UsuarioAtivoModel> getUsuariosMaisAtivos() {
		try {
			manager = factory.createEntityManager();
			List<UsuarioAtivoModel> usuariosAtivos = null;
			if(factory != null & manager != null)
				usuariosAtivos = manager.createQuery("select new UsuarioAtivoModel(usuario, count(*) as qtdPostagens) from postagens group by usuario order by qtdPostagens DESC", UsuarioAtivoModel.class).setMaxResults(10).getResultList();

			return usuariosAtivos;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar os usuários mais ativos.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static List<TagsMaisAtivasModel> getTagsMaisAtivas() {
		try {
			manager = factory.createEntityManager();
			List<TagsMaisAtivasModel> tags = null;
			if(factory != null & manager != null)
				tags = manager.createQuery("select new TagsMaisAtivasModel(tag, count(*) as qtdPublicacoes) from topicos group by tag order by qtdPublicacoes DESC", TagsMaisAtivasModel.class).setMaxResults(10).getResultList();

			return tags;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar as tags mais ativas.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static boolean curtirTopico(int idTopico, boolean curtir){
		try {
			manager = factory.createEntityManager();
			int rows = 0;
			if(factory != null & manager != null) {
				if(curtir)
					rows = manager.createQuery("update topicos set qtdCurtidas = qtdCurtidas + 1 where idTopico = " + idTopico).executeUpdate();
				else
					rows = manager.createQuery("update topicos set qtdCurtidas = qtdCurtidas - 1 where idTopico = " + idTopico).executeUpdate();
			}
			System.out.println(rows + " linhas afetadas");
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao curtir/descurtir o tópico.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	public static boolean postarPostagem(PostagemModel postagem) {
		try {
			manager = factory.createEntityManager();
			if(factory != null & manager != null) {
				manager.getTransaction().begin();
				manager.persist(postagem);
				manager.getTransaction().commit();
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao postar a resposta.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	public static boolean postarTopico(TopicoModel topico) {
		try {
			manager = factory.createEntityManager();
			if(factory != null & manager != null) {
				manager.getTransaction().begin();
				manager.persist(topico);
				manager.getTransaction().commit();
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao postar o tópico.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	public static void closeConexaoFactory() {
		if(factory != null) {
			factory.close();
			factory = null;
		}
	}

	private static void closeConexaoEntity() {
		if(factory != null & manager != null) {
			manager.close();
			manager = null;
		}
	}

	public static void main(String[] args) {
		UsuarioModel usuario = new UsuarioModel();
		usuario.setUsuario("rafaelcx");
		usuario.setSenha("teste123");
		usuario.setNome("Rafael Felipe Moraes");
		usuario.setCidade("Jacareí");
		usuario.setEstado("São Paulo");
		usuario.setPerguntaSecret("Nome do Cachorro(a)");
		usuario.setRespostaSecret("Nina");
		usuario.setGenero("Masculino");
		usuario.setDataNasc("13/01/1997");
		DAOForum.cadastrarUsuario(usuario);
		UsuarioModel usuarioConferido = DAOForum.conferirUsuario("rafaelcx");
		System.out.println(usuarioConferido.getUsuario() + ";\n" +
				usuarioConferido.getSenha() + ";\n" +
				usuarioConferido.getNome() + ";\n" +
				usuarioConferido.getCidade() + ";\n" +
				usuarioConferido.getEstado() + ";\n" +
				usuarioConferido.getPerguntaSecret() + ";\n" +
				usuarioConferido.getRespostaSecret() + ";\n" +
				usuarioConferido.getGenero() + ";\n" +
				usuarioConferido.getDataNasc() + ";\n");
		usuarioConferido.setSenha("teste12345");

		DAOForum.trocarSenha(usuarioConferido);

		TopicoModel topico = new TopicoModel();
		topico.setTitulo("Teste");
		topico.setQtdCurtidas(0);
		topico.setQtdRespostas(0);
		topico.setTag("teste");
		topico.setUsuario(usuarioConferido);
		topico.setDtCriacao(LocalDateTime.now().toString());

		DAOForum.postarTopico(topico);

		PostagemModel postagem = new PostagemModel();
		postagem.setIdTopico(topico);
		postagem.setDataPost(LocalDateTime.now().toString());
		postagem.setTextoPost("Teste");
		postagem.setUsuario(usuarioConferido);

		DAOForum.postarPostagem(postagem);

		List<TagsMaisAtivasModel> tags = DAOForum.getTagsMaisAtivas();
		List<TopicoModel> topicosModel = DAOForum.getTopicosMaisCurtidos();
		List<UsuarioAtivoModel> users = DAOForum.getUsuariosMaisAtivos();
		List<TopicoModel> topicosT = DAOForum.getTopicos(new FiltroModel());
		List<PostagemModel> postagens = DAOForum.getPostagens(1);
	}

}