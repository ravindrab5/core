package util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.yantra.serviceportal.model.TestCase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {
	public static String testName;
	ExtentTest logger;
	Logger log;

	// This belongs to ISuiteListener and will execute before the Suite start

	@Override
	public void onStart(ISuite arg0) {
		// customReport = CustomHTMLReport.getInstance(arg0.getName() + ".html");

	}

	// This belongs to ISuiteListener and will execute, once the Suite is finished

	@Override
	public void onFinish(ISuite arg0) {
		// Reporter.log("About to end executing Suite " + arg0.getName(), true);

	}

	// This belongs to ITestListener and will execute before starting of Test
	// set/batch

	public void onStart(ITestContext arg0) {
		// logger_content.log(LogStatus.INFO," Starting with <test> "+arg0.getName());
		// testName = arg0.getName();
		// Reporter.log("About to begin executing <Test> " + arg0.getName(), true);
		log = LogInitilizer.getLogger();
	}

	// This belongs to ITestListener and will execute, once the Test set/batch is
	// finished

	public void onFinish(ITestContext arg0) {
		// logger_content.log(LogStatus.INFO," Finishing <test> "+arg0.getName());
		// Reporter.log("Completed executing </test> " + arg0.getName(), true);

	}

	// This belongs to ITestListener and will execute only when the test method is
	// pass

	public void onTestSuccess(ITestResult arg0) {

		// This is calling the printTestResults method
		logger.log(LogStatus.PASS, "Test Passed ");
		printTestResults(arg0);
		ExtentTestManager.endTest();
		// customReport.endTest();

	}

	// This belongs to ITestListener and will execute only on the event of fail test

	public void onTestFailure(ITestResult arg0) {

		Class clazz = arg0.getTestClass().getRealClass();
		Field field = null;
		try {
			field = clazz.getField("driver");
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		field.setAccessible(true);

		EventFiringWebDriver driver = null;
		try {
			driver = (EventFiringWebDriver) field.get(arg0.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	 
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = arg0.getName() + "__" + new DateFormatter().getTimeStamp() + ".jpg";
		File targetFile = new File("./Results/Screenshots/" + fileName);

		try {
			FileUtils.copyFile(srcFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	 
		logger.log(LogStatus.FAIL, arg0.getThrowable() + logger.addScreenCapture("./Screenshots/" + fileName));
		ExtentTestManager.endTest();
		// customReport.endTest();

	}

	// This belongs to ITestListener and will execute before the main test start
	// (@Test)

	public void onTestStart(ITestResult arg0) {

		String params = " - (";
		if (arg0.getParameters().length != 0) {

			// String params = " - (";

			for (Object parameter : arg0.getParameters()) {

				// params += parameter.toString() + ",";
				params += parameter.toString() + ",";
			}

		}
		params += ")";
		
		 TestCase testcase = TestScriptMetaData.getTestCase();
		 
		 String testname=testcase.getName()+params;
		 System.out.println("Test case name - "+testname);
		 
		 logger = ExtentTestManager.startTest(testname);
		 logger.log(LogStatus.INFO, testcase.getDescription());
		 logger.log(LogStatus.INFO, "=======================================");

	}
	// This belongs to ITestListener and will execute only if any of the main
	// test(@Test) get skipped

	public void onTestSkipped(ITestResult arg0) {
		// logger.log(LogStatus.SKIP, "Test Skipped ");
		printTestResults(arg0);
		ExtentTestManager.endTest();
		// customReport.endTest();
	}

	// This is just a piece of shit, ignore this

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	// This is the method which will be executed in case of test pass or fail

	// This will provide the information on the test

	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			Reporter.log("Test Method had the following parameters : " + params, true);

		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:

			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);

	}

	// This belongs to IInvokedMethodListener and will execute before every method
	// including @Before @After @Test

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "About to begin executing following method : ";

		if (arg0.getTestMethod().isTest()) {
			// .contains("TECH_APP:TC")){
			/*
			 * if (arg1.getParameters().length != 0) {
			 * 
			 * String params = " - (";
			 * 
			 * for (Object parameter : arg1.getParameters()) {
			 * 
			 * //params += parameter.toString() + ","; params += parameter.toString() + ",";
			 * }
			 * 
			 * params+=")"; TestCase testcase = TestScriptMetaData.getTestCase();
			 * 
			 * String testname=testcase.getName()+params;
			 * System.out.println("Test case name - "+testname);
			 * 
			 * logger = customReport.beginTest(testname); logger.log(LogStatus.INFO,
			 * testcase.getDescription()); logger.log(LogStatus.INFO,
			 * "=======================================");
			 */

			// Reporter.log("Test Method had the following parameters : " + params, true);

		}

	}

	// This belongs to IInvokedMethodListener and will execute after every method
	// including @Before @After @Test

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		String textMsg = "Completed executing following method : " + arg0.getTestMethod().getMethodName();
		if (arg1.getThrowable() != null) {
			log.fatal("Exception - " + arg1.getThrowable());
		}
	}

	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}

}
