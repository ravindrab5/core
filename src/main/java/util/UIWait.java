package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIWait {

	public UIWait(WebDriver driver, int waitDuration) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, waitDuration);
		log = LogInitilizer.getLogger();
	}

	WebDriver driver;
	WebDriverWait wait;
	Logger log;

	public boolean waitTillElementVisibility(WebElement element) {
		log.info("Waiting for element visibility ");
		boolean status = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			status = true;
		} catch (TimeoutException e) {
			log.debug("models.Element not visible - " + e);
		}
		return status;

	}

	public boolean waitTillElementClickable(WebElement element) {
		log.info("Waiting for element visibility ");
		boolean status = false;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			status = true;
		} catch (TimeoutException e) {
			log.debug("models.Element not clickable - " + e);
		}
		return status;

	}

}
