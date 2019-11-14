package com.framework.core.util;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:Properties/${env}.properties" // mention the property file name
})
public interface Environment extends Config {

	String browser();
	
	String hubip();
     
    String url();
    
    @Key("dispatch.username")
    String dispatchUsername();
    
	@Key("dispatch.password")
	String dispatchPassword();
	
   
}