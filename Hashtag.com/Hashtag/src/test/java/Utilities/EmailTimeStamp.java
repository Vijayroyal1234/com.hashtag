package Utilities;

import java.util.Date;

public class EmailTimeStamp {

public static String generateTimestamp() {
		
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "vijay"+timeStamp+"@gmail.com";
	}
}
