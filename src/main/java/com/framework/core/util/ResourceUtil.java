package com.framework.core.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ResourceUtil {

	public File getFile(String fileName) {

	
		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}

	public InputStream getFileAsStream(String fileName) {


		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream(fileName);
		//File file = new File(classLoader.getResource(fileName).getFile());
		//return file;
	}
}
