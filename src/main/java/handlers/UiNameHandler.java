package handlers;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ravindra on 21-09-2019.
 */
public class UiNameHandler {
    private static Map<WebElement,String> uiname=new HashMap<WebElement,String>();

    public static void putUiELement(WebElement element,String uiname){
        UiNameHandler.uiname.put(element,uiname);
    }

    public static String getUiName(WebElement element){
        return uiname.get(element);
    }

}
