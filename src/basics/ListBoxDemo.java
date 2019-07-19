package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utitlities.BrowserHelper;

public class ListBoxDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate list box
		WebElement fruitsList = driver.findElement(By.id("multiple-select-example"));
		// Create Select class object
		Select fruitSelect = new Select(fruitsList);
		// select an option based on index
		fruitSelect.selectByIndex(2); // Peach
		Thread.sleep(2000);
		// slect an option based on value
		fruitSelect.selectByValue("apple");
		Thread.sleep(2000);

		// retrieve all selectd options
		List<WebElement> selectedOptions = fruitSelect.getAllSelectedOptions();
		for (WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}

		// select an option based on visible text
		fruitSelect.selectByVisibleText("Orange");
		Thread.sleep(2000);
		// deselect all selected options
//		fruitSelect.deselectAll();
//		Thread.sleep(2000);

		// deselect an option based on index
		fruitSelect.deselectByIndex(1); // Orange
		Thread.sleep(2000);
		// deselect an option based on value of the value attribute
		fruitSelect.deselectByValue("peach");
		Thread.sleep(2000);
		// deselect an option based on visible text
		fruitSelect.deselectByVisibleText("Apple");
		Thread.sleep(2000);
		
		BrowserHelper.selectOption(fruitsList, "mango");
		Thread.sleep(3000);

		driver.close();
	}

}
