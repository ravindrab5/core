package com.framework.core.tests;

import com.beust.jcommander.internal.Lists;
import com.framework.core.testInit.TestBase;
import com.framework.core.handlers.ArgumentHandler;
import com.framework.core.models.TestRun;
import org.testng.TestNG;

import java.util.List;

/**
 * Created by Ravindra on 22-09-2019.
 */
public class Runner {
    public static void main(String[] args){
        TestRun testRun= ArgumentHandler.getTestRun(args);
        String xml=testRun.getTestngxml();
        TestBase.testRun=testRun;

        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("./"+xml+".xml");
        System.out.println(suites);
        testng.setTestSuites(suites);
        testng.run();

    }
}
