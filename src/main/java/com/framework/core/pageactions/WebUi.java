package com.framework.core.pageactions;

import com.framework.core.handlers.UiNameHandler;
import com.framework.core.handlers.WebElementHandler;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.framework.core.util.LogInitilizer;
import com.framework.core.util.UIWait;


/**
 * Created by Ravindra on 20-09-2019.
 */

public class WebUi {

    private static WebElementHandler element;
    private static EventFiringWebDriver driver;
    private static Logger logger;
    private static String currentPage;
    private static UIWait wait;

    public static void init(EventFiringWebDriver driver,String page,int ui_wait_duration){
        WebUi.driver=driver;
        currentPage=page;
        element=new WebElementHandler(driver,page);
        wait=new UIWait(driver,ui_wait_duration);
        logger= LogInitilizer.getLogger();
    }

    public static void Navigate(String url){
        driver.get(url);
    }

    public static void clickOn(String elementname){


        String next_page=element.getNextPage(elementname);
        String uiname=element.getUiName(elementname);
        WebElement web_element=element.getElement(elementname);
        UiNameHandler.putUiELement(web_element,currentPage+":"+uiname);
        currentPage=next_page;


        wait.waitTillElementVisibility(web_element);
        wait.waitTillElementClickable(web_element);

        web_element.click();


    }

    public static void  typeOn(String elementname,String text){
        //logger.info("Typing text on - "+element.getUiName(elementname) );
        String next_page=element.getNextPage(elementname);
        WebElement webelement=element.getElement(elementname);
        UiNameHandler.putUiELement(webelement,next_page+":"+element.getUiName(elementname));

        wait.waitTillElementVisibility(webelement);
        wait.waitTillElementClickable(webelement);

        webelement.sendKeys(text);
    }


}
