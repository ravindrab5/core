package com.framework.core.util;

import com.framework.core.models.TestRun;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class EventDriver {

	public static EventFiringWebDriver getEventFiringWebDriver(WebDriver driver,TestRun testRun) {
		EventFiringWebDriver eventDriver=new EventFiringWebDriver(driver);
		EventHandler handler = new EventHandler();

		if(testRun.getExtend_report()!=null && testRun.getExtend_report().equalsIgnoreCase("yes")) {
			EventHandler.extentReoportFlag = true;
		}
		eventDriver.register(handler);
		return eventDriver;
	}
}
