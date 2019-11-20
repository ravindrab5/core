package com.framework.core.util;



import com.framework.core.handlers.UiNameHandler;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener{
	Logger logger=LogInitilizer.getLogger();
	public static boolean extentReoportFlag=false;



	@Override
	public void beforeAlertAccept(WebDriver webDriver) {

	}

	@Override
	public void afterAlertAccept(WebDriver webDriver) {

	}

	@Override
	public void afterAlertDismiss(WebDriver webDriver) {

	}

	@Override
	public void beforeAlertDismiss(WebDriver webDriver) {

	}

	@Override
	public void beforeNavigateTo(String s, WebDriver webDriver) {
		if(extentReoportFlag) {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Navigate to url  - " + s);
		}

	}

	@Override
	public void afterNavigateTo(String s, WebDriver webDriver) {

	}

	@Override
	public void beforeNavigateBack(WebDriver webDriver) {

	}

	@Override
	public void afterNavigateBack(WebDriver webDriver) {

	}

	@Override
	public void beforeNavigateForward(WebDriver webDriver) {

	}

	@Override
	public void afterNavigateForward(WebDriver webDriver) {

	}

	@Override
	public void beforeNavigateRefresh(WebDriver webDriver) {

	}

	@Override
	public void afterNavigateRefresh(WebDriver webDriver) {

	}

	@Override
	public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

	}

	@Override
	public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

	}

	@Override
	public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

	}

	@Override
	public void afterClickOn(WebElement webElement, WebDriver webDriver) {

		if(extentReoportFlag) {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Clicked on element  - " + UiNameHandler.getUiName(webElement));


		}
		logger.info("Clicked on button - " + UiNameHandler.getUiName(webElement));

	}

	@Override
	public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

	}

	@Override
	public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
		logger.info("Typed on element - "+UiNameHandler.getUiName(webElement));

		if(extentReoportFlag) {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Typed on element - " + UiNameHandler.getUiName(webElement));
		}

	}

	@Override
	public void beforeScript(String s, WebDriver webDriver) {

	}

	@Override
	public void afterScript(String s, WebDriver webDriver) {

	}

	@Override
	public void onException(Throwable throwable, WebDriver webDriver) {

	}

}