package tests.OrangeHRM;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Library.BrowserInvoke;
import Library.Generics;
import POM.OrangeHRM.Orange_POM;

public class ORM_Login_Test extends BrowserInvoke{
			
	public static Orange_POM orange_pom=new Orange_POM();
//	@Test
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
