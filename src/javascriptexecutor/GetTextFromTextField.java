package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;
import utitlities.JavaScripHelper;

public class GetTextFromTextField extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.facebook.com");
		WebElement emailEle = driver.findElement(By.id("email"));
		emailEle.sendKeys("sunshine");
		sleep(1000);
		/*
		 * To execute javascript Selenium provides JavaScriptExecutor interface
		 * which is implemented by RemoteWebDriver.
		 * typecase WebDriver object to JavaScriptExecutor object to call it's methods
		 */
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String emailText = js.executeScript("return arguments[0].value", emailEle).toString();
		System.out.println(emailText);
		
		
		//using JavaScriptHelper
		WebElement pass = driver.findElement(By.id("pass"));
//		pass.sendKeys("selenium");
		js.executeScript("arguments[0].value = arguments[1]", pass, "prakash");
		
		sleep(1000);
		
		String passwordText = JavaScripHelper.getTextBoxValue(driver, pass);
		System.out.println(passwordText);
		
		closeBrowser();
		
	}

}
