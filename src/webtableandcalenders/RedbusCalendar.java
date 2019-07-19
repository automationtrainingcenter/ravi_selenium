package webtableandcalenders;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utitlities.BrowserHelper;

public class RedbusCalendar extends BrowserHelper {

	public static void selectDate(WebElement table, String date) {
		boolean flag = false;
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int i = 2; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			for(WebElement cell : cells) {
				if(cell.getText().equals(date)) {
					cell.click();
					flag = true;
					break; //cells loop
				}
			}
			if(flag) {
				break; //rows loop
			}
		}
	}

	public static void main(String[] args) {
		openBrowser("chrome", "http://www.redbus.in");
		sleep(4000);
		//code if the page contains add
		//switch to frame which contains add
		try {
			WebElement frame = driver.findElement(By.cssSelector("iframe[id*='__ta_notif_frame_']"));
			driver.switchTo().frame(frame);
			driver.findElement(By.cssSelector(".close")).click();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		// locate the element which will open calendar and click on it
		driver.findElement(By.xpath("//label[@for='onward_cal']")).click();
		// locate onward journey calendar table body
		WebElement onwardTable = driver.findElement(By.cssSelector("#rb-calendar_onward_cal>table>tbody"));
		selectDate(onwardTable, "29");
		sleep(3000);
		
		//locate the return journey element which will open calendar and click on it
		driver.findElement(By.xpath("//label[@for='return_cal']")).click();
		//locate calendar table body 
		WebElement returnTable = driver.findElement(By.cssSelector("#rb-calendar_return_cal tbody"));
		selectDate(returnTable, "31");
		sleep(3000);
		closeBrowser();
	}

}
