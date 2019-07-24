package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utitlities.BrowserHelper;
import utitlities.GenericHelper;

public class ScreenshotsDemo extends BrowserHelper{
	public static void main(String[] args) throws IOException {
		openBrowser("chrome", "http://www.facebook.com");
		sleep(2000);
		/*
		 * To capture the screenshot of a web page selenium provides getScreenshotAs()
		 * of TakeScreenshot interface
		 */
		//create a TakeScreenshot interface object reference by converting WebDriver object
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(GenericHelper.getFilePath("screenshots", "image2.png"));
		
		//apache commons.io
		FileUtils.copyFile(srcImg, destImg);
		//inbuilt approach in Java
//		BufferedImage bi = ImageIO.read(srcImg);
//		ImageIO.write(bi, "png", destImg);
		
		sleep(2000);
		closeBrowser();
		
		
	}

}
