package util;



import handlers.UiNameHandler;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EventHandler implements WebDriverEventListener{
	Logger logger=LogInitilizer.getLogger();
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
		logger.info("Clicked on button - "+ UiNameHandler.getUiName(webElement));

	}

	@Override
	public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

	}

	@Override
	public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
		logger.info("Typed on element - "+UiNameHandler.getUiName(webElement));
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
//	Logger log;
//
//	public EventHandler() {
//		log=LogInitilizer.getLogger();
//	}
//
//
//
//	private String getLoc(String temp) {
//		String[] str=temp.split(" ");
//		String str1=str[str.length-1].substring(0,str[str.length-1].length()-1 ).trim();
//		return str1;
//	}
//
//
//	private String getLocForBy(String temp) {
//		String[] str=temp.split(" ");
//		String str1=str[str.length-1].trim();
//		return str1;
//	}
//
//
//	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
//		// TODO Auto-generated method stub
//
//		//System.out.println("inside method afterChangeValueOf on " + arg0.toString());
//
//		//System.out.println("After value change in textfield " + arg0.toString());
//		//log.info("After value change in textfield " + arg0.toString());
//
//
//
//	}
//
//	public void afterClickOn(WebElement arg0, WebDriver arg1) {
//	  	log.debug("Clicked on UI element | "+ViewBase.uiName.get(getLoc(arg0.toString()))+" | Located By : "+arg0.toString()+" | ");
//	  	ExtentTest logger=ExtentTestManager.getTest();
//	  	logger.log(LogStatus.INFO,"Clicked on - "+ViewBase.uiName.get(getLoc(arg0.toString())));
//	}
//
//	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
//  		log.info("Found element " + ViewBase.uiName.get(getLocForBy(arg0.toString())));
//	 }
//
//	public void afterNavigateBack(WebDriver arg0) {
//		log.debug("Navigated  back to  " + arg0.getCurrentUrl());
//	}
//
//	public void afterNavigateForward(WebDriver arg0) {
//		//log.debug("Navigated forward to :  " + arg0.getCurrentUrl());
//	}
//
//	public void afterNavigateTo(String arg0, WebDriver arg1) {
//		// TODO Auto-generated method stub
//		//System.out.println("Navigated to : " + arg0);
//		log.debug("Navigated to : " + arg0);
//
//	}
//
//	public void afterScript(String arg0, WebDriver arg1) {
// //		log.debug("Inside the afterScript to, Script is " + arg0);
//	}
//
//	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
//
//	}
//
//	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
//	 //	log.info("About to click on the " + arg0.toString());
//	}
//
//	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
//	}
//
//	public void beforeNavigateBack(WebDriver arg0) {
////		log.debug("Navigating back : " + arg0.getCurrentUrl());
//	}
//
//	public void beforeNavigateForward(WebDriver arg0) {
// //		log.debug("Navigating forward " + arg0.getCurrentUrl());
//	}
//
//	public void beforeNavigateTo(String arg0, WebDriver arg1) {
//	 	log.debug("Navigating to  " + arg0);
//	}
//
//	public void beforeScript(String arg0, WebDriver arg1) {
//		// TODO Auto-generated method stub
//		//System.out.println("Just before beforeScript " + arg0);
//	}
//
//	public void onException(Throwable arg0, WebDriver arg1) {
//		// TODO Auto-generated method stub
//		//System.out.println("Exception occured at " + arg0.getMessage());
//
//	}
//
//	@Override
//	public void afterAlertAccept(WebDriver arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void afterAlertDismiss(WebDriver arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
//		// TODO Auto-generated method stub
//		// Converting
//		//CharSequence to String
//
//		String mEntriesString = "";
//		for(CharSequence ch: arg2){
//		    mEntriesString+= ch.toString();
//		}
//
//		log.debug("Typed on element | "+ViewBase.uiName.get(getLoc(arg0.toString()))+" | Text - "+mEntriesString.toString());
//
//		ExtentTest logger=ExtentTestManager.getTest();
//	  	logger.log(LogStatus.INFO,"Typed on element | "+ViewBase.uiName.get(getLoc(arg0.toString()))+" | Text - "+mEntriesString.toString());
//	  	log.debug("Typed on element - "+arg0);
//	}
//
//	@Override
//	public void afterNavigateRefresh(WebDriver arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void beforeAlertAccept(WebDriver arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void beforeAlertDismiss(WebDriver arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void beforeNavigateRefresh(WebDriver arg0) {
//		// TODO Auto-generated method stub
//
//	}

}