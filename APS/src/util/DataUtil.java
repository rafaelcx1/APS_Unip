package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataUtil {

	private static final String DATE_PATTERN = "dd.MM.yyyy | HH:mm:ss";
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	public static String format(LocalDateTime date) {
		if(date == null) {
			return null;
		}
		return DATE_FORMATTER.format(date);
	}

	public static LocalDateTime parse(String dateString) {
		try {
			return DATE_FORMATTER.parse(dateString, LocalDateTime::from);
		} catch (DateTimeParseException e) {
			return null;
		}
	}

	public static boolean validDate(String dateString) {
		return DataUtil.parse(dateString) != null;
	}

}