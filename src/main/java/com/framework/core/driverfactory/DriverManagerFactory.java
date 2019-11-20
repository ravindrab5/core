package com.framework.core.driverfactory;

import com.framework.core.models.TestRun;

public class DriverManagerFactory {
	public static DriverManager getManager(TestRun testRun) {

		DriverManager driverManager = null;

		switch (testRun.getBrowser()) {
		case "chrome":
			driverManager = new ChromeDriverManager(testRun);
			break;
		case "firefox":
			// driverManager = new FirefoxDriverManager();
			break;
		default:
			// driverManager = new SafariDriverManager();
			break;
		}
		return driverManager;
	}
}
