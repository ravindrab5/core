package util;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Capabilities {
	Map<String, String> cap;

	public Capabilities(File filepath) {
		super();
		ObjectMapper objectMapper;
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			cap = objectMapper.readValue(filepath, new TypeReference<Map<String, String>>() {
			});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DesiredCapabilities getCapability() {
		DesiredCapabilities capabilties;
		capabilties = new DesiredCapabilities();
		Set<String> keys = cap.keySet();
		for (String str : keys) {
			capabilties.setCapability(str, cap.get(str));
		}

		return capabilties;
	}

	public String toString() {
		return cap.toString();
	}
}
