package screenshots;

import org.openqa.selenium.JavascriptExecutor;

import utitlities.BrowserHelper;
import utitlities.JavaScripHelper;
import utitlities.ScreenshotHelper;

public class MultipleScreenshots extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.amazon.in");
		sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		long viewHeight = (long)js.executeScript("return document.documentElement.clientHeight");
		long scrollHeight = (long) js.executeScript("return document.documentElement.scrollHeight");
//		System.out.println("view height = "+viewHeight);
//		System.out.println("scroll height = "+scrollHeight);
		while(scrollHeight > 0) {
			ScreenshotHelper.takeScreenShot(driver, "screenshots", "amazon");
			JavaScripHelper.scrollPageBy(driver, 0, (int)viewHeight);
			scrollHeight -= viewHeight;
			sleep(1000);
		}
		closeBrowser();
	}
 
}
