package util;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {

	static ExtentReports report = ExtentManager.getInstance();

	static Map<Integer, ExtentTest> map = new HashMap<Integer, ExtentTest>();

	public static synchronized ExtentTest startTest(String testName) {
		return startTest(testName, "");
	}

	public static synchronized ExtentTest startTest(String testName, String description) {
		ExtentTest testRep = report.startTest(testName, description);
		System.out.println("Starting test - "+(int) Thread.currentThread().getId());
		map.put((int) Thread.currentThread().getId(), testRep);
		return testRep;
	}

	public static synchronized ExtentTest getTest() {
		return map.get((int) Thread.currentThread().getId());
	}

	public static synchronized void endTest() {
		System.out.println("End Test - "+(int) Thread.currentThread().getId());
		int threadId=(int) Thread.currentThread().getId();
		report.endTest(map.get(threadId));
		report.flush();
	}

	 
}
