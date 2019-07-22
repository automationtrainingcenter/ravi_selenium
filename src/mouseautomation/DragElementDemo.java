package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utitlities.BrowserHelper;

public class DragElementDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://jqueryui.com/draggable/");
		sleep(2000);
		//switch to the frame which contains drag element
		driver.switchTo().frame(0);
		//locate the element we want to drag
		WebElement dragEle = driver.findElement(By.id("draggable"));
		//create Actions class Object
		Actions actions = new Actions(driver);
//		actions.clickAndHold(dragEle).moveByOffset(70, 50).release().build().perform();
		actions.dragAndDropBy(dragEle, 70, 50).build().perform();
		sleep(3000);
		closeBrowser();
		
	}
}
