package com.framework.core.handlers;

import com.framework.core.models.TestRun;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.log4j.Logger;
import com.framework.core.util.LogInitilizer;

/**
 * Created by Ravindra on 21-09-2019.
 */
public class ArgumentHandler {
    private static String web_browser,run_env,os,mobile_web,mobile_native,api,tfiles,testngxml,extend_report,testrail_trun_name;
    private static boolean headless;
    private static TestRun testRun=null;

    public static TestRun getTestRun(String[] args){
        Logger logger= LogInitilizer.getLogger();

        if(args==null){
            logger.info("Required args not passed ");
            System.exit(0);
            return null;
        }

        if(testRun==null){
            TestRun.TestRunBuilder builder=new TestRun.TestRunBuilder();


            logger.info("Setting commandline options --------- ");
            // parsing the options
            Options option=new Options();

            option.addOption("browser",true,"Chrome is default browser");

            option.addOption("run_env",true,"Set local if not passed");
            option.addOption("os",true,"Set to windows if not passed");
            option.addOption("mobile_web",true,"Set to mobile_chrome_capabilities.json if not passed");
            option.addOption("mobile_native",true,"Set to app_info.json if not passed");
            option.addOption("api",true,"Set to false by default");
            option.addOption("headless",true,"Set to false by default");
            option.addOption("testngxml",true,"Set to testng.xml by default");
            option.addOption("extend_report",true,"Set to null by default");
            option.addOption("testrail_trun_name",true,"Set to TestRun by default");

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd=null;

            try{
                cmd = parser.parse( option, args);

            web_browser=cmd.getOptionValue("browser");
            run_env=cmd.getOptionValue("run_env");
            os=cmd.getOptionValue("os");
            mobile_web=cmd.getOptionValue("mobile_web");
            mobile_native=cmd.getOptionValue("mobile_native");
            api=cmd.getOptionValue("api");
            headless=Boolean.parseBoolean(cmd.getOptionValue("headless"));
            testngxml=cmd.getOptionValue("testngxml");
            extend_report=cmd.getOptionValue("extent_report");
            testrail_trun_name=cmd.getOptionValue("testrail_trun_name");
            }catch (Exception e){
                logger.info("Exception - "+e);

            }


            if(web_browser==null && mobile_web==null && mobile_native==null && api==null){
                logger.info("Either of web_browser / mobile_web / mobile_native / api not passed in command line");
                System.exit(0);
            }

            if(web_browser!=null && mobile_web==null && mobile_native==null && api==null){
                builder.setBrowser(web_browser);
            }else if(web_browser==null && mobile_web!=null && mobile_native==null && api==null){
                builder.setMobile_web(mobile_web);
            }else if(web_browser==null && mobile_web==null && mobile_native!=null && api==null){
                builder.setMobile_native(mobile_native);
            }else if(web_browser==null && mobile_web==null && mobile_native==null && api!=null){
                builder.setApiTest(Boolean.parseBoolean(api));
            }else{
                logger.info("Cannot run multiple runs at same time");
                System.exit(0);
            }

            if(run_env!=null){
                builder.setRun_env(run_env);
            }else{
                builder.setRun_env("local");
            }


            if(os!=null){
                builder.setOs(os);
            }else{
                builder.setOs("windows");
            }


            if(headless){
                builder.setHeadles(headless);
            }else{
                builder.setHeadles(false);
            }

            if(testngxml!=null){
                builder.setTestngxml(testngxml);
            }else{
                builder.setTestngxml("testng");
            }

            if(extend_report!=null){
                builder.setExtend_report(extend_report);
            }

            if(testrail_trun_name!=null){
                builder.setTestrail_trun_name(testrail_trun_name);
            }
            testRun=builder.build();
            logger.info("Test run set options : "+testRun);
            return testRun;
        }
        return testRun;

    }

}
