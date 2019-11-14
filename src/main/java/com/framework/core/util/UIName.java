package com.framework.core.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.openqa.selenium.WebElement;
@Retention(RetentionPolicy.RUNTIME)
public @interface UIName {
	 String uiName();
     
}
