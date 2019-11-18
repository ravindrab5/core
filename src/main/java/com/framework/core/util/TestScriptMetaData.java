package com.framework.core.util;

import java.lang.reflect.Method;

import com.framework.core.models.TestCase;
import org.testng.annotations.Test;





public class TestScriptMetaData {
     private static TestCase testcase;

     public static void  setTestCaseData(Method method) {
    	 Test test = method.getAnnotation(Test.class);
	        if (test == null) {
	            return;
	        }
	        if(testcase==null) {
	        	testcase=new TestCase();
	        }
	        testcase.setName(test.testName());
	        testcase.setDescription(test.description());
	 }
     
     public static TestCase getTestCase() {
    	return testcase;
     }

}
