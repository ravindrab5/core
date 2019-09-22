package driverfactory;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.ResourceUtil;


public class ChromeDriverManager extends DriverManager{
	private ChromeDriverService chService;

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
	public void createDriver() {
		startService();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new RemoteWebDriver(chService.getUrl(), capabilities);
	}

}
