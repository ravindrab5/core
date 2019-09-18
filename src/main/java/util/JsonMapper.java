package util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {
	Class cls;
	public void setCls(Class cls) {
		this.cls = cls;
	}

	File filepath;
	public void setFilepath(File filepath) {
		this.filepath = filepath;
	}

	ObjectMapper objectMapper;
	Logger log;
	
	public JsonMapper() {
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		log=LogInitilizer.getLogger();
	}
	

	public JsonMapper(String filepath, Class cls) {
		this.cls = cls;
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.filepath=new File(filepath);
		log=LogInitilizer.getLogger();
	}

	public Object getData(){
		Object obj = null;
		try {
			obj = objectMapper.readValue(filepath, cls);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			log.fatal(e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			log.fatal(e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.fatal(e);
			e.printStackTrace();
		} catch(Exception e) {
			// Need to write Exception
			log.fatal(e);
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public Map<String,String> getOemBusType(){
		Map<String, String> jsonMap = null;
		try {
			jsonMap = objectMapper.readValue(filepath,
				    new TypeReference<Map<String,String>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	public Map<String,List<String>> getBuses(){
		Map<String, List<String>> jsonMap = null;
		try {
			jsonMap = objectMapper.readValue(filepath,
				    new TypeReference<Map<String,List<String>>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}
	
	public Map<String,List<String>> getVoltage(){
		Map<String, List<String>> jsonMap = null;
		try {
			jsonMap = objectMapper.readValue(filepath,
				    new TypeReference<Map<String,List<String>>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
	}

	
}
