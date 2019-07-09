package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * To handle alerts or JavaScript popups Selenium provides
 * Alert Interface. In this interface we have
 * accept() which will click on ok button of the alert
 * dismiss() which will click on cancel button of the alert
 * sendKeys(String arg) which will type some data in an alert text field
 * getText() return String value i.e. text of the alert
 * 
 * To automate these alerts, first of all switch driver focus from the web page to alert
 * In WebDriver interface we have switchTo() which will return TargetLocator interface refernce
 * In TargetLocator interface we have alert() which will return Alert interface reference
 */

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate enter your name text field
		WebElement nameField = driver.findElement(By.id("name"));
		// type some data in name field
		nameField.sendKeys("surya");
		Thread.sleep(2000);
		// locate alert button and click on it
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		// switch the driver focus to alert
		Alert alert = driver.switchTo().alert();
		// get the text of the alert
		String text = alert.getText();
		System.out.println(text);
		// click on button of the alert using accept() of Alert interface
		alert.accept();
		Thread.sleep(2000);

		// type some thing else in name field
		nameField.sendKeys("sunshine");
		Thread.sleep(2000);
		// locate confirm alert button and click on it
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		// switch the driver focus to alert
		Alert confirmAlert = driver.switchTo().alert();
		// get the text of confirm alert
		String confirmAlertText = confirmAlert.getText();
		System.out.println(confirmAlertText);
		// click on cancel button of the alert using dismiss() of Alert interface
		confirmAlert.dismiss();
		Thread.sleep(2000);

		driver.close();
	}

}
