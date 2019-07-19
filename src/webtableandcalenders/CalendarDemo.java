package webtableandcalenders;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;

public class CalendarDemo extends BrowserHelper {
	public static void selectDate(WebElement tbody, String date) {
		boolean status = false;
		// locate all the rows in the table
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			// locate all the cells which contains dates
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				if (cell.getText().endsWith(date)) {
					cell.findElement(By.tagName("button")).click();
					status = true;
					sleep(3000);
					break; // cells loop
				}
			}
			if (status) {
				break;// rows loop
			}

		}
	}

	public static void main(String[] args) {
		openBrowser("chrome", "https://www.expedia.com/");
		// locate departing date and click on it
		driver.findElement(By.id("package-departing-hp-package")).click();
		String month = "Jul 2019";
		sleep(2000);
		// locate calendar table body
		WebElement tbody = driver
				.findElement(By.xpath("//caption[text()='" + month + "']/parent::table/tbody"));
		
		selectDate(tbody, "21");
		sleep(3000);
		//locate return date and click on it
		driver.findElement(By.id("package-returning-hp-package")).click();
		//locate calendar table body
		month = "Aug 2019";
		tbody = driver
		.findElement(By.xpath("//caption[text()='" + month + "']/parent::table/tbody"));
		sleep(2000);
		selectDate(tbody, "2");
		sleep(3000);
		closeBrowser();
	}
}
