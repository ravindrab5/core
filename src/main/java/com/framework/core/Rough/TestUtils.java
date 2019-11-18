package com.framework.core.Rough;

import com.framework.core.driverfactory.DriverManager;
import com.framework.core.driverfactory.DriverManagerFactory;
import com.framework.core.handlers.ArgumentHandler;

import com.framework.core.models.TestRun;
import com.framework.core.pageactions.Page;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.framework.core.util.EventDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by Ravindra on 18-09-2019.
 */
public class TestUtils {
    public static void main(String[] args) throws Exception {


        TestRun testRun= ArgumentHandler.getTestRun(args);
    /*    System.out.println(testRun.getMobile_web());
        System.out.println(testRun.getOs());
        System.out.println(testRun.isHeadles());
*/












     /*   EventFiringWebDriver driver;
        DriverManager driverManager;
        driverManager = DriverManagerFactory.getManager("chrome","local");
        driver = EventDriver.getEventFiringWebDriver(driverManager.getDriver());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.close();

        Page.init(driver,"Login",30);
        Page.Navigate("https://hw-qa.ridecell.us/dispatch/login?next=/dispatch");
        Page.typeOn("username","dispatcher@ridecell.com");
        Page.typeOn("password","OMruFxdyUU8Gk9Mm99h4BQ");
        Page.clickOn("login_btn");
     //   Thread.sleep(10000);
        Page.clickOn("menu");
       // Thread.sleep(10000);
        driver.quit();
*/



        //driver.get("https://hw-qa.ridecell.us/dispatch/login?next=/dispatch");

//        WebElementHandler elementHandler=new WebElementHandler(driver,"Login");



//        elementHandler.getElement("username").sendKeys("dispatcher@ridecell.com");
//        elementHandler.getElement("password").sendKeys("OMruFxdyUU8Gk9Mm99h4BQ");
//        elementHandler.getElement("login_btn").click();
//        Thread.sleep(10000);
//        elementHandler.getElement("menu").click();
//        Thread.sleep(10000);




    }
}
