package com.framework.core.driverfactory;

public class DriverManagerFactory {
	public static DriverManager getManager(String type,String run_env) {

		DriverManager driverManager = null;

		switch (type) {
		case "chrome":
			driverManager = new ChromeDriverManager(run_env);
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
