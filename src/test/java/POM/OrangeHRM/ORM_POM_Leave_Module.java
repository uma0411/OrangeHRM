package POM.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Library.Generics;

public class ORM_POM_Leave_Module extends Generics{
	
	By Leave = By.xpath("//span[text()='Leave']");
	By Entitlements=By.xpath("//span[text()='Entitlements ']");
	By Entitlementdropdown=By.xpath("//*[@class=\"oxd-dropdown-menu\"]");
	By AddEntitlements = By.xpath("//a[text()='Add Entitlements']");
	By IndividualEmployee=By.xpath("//*[text()='Individual Employee']");
	By EmployeeName=By.xpath("//input[@placeholder=\"Type for hints...\"]");
	By EmployeeNamelistbpx=By.xpath("//div[@role='listbox']");
	By LeaveType=By.xpath("(//*[@class=\"oxd-select-text-input\"])[1]");
	By Leaveoption=By.xpath("//*[@role='option']");
	By LeavePeriod=By.xpath("(//*[@class=\"oxd-select-text-input\"])[2]");
	By LeavePeriodListbox=By.xpath("//*[@role=\"listbox\"]");
	By Entitlement=By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
	By savebutton=By.xpath("//*[text()=' Save ']");
	By confirm=By.xpath("//*[text()=' Confirm ']");
	
	public WebElement Leave() {
		return (driver.findElement(Leave));
	}
	public WebElement Entitlements() {
		return (driver.findElement(Entitlements));
	}
	public WebElement AddEntitlements() {
		return (driver.findElement(AddEntitlements));
	}
	public WebElement IndividualEmployee() {
		return (driver.findElement(IndividualEmployee));
	}
	public WebElement EmployeeName() {
		return (driver.findElement(EmployeeName));
	}
	public WebElement LeaveType() {
		return(driver.findElement(LeaveType));
	}
	
	public WebElement Leaveoption() {
		return(driver.findElement(Leaveoption));
	}
	
	
	public WebElement LeavePeriod() {
		return (driver.findElement(LeavePeriod));
	}
	public WebElement Entitlement() {
		return (driver.findElement(Entitlement));
	}
	public WebElement savebutton() {
		return(driver.findElement(savebutton));
	}
	public WebElement conformbtn() {
		return(driver.findElement(confirm));
	}
	
}


//div[@role="listbox"]