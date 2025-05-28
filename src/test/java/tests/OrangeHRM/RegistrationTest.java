package tests.OrangeHRM;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Library.BrowserInvoke;
import Library.Generics;
import POM.OrangeHRM.Orange_POM;
import POM.OrangeHRM.Registration_pom;

public class RegistrationTest extends BrowserInvoke {
	public static Registration_pom pomregistration = new Registration_pom();
	public static Orange_POM orange_pom=new Orange_POM();
	@Test(priority=0)
	public static void darwin() throws IOException {
		System.out.println(Generics.propertyfile("Properties_OrangeHRM","AdactinURL"));
		driver.get(Generics.propertyfile("Properties_OrangeHRM","AdactinURL"));

		String title=driver.getTitle();
		if (title.contains(".")) {
			System.out.println("Title of the Page :"+ title);
			Reporter.log("Title of the Page :"+ title);
		}else {
			System.out.println("Title Has no Issues...");
			Reporter.log("Title of the Page :"+ title);		
		}
		ScreenshotCapture();
		Reporter.log("darwin application launched successfully");
	}	
	@Test(priority=1)
	public static void orangehrmlogintest() throws Exception {
		driver.get(Generics.propertyfile("Properties_OrangeHRM","URL"));
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
		Sleep2k();
		ScreenshotCapture();
		Reporter.log("orange hrm login sucessfully completed");
	}

	
	
	
	
	
	
	
//	@Test(priority=2)
//	public static void test() {
//		Reporter.log("");
//	}
}




////@Test(priority = 1)
//	public static void registrationpage() throws IOException {
////		driver.get(Generics.propertyfile("URL"));
//		String str= driver.getTitle();
//		if (str.contains(".")) {
//			System.out.println("Title of the Page :"+ str);
//			Reporter.log("Title of the Page :"+ str);
//		}else {
//			System.out.println("Title Has no Issues...");
//			Reporter.log("Title of the Page :"+ str);		
//		}
//		
//		
//		try {
//			if ((pomregistration.fullname()).isDisplayed()) {
//				pomregistration.fullname().sendKeys(Generics.propertyfile("fullname"));
//				Reporter.log("Successfully Entered the Data in the Full name Text Field");
//				
//			}
//			String sr=pomregistration.fullname().getAttribute("value");
//			
//			if (sr.equalsIgnoreCase(Generics.propertyfile("fullname"))) {
//				Reporter.log("Successfully Entered Value : "+ sr);
//			}else {
//				Reporter.log("Issue with entering data...........");
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//			Reporter.log("Exception : "+ e.getMessage());
//		}
//		
//		
//
//		try {
//			if((pomregistration.enterLastName()).isDisplayed()) {
//				pomregistration.enterLastName().sendKeys(Generics.propertyfile("lastname"));
//			}
//			String strr=pomregistration.enterLastName().getAttribute("value");
//			if(strr.equalsIgnoreCase(Generics.propertyfile("lastname")))
//				Reporter.log("Successfully entered the lastname data "+ strr);
//			else {
//				Reporter.log("issue with entering lastname data--");
//				
//			}
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
//	}



//pomregistration.enterLastName("upperla");
//pomregistration.enteraddress("khammam");
//pomregistration.emailaddress("sindhuupperla569@gmail.com");
//pomregistration.enterphonenumber("9876543211");