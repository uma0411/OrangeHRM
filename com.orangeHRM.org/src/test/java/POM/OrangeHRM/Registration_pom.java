package POM.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Library.Generics;

public class Registration_pom extends Generics {
	By fullname = By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div[1]/input");
	By lastname = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input");
	By address = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea");
	By emailaddress = By.xpath("//*[@id=\"eid\"]/input");
	By phonenumber = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input");
	By lanuage = By.xpath("//*[@id=\"msdd\"]");
	
	

	public WebElement fullname() {
		return (driver.findElement(fullname));
	
	}

	public WebElement enterLastName() {
		return (driver.findElement(lastname));
	}

	public void enteraddress(String fulladdress) {
		driver.findElement(address).sendKeys(fulladdress);
	}

	public void emailaddress(String enteremail) {
		driver.findElement(address).sendKeys(enteremail);
	}

	public void enterphonenumber(String phoneno) {
		driver.findElement(phonenumber).sendKeys(phoneno);
	}

	@FindBy(xpath = "myTe//*[@id=\\\"basicBootstrapForm\\\"]/div[1]/div[1]/inputxt")
	WebElement fullname1;

	public void fullname(String fname) {
		fullname1.sendKeys(fname);
	}
}

//public static WebDriver driver;

//public WebDriver driver;
//public POM_Registration(WebDriver rdriver)
//{
//	driver=rdriver;
//	//PageFactory.initElements(rdriver,this);
//}
//
//

//public void enterfullname(String fname) {
//	driver.findElement(fullname).sendKeys(fname);
//}

//public void enterLastName(String lname) {
//	driver.findElement(lastname).sendKeys(lname);
//}
