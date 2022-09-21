package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	public static String formatar(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return sdf.format(data);
	}
	
	public static String formatar(Date data, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.format(data);
	}
}
