package com.framework.core.driverfactory;

import java.io.File;
import java.net.MalformedURLException;

import com.framework.core.models.TestRun;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.framework.core.util.ResourceUtil;


public class ChromeDriverManager extends DriverManager{
	private ChromeDriverService chService;
	private TestRun testRun;
	public ChromeDriverManager(TestRun testRun)
	{
		this.testRun=testRun;
	}

	@Override
	public void startService() {
		if (null == chService) {
			try {

				File f = new ResourceUtil().getFile("driver/chromedriver.exe");
				chService = new ChromeDriverService.Builder().usingDriverExecutable(f).usingAnyFreePort().build();
				chService.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stopService() {
		if (null != chService && chService.isRunning())
			chService.stop();
	}

	@Override
	public void createDriver(){
		//startService();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");

		if(testRun.isHeadles()){
			options.addArguments("--headless");
		}

		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		if(testRun.getRun_env().equals("local")) {
			String url="http://localhost:4444/wd/hub";
			try {
				driver = new RemoteWebDriver(new java.net.URL(url), capabilities);
			}catch (MalformedURLException me){

			}
		}

	}

}
