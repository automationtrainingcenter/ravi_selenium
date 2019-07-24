package screenshots;

import org.openqa.selenium.By;

import utitlities.BrowserHelper;
import utitlities.ScreenshotHelper;

public class TestScreenshotHelper extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		sleep(2000);
		ScreenshotHelper.takeScreenShot(driver, "screenshots", "practice");
		sleep(2000);
		// locate the element which will open an alert and click on it
		driver.findElement(By.id("alertbtn")).click();
		sleep(2000);
		ScreenshotHelper.takeAlertScreenshot("screenshots", "practice_alert");
		driver.switchTo().alert().accept();
		closeBrowser();
	}

}
