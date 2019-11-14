package com.framework.core.models;

/**
 * Created by Ravindra on 21-09-2019.
 */
public class TestRun {

    private String browser,run_env,os,mobile_web,mobile_native,testngxml,extend_report,testrail_trun_name;
    private boolean isHeadles;

    public boolean isApiTest() {
        return isApiTest;
    }

    private boolean isApiTest;

    private TestRun(TestRunBuilder builder){
        this.browser=builder.browser;
        this.run_env=builder.run_env;
        this.os=builder.os;
        this.mobile_web=builder.mobile_web;
        this.mobile_native=builder.mobile_native;
        this.testngxml=builder.testngxml;
        this.extend_report= builder.extend_report;
        this.testrail_trun_name=builder.testrail_trun_name;
        this.isHeadles=builder.isHeadles;
        this.isApiTest=builder.isApiTest;
    }

    public String toString(){
        String str="\n\n{\n" +
                "\tbrowser:\t"+browser+",\n"+
                "\trun_env:\t"+run_env+",\n"+
                "\tos:\t"+os+",\n"+
                "\tmobile_web:\t"+mobile_web+",\n"+
                "\tmobile_native:\t"+mobile_native+",\n"+
                "\ttestngxml:\t"+testngxml+",\n"+
                "\textend_report:\t"+extend_report+",\n"+
                "\ttestrail_trun_name:\t"+testrail_trun_name+",\n"+
                "\tisHeadles:\t"+isHeadles+",\n"+
                "\tisApiTest:\t"+isApiTest+"\n"+
                "}";
        return str;
    }

    public String getBrowser() {
        return browser;
    }

    public String getRun_env() {
        return run_env;
    }

    public String getOs() {
        return os;
    }

    public String getMobile_web() {
        return mobile_web;
    }

    public String getMobile_native() {
        return mobile_native;
    }

    public String getTestngxml() {
        return testngxml;
    }

    public String getExtend_report() {
        return extend_report;
    }

    public String getTestrail_trun_name() {
        return testrail_trun_name;
    }

    public boolean isHeadles() {
        return isHeadles;
    }

    public static class TestRunBuilder{
        private String browser,run_env,os,mobile_web,mobile_native,testngxml,extend_report,testrail_trun_name;
        private boolean isHeadles;

        public TestRunBuilder setApiTest(boolean apiTest) {
            isApiTest = apiTest;
            return this;
        }

        private boolean isApiTest;

        public TestRunBuilder setBrowser(String browser) {
            this.browser = browser;
            return this;
        }

        public TestRunBuilder setRun_env(String run_env) {
            this.run_env = run_env;
            return this;
        }

        public TestRunBuilder setOs(String os) {
            this.os = os;
            return this;
        }

        public TestRunBuilder setMobile_web(String mobile_web) {
            this.mobile_web = mobile_web;
            return this;
        }

        public TestRunBuilder setMobile_native(String mobile_native) {
            this.mobile_native = mobile_native;
            return this;
        }

        public TestRunBuilder setTestngxml(String testngxml) {
            this.testngxml = testngxml;
            return this;
        }

        public TestRunBuilder setExtend_report(String extend_report) {
            this.extend_report = extend_report;
            return this;
        }

        public TestRunBuilder setTestrail_trun_name(String testrail_trun_name) {
            this.testrail_trun_name = testrail_trun_name;
            return this;
        }

        public TestRunBuilder setHeadles(boolean headles) {
            isHeadles = headles;
            return this;
        }



        public TestRun build(){
            return new TestRun(this);
        }
    }

}
