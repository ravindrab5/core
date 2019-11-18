package com.framework.core.testInit;

import com.framework.core.models.TestRun;
import com.framework.core.pageactions.Page;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Ravindra on 22-09-2019.
 */
public class TestBase {
    public static TestRun testRun;
    protected EventFiringWebDriver driver;
    protected Page WebUi;

}
