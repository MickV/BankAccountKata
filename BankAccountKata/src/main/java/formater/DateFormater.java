package formater;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {

	public static String formatDate(Date dateToFormate) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");
		return format.format(dateToFormate);
	}
	
	public static Date toDate(String dateString) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");
		return format.parse(dateString);
	}
}
