package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import POM.OrangeHRM.Orange_POM;

public class Generics {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static String str;
	public static WebDriverWait wait;
	public static Orange_POM orange_pom=new Orange_POM();
	public static String propertyfile(String PropFileName, String string) throws IOException {
		try {
			FileInputStream fis = new FileInputStream("./Resources/Config_Files/" + PropFileName + ".properties");
			prop.load(fis);
			str = prop.getProperty(string);
		} catch (Exception e) {
			System.out.println("File Not Found :" + e.getMessage());
		}
		return str;
	}

	public static void sendkeys(By locator, String path) {
		try {
			WebElement sendtext = driver.findElement(locator);
			if (sendtext.isDisplayed()) {
				sendtext.sendKeys(path);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	public static void sendkeys_WebElement(WebElement ele, String path) throws Exception {
		Thread.sleep(2000);
		if(ele.isDisplayed()) {
			ele.sendKeys(path);
		}
	
	}

	public static List<WebElement> listofelements(String path) {
		List<WebElement> listelement = driver.findElements(By.xpath(path));
		return listelement;
	}

	public static List<String> listofelement(String path) {
		List<WebElement> listelement = driver.findElements(By.xpath(path));
		List<String> eleText = new ArrayList<String>();
		for (int i = 0; i < listelement.size(); i++) {
			String str = listelement.get(i).getText();
			eleText.add(str);
		}
		return eleText;
	}

	public static Map<Integer, String> MapListelement(String path) {
		List<WebElement> listelement = driver.findElements(By.xpath(path));
		Map<Integer, String> eleText = new HashMap<Integer, String>();
		for (int i = 0; i < listelement.size(); i++) {
			String str = listelement.get(i).getText();
			eleText.put(i, str);
		}
		return eleText;
	}

	public static Map<Integer, WebElement> KeyValueelement(String path) {
		List<WebElement> listelement = driver.findElements(By.xpath(path));
		Map<Integer, WebElement> eleText = new HashMap<Integer, WebElement>();
		for (int i = 0; i < listelement.size(); i++) {
			WebElement str = listelement.get(i);
			eleText.put(i, str);
		}
		return eleText;
	}

	public static void scrolltoviewelement(WebElement element) {
		try {
			if (element.isDisplayed()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView", element);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String customizeddate() {
		Date date = new Date();
		String str = date.toString();
		String finalstr = str.replace(":", "");
		String string = finalstr.replace(" ", "");
		return string;
	}

	public static void ScreenshotCapture() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot\\" + customizeddate() + ".png");
		FileUtils.copyFile(src, dest);
		Reporter.log("Validation Is completed Successfully......." + "<a href='" + dest.getAbsolutePath()
				+ "' target=_blank'>clickhere</a>");
	}

	public static void actionclick(By locator) {
		try {
			WebElement ele = driver.findElement(locator);
			Actions action = new Actions(driver);
			if (ele.isDisplayed()) {
				action.click(ele).build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Sleep2k() throws Exception {
		Thread.sleep(2000);
	}

	public void waitForElementToBeClickable(WebElement attributeValue, int waitTime) {
		wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(attributeValue));
	}

	public static void waitForElementToBeVisible(WebElement attributeValue, int waitTime) {
		wait = new WebDriverWait(driver, waitTime);
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOf(attributeValue));
	}

	public void waitForElementToBePresent(By attributeValue, int waitTime) {
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.presenceOfElementLocated(attributeValue));
	}

	public void impicitwait(int TimeOut) {
		driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
	}

	public static void click_element(WebElement ele) throws Exception {
		Sleep2k();
		if(ele.isDisplayed())
		{
		ele.click();
		}
	}
	public static void orangehrmlogintest() throws Exception {
		driver.get(Generics.propertyfile("Properties_OrangeHRM","URL"));
		Sleep2k();
		Sleep2k();
		String title=driver.getTitle();
		if (title.contains(".")) {
			System.out.println("Title of the Page :"+ title);
			Reporter.log("Title of the Navigated Page :"+ title);
		}else {
			System.out.println("Title Has no Issues...");
			Reporter.log("Title of the Navigated Page :"+ title);		
		}
		Sleep2k();
		Generics.sendkeys_WebElement(orange_pom.username(), Generics.propertyfile("Properties_OrangeHRM","username"));
		Generics.sendkeys_WebElement(orange_pom.password(),Generics.propertyfile("Properties_OrangeHRM","password"));
		orange_pom.login().click();
		//Sleep2k();
		ScreenshotCapture();
		Reporter.log("orange hrm login sucessfully completed");
	
	}

}
