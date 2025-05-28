package tests.OrangeHRM;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Library.BrowserInvoke;
import Library.Generics;

public class ORM_Time_Test extends BrowserInvoke {
	public static POM.OrangeHRM.ORM_POM_Time_Module Time_Module = new POM.OrangeHRM.ORM_POM_Time_Module();
	public static String time_header = "";
	
	@Test(priority = 0)
	public static void time() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a/span")).click();
		Thread.sleep(3000);
//		if ((Time_Module.Time()).isDisplayed()) {
//			Generics.Sleep2k();
//			Generics.Sleep2k();
//			Generics.click_element(Time_Module.Time());
//
//			WebElement time = driver.findElement(By.xpath("//*[text()='Timesheets']"));
//			time_header = time.getText();
//			if (time.isDisplayed()) {
//				System.out.println("we are in correct page---------" + time_header);
//			} else {
//				System.out.println("we are not in correct page------");
//			}
//		}
	}

	@Test(priority = 1)
	public static void employeename() throws Exception {
		Thread.sleep(3000);
		if (time_header.equalsIgnoreCase("Timesheets")) {
			Thread.sleep(3000);
			Generics.click_element(Time_Module.Employeename());
			Thread.sleep(3000);
			Generics.sendkeys_WebElement(Time_Module.Employeename(),Generics.propertyfile("Properties_OrangeHRM", "employeename"));
		}
	}
}
