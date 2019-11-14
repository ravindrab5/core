package com.framework.core.driverfactory;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public abstract class DriverManager {
	protected WebDriver driver;

	
	protected abstract void createDriver();
	
	protected abstract void startService();

	protected abstract void stopService();

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}

	public WebDriver getDriver() {
		if (null == driver) {
			//startService();
			createDriver();
		}
		return driver;
	}
}
