package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiFramesDemo {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//launch framesDemo.hmtl in frames folder
		driver.get("file:///D:/SSTS/7AMMay/selenium_concepts/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		//first driver focus is in main page
		//Automate Frame 4
		/*frame 4 is an inner frame of frame 3, so to automate frame 4 first we have
		 * switch the driver focus to frame 3 then switch the focus to frame 4
		 */
		driver.switchTo().frame("fthree");
		//now the focus is in frame3
		//switch the focus to frame4
		driver.switchTo().frame(0);
		//now the focus is in frame4
		//locate search favorite course text field and enter some data
		driver.findElement(By.xpath("//input[@placeholder='Search your Favorite Course...']")).sendKeys("Python");
		Thread.sleep(3000);
		
		//Automate Frame3
		//now focus is in frame4
		//frame 4 is an inner frame of frame3 so we can switch the focus from frame 4 to frame 3 using parentFrame()
		driver.switchTo().parentFrame();
		//now focus is in frame 3
		driver.findElement(By.id("click")).click();
		Thread.sleep(3000);
		
		//Automate Frame2
		//now the focus is in frame3
		//switch focus to main page using defaultContent()
		driver.switchTo().defaultContent();
		//now focus is in main page
		//switch the focus to frame 2 using frame()
		driver.switchTo().frame("ftwo");
		//focus is in frame 2
		driver.findElement(By.linkText("selenium official site")).click();
		Thread.sleep(3000);
		
		
		//Automate Freme1
		//now focus is in frame 2
		//switch the focus to main page
		driver.switchTo().defaultContent();
		//switch the focus to frame 1
		//locate frame 1 using xpath
		WebElement frameOne = driver.findElement(By.xpath("//iframe[@src='frameOne.html']"));
		driver.switchTo().frame(frameOne);
		//focus is in frame1
		driver.findElement(By.cssSelector("input[placeholder='Enter name']")).sendKeys("susshine");
		Thread.sleep(2000);
		
		//Automate main page
		//now focus is in frame1
		//switch the focus to main page
		driver.switchTo().defaultContent();
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(4000);
		driver.quit();
	}

}
