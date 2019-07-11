package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowsHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// launch framesDemo.hmtl in frames folder
		driver.get("file:///D:/SSTS/7AMMay/selenium_concepts/frames/framesDemo.html");
		driver.manage().window().maximize();

		// in main window locate open windows and click on it
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(5000);

		// get all window handles opened driver instance
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowIDs = new ArrayList<>(windowHandles);
		
		//Automate youtube
		driver.switchTo().window(windowIDs.get(2));
		driver.findElement(By.id("search")).sendKeys("selenium"+Keys.ENTER);
		Thread.sleep(3000);
		
		
		//Automate Facebook
		driver.switchTo().window(windowIDs.get(1));
		driver.findElement(By.id("email")).sendKeys("sunshine");
		Thread.sleep(3000);
		
		
		//Automate Google
		driver.switchTo().window(windowIDs.get(3));
		driver.findElement(By.name("q")).sendKeys("selenium webdriver"+Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[text()='Selenium WebDriver']")).click();
		Thread.sleep(3000);
		
		
		//automate main window
		driver.switchTo().window(windowIDs.get(0));
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(5000);

		driver.quit();
	}

}
