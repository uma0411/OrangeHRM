package tests.OrangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Library.Generics;

public class ORM_Leave_Test extends Generics {
	public static POM.OrangeHRM.ORM_POM_Leave_Module ORM_POM_Leave_Module = new POM.OrangeHRM.ORM_POM_Leave_Module();
	public static String Leave_Header = "";

	
	@Test(priority = 0, groups = { "EntitleMents" })
	public static void entity() throws Exception {		
		// ORM_Login_Test.orangehrmlogintest();
		Sleep2k();
		if ((ORM_POM_Leave_Module.Leave()).isDisplayed()) {
			click_element(ORM_POM_Leave_Module.Leave());
			Sleep2k();
			Sleep2k();
			WebElement ele = driver.findElement(By.xpath("(//*[text()='Leave'])[2]"));
			Sleep2k();
			Leave_Header = ele.getText();
			if (ele.isDisplayed()) {
				System.out.println("We are in Correct Page....");
			}
		} else {
			System.out.println("Element is not in the Page ........");
		}
		
		driver.findElement(By.xpath("//*[text()='-- Select --']")).click();
		List<WebElement> options = driver.findElements(By.xpath("//*[@role='option']"));
		System.out.println(options.size());
		System.out.println("tesct");
	}

	
	
	
	@Test(priority = 1, dependsOnMethods = "entity", groups = { "EntitleMents" })
	public static void entitlements() throws Exception {
		Sleep2k();
		if (Leave_Header.equalsIgnoreCase("Leave")) {
			click_element(ORM_POM_Leave_Module.Entitlements());
		} else {
			System.out.println("Leave has Issues in the Header Text........");
		}

	}

	
	@Test(priority = 2, dependsOnMethods = "entitlements", groups = { "EntitleMents" })
	public static void addentitlements() throws Exception {
		Sleep2k();
		if (ORM_POM_Leave_Module.AddEntitlements().isDisplayed()) {
			click_element(ORM_POM_Leave_Module.AddEntitlements());
			Reporter.log("clicked on add entitlements..........");
		} else {
			System.out.println("add entitlements element is not displayed on the page............");
		}
		
		Sleep2k();
		click_element(ORM_POM_Leave_Module.IndividualEmployee());
		if ((ORM_POM_Leave_Module.EmployeeName().isDisplayed())) {
			// sendkeys_WebElement((ORM_POM_Leave_Module.EmployeeName()),Generics.propertyfile("Properties_OrangeHRM",
			// "employeenames"));
			sendkeys_WebElement((ORM_POM_Leave_Module.EmployeeName()), "j");
			Reporter.log("successfully entered the employee name----");
		} else {
			System.out.println("data was not entered into employee name field..........");
		}

		// String str = ORM_POM_Leave_Module.EmployeeName().getAttribute("value");
		// System.out.println(str);
		Sleep2k();
		WebElement ele = driver.findElement(By.xpath("//*[@role=\"option\"]"));
		waitForElementToBeVisible(ele, 2000000);
		List<WebElement> optlist = driver.findElements(By.xpath("//*[@role='option']"));
		try {
			for (int i = 0; i < optlist.size(); i++) {
				Sleep2k();
   				WebElement element = optlist.get(i);
				Sleep2k();
				if (element.getText().equals("Linda Jane Anderson")) {
					optlist.get(i).click();
					Sleep2k();
				}
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());

		}
	}

	
	
	@Test(priority = 3, dependsOnMethods = "addentitlements", groups = { "EntitleMents" })
	public static void leavetype() throws Exception {
		Sleep2k();
		Sleep2k();
		driver.findElement(By.xpath("(//*[text()='-- Select --'])[1]")).click();
		WebElement element = driver.findElement(By.xpath("//*[@role='option']"));
		// element.click();
		waitForElementToBeVisible(element, 3000);
		Sleep2k();
		List<WebElement> options = driver.findElements(By.xpath("//*[@role='option']"));
		System.out.println(options.size());
		try {
			for (int i = 0; i < options.size(); i++) {
			
				WebElement elemnt = options.get(i);
				Sleep2k();
				if (elemnt.getText().equals("CAN - Matternity")) {
					options.get(i).click();
					Sleep2k();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

	}
	
	

	@Test(priority = 4, dependsOnMethods = "leavetype", groups = { "EntitleMents" })
	public static void leaveperiod() throws Exception {
		Sleep2k();
		WebElement elemnt = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/div/div/div[1]"));
		elemnt.click();
		waitForElementToBeVisible(elemnt, 3000);
		Sleep2k();
	//	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/div/div/div[1]")).click();
		WebElement element = driver.findElement(By.xpath("//*[@role='option']"));
		// element.click();
		waitForElementToBeVisible(element, 3000);
		Sleep2k();
		List<WebElement> options = driver.findElements(By.xpath("//*[@role='option']"));
		System.out.println(options.size());
		try {
			for (int i = 0; i < options.size(); i++) {
				Sleep2k();
				WebElement element1 = options.get(i);
				Sleep2k();
				if (elemnt.getText().equals("2022-01-01 - 2022-12-31")) {
					options.get(i).click();
					Sleep2k();
				}
			}
		} catch (Exception e) {

		}
	}

	
	
	@Test(priority = 5, dependsOnMethods = "leaveperiod", groups = { "EntitleMents" })
	public static void entitlementfield() throws Exception {
		Sleep2k();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[3]/div/div[2]/input")).sendKeys("12");
		Sleep2k();
	}
	
	
	@Test(priority = 6, dependsOnMethods = "entitlementfield", groups = { "EntitleMents" })
	public static void savebutton() throws Exception {
		
		click_element(ORM_POM_Leave_Module.savebutton());
		Sleep2k();
	}
	
	
	@Test(priority = 7, dependsOnMethods = "savebutton", groups = { "EntitleMents" })
	public static void conformbutton() throws Exception {
		click_element(ORM_POM_Leave_Module.conformbtn());
		Sleep2k();
	}
	
	
}

//String str = ORM_POM_Leave_Module.EmployeeName().getAttribute("value");
//System.out.println(str);
//if (str.equalsIgnoreCase("employeenames")) {
//	System.out.println("successfully entered the data in employee name field........");
//} else {
//	System.out.println("issue with entered data.........");
//}