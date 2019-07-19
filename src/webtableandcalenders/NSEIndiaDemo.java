package webtableandcalenders;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;

/*
 * Handling web table in NSE India website
 */

public class NSEIndiaDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		String companyCode = "DRREDDY";
		//locate web table body
		WebElement tableBody = driver.findElement(By.cssSelector("#preOpenNiftyTab>tbody"));
		//locate all the rows inside the table
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		//iterate over rows
		for(int i = 2; i < rows.size(); i++) {
			// locate all the cells inside every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			//get the company code which is first cell of every and compare it will companyCode string variable
			if(cells.get(0).getText().equals(companyCode)) {
				//locate link which is in first cell and click on it
				cells.get(0).findElement(By.tagName("a")).click();
				// if the match found then get the fourth cell text and print on the console
				System.out.println(cells.get(3).getText());
				break;
			}
		}
		closeBrowser();
	}
}
