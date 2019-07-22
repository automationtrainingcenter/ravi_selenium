package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utitlities.BrowserHelper;

public class MouseHoverDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.amazon.in");
		String subMenuItem1 = "TV, Appliances, Electronics";
		String subMenuItem2 = "DSLR Cameras";
		
		//locate shop by category element
		WebElement shopByCatEle = driver.findElement(By.id("nav-link-shopall"));
		/*
		 * To automate mouse events Selenium provides Actions class
		 * In this class we have several methods to perform mouse related events
		 * What ever the action we are performing on any element using Actions class,
		 * we have to build and perform that action. here build and perform are methods 
		 * in actions class
		 */
		Actions actions = new Actions(driver);
		actions.moveToElement(shopByCatEle).build().perform();
		sleep(3000);
		
		
		//locate mobiles and computers
		WebElement subMenu1 = driver.findElement(By.xpath("//span[@aria-label='"+subMenuItem1+"']"));
		actions.moveToElement(subMenu1).build().perform();
		sleep(2000);
		
		//locate power banks 
		WebElement subMenu2 = driver.findElement(By.xpath("//span[text()='"+subMenuItem2+"']"));
		actions.moveToElement(subMenu2).click().build().perform();
		sleep(2000);
		
		
		closeBrowser();
	}
}
