package POM.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Library.Generics;

public class ORM_POM_Time_Module extends Generics {
	
	By Time=By.xpath("(//*[contains(text(),'Time')])[1]");
	By Employeename=By.xpath("//*[@placeholder='Type for hints...']");
	By View=By.xpath("//*[@type='submit']");
	
	
	public WebElement Time() {
		return (driver.findElement(Time));
	}
	public WebElement Employeename() {
		return (driver.findElement(Employeename));
	}
	public WebElement View() {
		return (driver.findElement(View));
	}
	
	
	//*[text()=' View '])[1]
	//*[@type='submit']

}
