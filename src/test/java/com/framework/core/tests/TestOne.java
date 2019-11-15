package com.framework.core.tests;

import com.framework.core.TestInit.TestBase;
import com.framework.core.driverfactory.DriverManagerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.framework.core.pageactions.WebUi;
import com.framework.core.util.EventDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ravindra on 22-09-2019.
 */
public class TestOne extends TestBase {

    @BeforeMethod
    public void setupDriver(){
        driver= EventDriver.getEventFiringWebDriver(DriverManagerFactory.getManager(testRun.getBrowser(),testRun.getRun_env()).getDriver());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebUi.init(driver,"php_travels_home",30);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test(enabled = false)
    public void testLoginValid(){
        WebUi.Navigate("http://www.phptravels.net/");
        WebUi.clickOn("myaccount");
        WebUi.clickOn("loginlink");
        WebUi.typeOn("username","user@phptravels.com");
        WebUi.typeOn("password","demouser");
        WebUi.clickOn("loginbtn");
        String greetingtext=WebUi.getText("greeting");
        System.out.println(greetingtext);
        WebUi.pauseExecution(10000);
    }

    @Test
    public void testLoginInvalid(){
        WebUi.Navigate("http://www.phptravels.net/");
        WebUi.clickOn("myaccount");
        WebUi.clickOn("loginlink");
        WebUi.typeOn("username","user@phptravels.com");
        WebUi.typeOn("password","demouser1");
        WebUi.clickOn("loginBtnFailure");
        String error_text=WebUi.getText("errorTxt");

        System.out.println(error_text);
        WebUi.pauseExecution(10000);
    }

}
