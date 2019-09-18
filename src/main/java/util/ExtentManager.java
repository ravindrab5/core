package util;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	static Date date = new Date();
	public static ExtentReports extent;
	public static String filename = "" + date.getTime() + ".html";
	public static String reportPath = "./Results/" + filename;
	private static Logger log;

	public static ExtentReports getInstance() {
		if (extent == null) {
			log = LogInitilizer.getLogger();
			extent = new ExtentReports(reportPath, true);
			log.debug("Initilizing report at - " + reportPath);
			File f = new ResourceUtil().getFile("Properties/extent-config.xml");
			extent.loadConfig(f.getAbsoluteFile());
		}
		return extent;
	}
}
