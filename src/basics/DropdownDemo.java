package basics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * automate the form except choose file in following url
 * https://online.tsrtcpass.in/generalbuspass.do?category=Fresh
 */
public class DropdownDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();

		/*
		 * To automate dropdown list or list box selenium provides Select class 1.
		 * Create an Object of Select class by passing WebElement as argument to
		 * constructor
		 */
		// locate date element
		WebElement dateEle = driver.findElement(By.id("day"));
		Select dateSelect = new Select(dateEle);
		/*
		 * to retrieve default selected option use getFirstSelectedOption
		 */
		String defaultDate = dateSelect.getFirstSelectedOption().getText();
		System.out.println("default date is " + defaultDate);
		/*
		 * select an option based on the index number of option tag and index number
		 * starts from 0 -- selectByIndex(int arg)
		 */
		dateSelect.selectByIndex(18);
		Thread.sleep(2000);

		// locate month element
//		WebElement monthEle = driver.findElement(By.id("month"));
//		Select monthSelect = new Select(monthEle);
		Select monthSel = new Select(driver.findElement(By.id("month")));
		
		// retrieve default month
		String defaultMonth = monthSel.getFirstSelectedOption().getText();
		System.out.println("default month is " + defaultMonth);
		
		/*to retrieve all the options of a dropdown list or list box 
		 * use getOptions() which will return a List of WebElements
		 */
		List<WebElement> options = monthSel.getOptions();
		List<String> optionsText = new ArrayList<>();
		for(WebElement option : options) {
			optionsText.add(option.getText());
		}
		System.out.println(optionsText.contains("Apr"));
		
		/*
		 * select an option based on value of the value attribute of option tag --
		 * selectByValue(String arg)
		 */
		monthSel.selectByValue("11");
		Thread.sleep(2000);

		// locate year element
		Select yearSelect = new Select(driver.findElement(By.id("year")));
		// retrieve default year
		String defaultYear = yearSelect.getFirstSelectedOption().getText();
		System.out.println("default year is " + defaultYear);
		/*
		 * Select an option based on the inner text i.e. text in between opening
		 * <option> and closing </option> tags -- selectByVistibleText(String arg)
		 */
		yearSelect.selectByVisibleText("1998");
		Thread.sleep(2000);

		driver.close();
	}

}
