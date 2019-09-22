package pageactions;

import handlers.UiNameHandler;
import handlers.WebElementHandler;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import util.LogInitilizer;


/**
 * Created by Ravindra on 20-09-2019.
 */

public class WebUi {

    private static WebElementHandler element;
    private static EventFiringWebDriver driver;
    private static Logger logger;
    private static String currentPage;

    public static void init(EventFiringWebDriver driver,String page){
        WebUi.driver=driver;
        currentPage=page;
        element=new WebElementHandler(driver,page);
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




        web_element.click();


    }

    public static void  typeOn(String elementname,String text){
        //logger.info("Typing text on - "+element.getUiName(elementname) );
        String next_page=element.getNextPage(elementname);
        WebElement webelement=element.getElement(elementname);
        UiNameHandler.putUiELement(webelement,next_page+":"+element.getUiName(elementname));
        webelement.sendKeys(text);
    }


}
