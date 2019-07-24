package screenshots;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import utitlities.BrowserHelper;
import utitlities.GenericHelper;

public class AlertScreenshot extends BrowserHelper {
	public static void main(String[] args) throws IOException, AWTException {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		// locate the element which will open an alert and click on it
		driver.findElement(By.id("alertbtn")).click();
		sleep(2000);
		/*
		 * To capture screenshots of alerts we have use Robot class of Java
		 * Robot class contains createScreenCapture()
		 */
		//create a rectangle class object
		Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		//create an object of Robot class
		Robot r = new Robot();
		BufferedImage bi = r.createScreenCapture(rect);
		File destImg = new File(GenericHelper.getFilePath("screenshots", "alert_image1.png"));
		ImageIO.write(bi, "png", destImg);

		sleep(1000);
		driver.switchTo().alert().accept();
		closeBrowser();
	}

}
