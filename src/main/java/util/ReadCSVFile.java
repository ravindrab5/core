/*
 * Copyright 2016 Synerzip Softech. All Rights Reserved.
 */

package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import au.com.bytecode.opencsv.CSVReader;

/**
 * The Class ReadCSVFile.
 */
public class ReadCSVFile {
	static Logger log;
	
	/**
	 * Gets the data from csv file.
	 *
	 * @param testMethod the test method
	 * @return the data from csv file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@DataProvider(name="CSVData")
	public static Object[][] getDataFromCsvFile(final Method testMethod) throws IOException {
		log=LogInitilizer.getLogger();
		
		String paths="/"+testMethod.getName()+".csv";
		
		//System.out.println(paths);
		DataProviderArguments parameters = testMethod.getAnnotation(DataProviderArguments.class);

	    if (parameters != null) {
	        String path = parameters.path();
	        path=path+paths;
	        
	        //System.out.println(path);
	        log.info("Getting data from csv at :"+path);
	       Object[][] obj= loadDataFromCsvFile(path);
	       /*  
	       for(int i=0;i<obj.length;i++) {
	        	 for(int j=0;j<obj[i].length;j++) {
	        		 System.out.println(obj[i][j]);
	        	 }
	         }
	         */
	        return obj;
	    } else {
	    	log.info("Couldn't read from file ");
	        throw new RuntimeException("Couldn't find the annotation");
	    }
	}
	
	/**
	 * Load data from csv file.
	 *
	 * @param CSVpath the CS vpath
	 * @return the object[][]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Object[][] loadDataFromCsvFile(String CSVpath) throws IOException {
		int rows = 0;
		try {
			CSVReader csvReader = new CSVReader(new FileReader(CSVpath));
			rows = csvReader.readAll().size();
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		FileReader fr = new FileReader(CSVpath);
		BufferedReader br = new BufferedReader(fr);	
		
		
		Object[][] finalArray=null;
		// = new Object[rows][numOfColumns];
		
		String lines=null;
		try {
			int i=0;
			while((lines=br.readLine())!=null){
				Object[] temp=lines.split(",");
				if(finalArray==null) {
				finalArray=new Object[rows][temp.length];
				}
				
				for (int j = 0; j < temp.length; j++) {					
					finalArray[i][j] = temp[j];
				}
				i++;
				
			}
			
			
			
			br.close();
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return finalArray;
	}
	
	
	
	public static String[][] loadDataFromCsv(String CSVpath) throws IOException {
		int rows = 0;
		try {
			CSVReader csvReader = new CSVReader(new FileReader(CSVpath));
			rows = csvReader.readAll().size();
			csvReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		FileReader fr = new FileReader(CSVpath);
		BufferedReader br = new BufferedReader(fr);	
		
		
		String[][] finalArray=null;
		// = new Object[rows][numOfColumns];
		
		String lines=null;
		try {
			int i=0;
			while((lines=br.readLine())!=null){
				String[] temp=lines.split(",");
				if(finalArray==null) {
				finalArray=new String[rows][temp.length];
				}
				
				for (int j = 0; j < temp.length; j++) {					
					finalArray[i][j] = temp[j];
				}
				i++;
				
			}
			
			
			
			br.close();
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return finalArray;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
