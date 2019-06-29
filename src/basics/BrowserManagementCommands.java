package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManagementCommands {

	/*
	 * In WebDriver interface we have manage() which return Options interface
	 * reference In Options interface we have window() which returns Window
	 * interface reference
	 * 
	 * Window interface contains several methods to manage browser
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");

		// create an object of Window interface
		Options manage = driver.manage();
		Window window = manage.window();

		/*
		 * to get the position of browser window in terms of x and y coordinates use
		 * getPostion() of Window interface and this method returns a Point class object
		 */
		Point position = window.getPosition();
		System.out.println("browser is at  x = " + position.getX() + " and y = " + position.getY());

		/*
		 * to get the size of the browser window in terms of height and width we can use
		 * getSize() of Window interface and this method returns a Dimension class
		 * object
		 */
		Dimension size = window.getSize();
		System.out.println("browser width = " + size.getWidth() + " and height = " + size.getHeight());

		// to maximize the browser window use maximize() of Window interface
//		driver.manage().window().maximize();
		window.maximize();
		Thread.sleep(3000);

		// to fullscreen the browser window (F11 mode) use fullscreen() of Window
		// interface
		window.fullscreen();
		Thread.sleep(3000);

		/*
		 * to set the size of the browser window to specific height and width we can use
		 * setSize(Dimension size) of Window interface
		 */
		window.setSize(new Dimension(700, 400));
		Thread.sleep(3000);

		/*
		 * to set the position of browser window to specific location we can use
		 * setPosition(Point point) of Window interface
		 */
		window.setPosition(new Point(500, 300));
		Thread.sleep(3000);
		
		driver.close();
		

	}
}
