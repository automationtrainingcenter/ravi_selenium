package autosuggesions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;

public class AutoSuggestionDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("selenium");
		WebElement suggestionBox = driver.findElement(By.cssSelector(".erkvQe"));
		List<WebElement> suggestions = suggestionBox.findElements(By.tagName("li"));
		for(WebElement suggestion : suggestions) {
			if(suggestion.getText().equalsIgnoreCase("selenium webdriver")) {
				suggestion.click();
				break;
			}
		}
		sleep(2000);
		closeBrowser();
	}

}
