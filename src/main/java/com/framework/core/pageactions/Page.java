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

public class Page {

    private WebElementHandler element;
    private EventFiringWebDriver driver;
    private Logger logger;
    private String currentPage;
    private UIWait wait;

    public  Page(EventFiringWebDriver driver,String page,int ui_wait_duration){
        this.driver=driver;
        this.currentPage=page;
        this.element=new WebElementHandler(driver,page);
        wait=new UIWait(driver,ui_wait_duration);
        logger= LogInitilizer.getLogger();
    }

    public  void Navigate(String url){
        driver.get(url);
   }

    public  void clickOn(String elementname){


        String next_page=element.getNextPage(elementname);
        String uiname=element.getUiName(elementname);
        WebElement web_element=element.getElement(elementname);
        UiNameHandler.putUiELement(web_element,currentPage+":"+uiname);
        currentPage=next_page;


        wait.waitTillElementVisibility(web_element);
        wait.waitTillElementClickable(web_element);

        web_element.click();


    }

    public void typeOn(String elementname,String text){
        //logger.info("Typing text on - "+element.getUiName(elementname) );
        String next_page=element.getNextPage(elementname);
        WebElement webelement=element.getElement(elementname);
        UiNameHandler.putUiELement(webelement,next_page+":"+element.getUiName(elementname));

        wait.waitTillElementVisibility(webelement);
        wait.waitTillElementClickable(webelement);

        webelement.sendKeys(text);
    }

    public String getText(String elementname){
        //logger.info("Typing text on - "+element.getUiName(elementname) );
        String next_page=element.getNextPage(elementname);
        WebElement webelement=element.getElement(elementname);
        UiNameHandler.putUiELement(webelement,next_page+":"+element.getUiName(elementname));

        wait.waitTillElementVisibility(webelement);
        wait.waitTillElementClickable(webelement);

        return webelement.getText();
        //webelement.sendKeys(text);
    }

    public static void  pauseExecution(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
