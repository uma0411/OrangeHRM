package Library;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInvoke extends Generics {

	@BeforeTest
	public static void browserinvoke() throws IOException, Exception {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		opt.setExperimentalOption("prefs", prefs);
		opt.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		opt.addArguments("start-maximized");
		driver = new ChromeDriver(opt);
		driver.manage().deleteAllCookies();
		orangehrmlogintest();
	}

	
	@AfterTest
	public static void closebrowser() {
		driver.quit();
	}

}
