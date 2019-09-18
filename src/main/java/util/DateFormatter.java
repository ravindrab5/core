package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	Date day = new Date();

	public DateFormatter() {
		day = new Date();
	}

	/**
	 * Will get timestamp of format MMddHHmmss.
	 * @return
	 */
	public String getTimeStamp() {
		String[] da = day.toString().split(" ");

		String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
		return timeStamp;
	}

}
