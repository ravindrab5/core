package com.framework.core.util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ResourceUtil {

	public File getFile(String fileName) {

	
		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}
}
