package com.framework.core.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogInitilizer {

	private volatile static Logger instance;

	private LogInitilizer() {
	}

	public static Logger getLogger() {

		synchronized (LogInitilizer.class) {
			if (instance == null) {
				//String path = new ResourceUtil().getFile("log4j.properties").getAbsolutePath();
				PropertyConfigurator.configure(new ResourceUtil().getFileAsStream("log4j.properties"));
				instance = Logger.getLogger("Logger");
				System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
				instance.debug("Debug Log is initialized");
			}
			return instance;
		}
	}
}
