package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;
import utitlities.JavaScripHelper;

public class BringElementToView extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.amazon.in");
		sleep(2000);
		WebElement backToTop = driver.findElement(By.id("navBackToTop"));
		int height = driver.findElement(By.id("navbar")).getSize().getHeight();
		
		//create JavaScriptExecutor object reference
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView()", backToTop);
//		js.executeScript("document.documentElement.scrollBy(0, arguments[0])", -150);
		
		//using JavaScriptHelper
		JavaScripHelper.getElementToView(driver, backToTop);
		
		sleep(3000);
		JavaScripHelper.scrollPageBy(driver, 0, -1*height);
		sleep(3000);
		closeBrowser();
	}

}
