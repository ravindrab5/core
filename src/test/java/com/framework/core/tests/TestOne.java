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
        WebUi.init(driver,"Login",30);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testOne(){
        WebUi.Navigate("https://hw-qa.ridecell.us/dispatch/login?next=/dispatch");
        WebUi.typeOn("username","dispatcher@ridecell.com");
        WebUi.typeOn("password","OMruFxdyUU8Gk9Mm99h4BQ");
        WebUi.clickOn("login_btn");
    }
}
