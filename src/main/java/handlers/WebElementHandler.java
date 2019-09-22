package handlers;

import dao.PageDao;
import dao.PageDaoImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

/**
 * Created by Ravindra on 19-09-2019.
 */
public class WebElementHandler {
    private PageDao page_dao;
    private EventFiringWebDriver driver;
    private String nextPage;

    public WebElementHandler(EventFiringWebDriver driver,String page){
        this.driver=driver;
        page_dao=new PageDaoImpl(page);
        nextPage=page;
    }

    public String getUiName(String name){
        return page_dao.getUiName(name);
    }

    public String getNextPage(String name){
        return page_dao.getNextPage(name);
    }

    public WebElement getElement(String name){
        WebElement element=null;
        switch (page_dao.getLocatorType(name)){
            case "id":
                element=driver.findElement(By.id(page_dao.getLocator(name)));
                break;
            case "name":
                element=driver.findElement(By.name(page_dao.getLocator(name)));
                break;
            case "linkText":
                element=driver.findElement(By.linkText(page_dao.getLocator(name)));
                break;
            case "className":
                element=driver.findElement(By.className(page_dao.getLocator(name)));
                break;
            case "css":
                element=driver.findElement(By.cssSelector(page_dao.getLocator(name)));
                break;
            case "xpath":
                element=driver.findElement(By.xpath(page_dao.getLocator(name)));
                break;
        }

        if(!page_dao.getNextPage(name).equals(nextPage)){
            page_dao=new PageDaoImpl(page_dao.getNextPage(name));
            nextPage=page_dao.getNextPage(name);

        }
        return element;
    }

    public List<WebElement> getElements(String name){
        List<WebElement> element=null;

        switch (page_dao.getLocatorType(name)){
            case "id":
                element=driver.findElements(By.id(page_dao.getLocator(name)));
                break;
            case "name":
                element=driver.findElements(By.name(page_dao.getLocator(name)));
                break;
            case "linkText":
                element=driver.findElements(By.linkText(page_dao.getLocator(name)));
                break;
            case "className":
                element=driver.findElements(By.className(page_dao.getLocator(name)));
                break;
            case "css":
                element=driver.findElements(By.cssSelector(page_dao.getLocator(name)));
                break;
            case "xpath":
                element=driver.findElements(By.xpath(page_dao.getLocator(name)));
                break;
        }

        if(page_dao.getNextPage(name)!=nextPage){
            page_dao=new PageDaoImpl(page_dao.getNextPage(name));
            nextPage=page_dao.getNextPage(name);
        }
        return element;
    }
}
