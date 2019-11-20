package com.framework.core.tests;

import com.framework.core.pageactions.Page;
import com.framework.core.testInit.TestBase;
import com.framework.core.driverfactory.DriverManagerFactory;
import com.framework.core.reportlistners.ExtentReportListener;
import com.framework.core.util.DataProviderArguments;
import com.framework.core.util.ReadCSVFile;
import com.framework.core.util.TestScriptMetaData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.framework.core.util.EventDriver;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ravindra on 22-09-2019.
 */

//@Listeners(ExtentReportListener.class)
public class TestOne extends TestBase {

    @BeforeMethod
    public void setupDriver(Method method){
        driver= EventDriver.getEventFiringWebDriver(DriverManagerFactory.getManager(testRun).getDriver(),testRun);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebUi=new Page(driver,"php_travels_home",30);
        //Page.init(driver,"php_travels_home",30);
        TestScriptMetaData.setTestCaseData(method);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test(  testName = "PHPTRAVEL:WEB_TC_001",
            description = "Checks login functionality with invalid inputs",
            enabled=false
    )
    public void testLoginValid(){
        WebUi.Navigate("http://www.phptravels.net/");
        WebUi.clickOn("myaccount");
        WebUi.clickOn("loginlink");
        WebUi.typeOn("username","user@phptravels.com");
        WebUi.typeOn("password","demouser");
        WebUi.clickOn("loginbtn");
        String greetingtext= WebUi.getText("greeting");
        System.out.println(greetingtext);
        Page.pauseExecution(10000);
    }

    @DataProviderArguments(path="./testdata")
    @Test(  testName = "PHPTRAVEL:WEB_TC_002",
            description = "Checks login functionality with invalid inputs",
            dataProvider="CSVData",
            dataProviderClass=ReadCSVFile.class
         )
    public void testLoginInvalid(String username,String password,String message){
        WebUi.Navigate("http://www.phptravels.net/");
        WebUi.clickOn("myaccount");
        WebUi.clickOn("loginlink");
        WebUi.typeOn("username",username);
        WebUi.typeOn("password",password);
        WebUi.clickOn("loginBtnFailure");
        String error_text= WebUi.getText("errorTxt");
        Assert.assertEquals(error_text,message);
        //System.out.println(error_text);
        // Page.pauseExecution(10000);
    }

}
