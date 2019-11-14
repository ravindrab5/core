package com.framework.core.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyUtil {
	
	public static Properties getProperties(String path) {
		Logger log=LogInitilizer.getLogger();
		Properties prop;
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			log.debug("Loading file " +path);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.fatal("File not found ",e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.fatal("Error reading file ",e);
		}
		return prop;
	}

}
