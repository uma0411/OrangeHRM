package POM.OrangeHRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Library.Generics;
public class Orange_POM extends Generics {
	By username = By.name("username");
	By password = By.name("password");
	By loginbutton = By.xpath("//*[@type='submit']");
	public WebElement username() {
		return (driver.findElement(username));
	}
	public WebElement password() {
		return (driver.findElement(password));
	}
	public WebElement login() {
		return (driver.findElement(loginbutton));
	}
}
