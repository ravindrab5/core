package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelect {
	EventFiringWebDriver driver;
	Select select;
	
	public DropDownSelect(EventFiringWebDriver driver) {
		this.driver=driver;
	}
	
	public void SelectByText(WebElement element,String text) {
		select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void SelectByValue(WebElement element,String text) {
		select=new Select(element);
		select.selectByValue(text);
	}
	
	public void deselectAllElements(WebElement element) {
		select=new Select(element);
		select.deselectAll();
	}
	
}
