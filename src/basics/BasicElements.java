package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElements {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// automate text box
		WebElement nameTextBox = driver.findElement(By.id("name"));
		nameTextBox.sendKeys("sunshine");
		Thread.sleep(3000);
		nameTextBox.clear();
		Thread.sleep(3000);
		nameTextBox.sendKeys(Keys.SHIFT + "sunshine");
		Thread.sleep(2000);
//		nameTextBox.sendKeys(Keys.chord(Keys.CONTROL, Keys.ALT, Keys.DELETE));

		// automate radio button
		WebElement bmwRadio = driver.findElement(By.id("bmwradio"));
		bmwRadio.click();
		Thread.sleep(2000);

		driver.findElement(By.id("hondaradio")).click();
		Thread.sleep(2000);
		if (!bmwRadio.isSelected()) {
			System.out.println("bmw radio button deselected");
		}

		// automate checkbox
		// select benz check box
		WebElement benzCheck = driver.findElement(By.id("benzcheck"));
		if (!benzCheck.isSelected()) {
			benzCheck.click();
		}
		Thread.sleep(2000);
		// deselect benz check box
		if (benzCheck.isSelected()) {
			benzCheck.click();
		}
		Thread.sleep(2000);
		
		//automate button
		//locate the hide button and click on it
		driver.findElement(By.id("hide-textbox")).click();
		Thread.sleep(2000);
		if(!driver.findElement(By.id("displayed-text")).isDisplayed()) {
			System.out.println("hide button working...");
		}
		//locate show button and click on it
		driver.findElement(By.id("show-textbox")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.id("displayed-text")).isDisplayed()) {
			System.out.println("show button working...");
		}
		
		driver.close();
	}

}
