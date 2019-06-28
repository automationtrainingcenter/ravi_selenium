package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * To launch any browser using selenium we have to create an object of browser
		 * driver class like FirefoxDriver, ChromeDriver, EdgeDriver, OperaDriver,
		 * SafariDriver
		 */
		// set the geckodriver.exe file path using System property
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		// launch firefox browser
		WebDriver driver = new FirefoxDriver();
		// open an url
		driver.get("http://www.google.com");
		Thread.sleep(4000);
		driver.close();

		// set the chromedriver.exe file path using System property
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// launch chrome browser
		driver = new ChromeDriver();
		// open an url
		driver.get("http://www.facebook.com");
		Thread.sleep(4000);
		driver.close();

	}

}
