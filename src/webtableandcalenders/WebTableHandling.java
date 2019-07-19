package webtableandcalenders;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;

public class WebTableHandling extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		//locate table body
		WebElement tableBody = driver.findElement(By.cssSelector("#product>tbody"));
		//locate all the rows inside the table body using tr tag
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		//iterate over rows 
		for(WebElement row : rows) {
			//locate all the columns inside every row
			List<WebElement> columns = row.findElements(By.tagName("td"));
			// iterate over the columns and automate the content
			for(WebElement column : columns) {
				//now we are inside the cell
				System.out.print(column.getText()+"\t");
			}
			System.out.println();
		}
		//close the browser
		closeBrowser();
	}

}
