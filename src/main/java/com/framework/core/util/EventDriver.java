package com.framework.core.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class EventDriver {

	public static EventFiringWebDriver getEventFiringWebDriver(WebDriver driver) {
		EventFiringWebDriver eventDriver=new EventFiringWebDriver(driver);
		EventHandler handler = new EventHandler();
		eventDriver.register(handler);
		return eventDriver;
	}
}
