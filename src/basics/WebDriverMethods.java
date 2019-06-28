package basics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// get(String url) it accepts a string argument which is url of the application
		// we want to navigate
		driver.get("http://www.facebook.com");

		/*
		 * getTitle() returns String value which is title of the current web page title
		 * of the web page is inner text of the title tag in head tag inner text is the
		 * text in between opening and closing tag
		 */
		String title = driver.getTitle();
		System.out.println("title is " + title);

		/*
		 * getCurrentUrl() return string value which is url of the current web page
		 */
		String currentUrl = driver.getCurrentUrl();
		System.out.println("current url of the page is " + currentUrl);

		/*
		 * getPageSource() returns string value which is complete source code of the
		 * current web page
		 */
		String pageSource = driver.getPageSource();
		System.out.println(pageSource.substring(0, 200));

		/*
		 * getWindowHandle() returns string value which is unique id of the browser
		 * window/ tab opened by the driver instance
		 */
		String windowID = driver.getWindowHandle();
		System.out.println(windowID);

		/*
		 * getWindowHandles() returns a java.util.Set of String values which are unique
		 * ids of each and every window opened by the driver instance This method is
		 * used to switch the driver focus from one window to another window opened by
		 * driver instance
		 */
		Set<String> windowIDs = driver.getWindowHandles();
		System.out.println(windowIDs);

		/*
		 * findElement(By arg) returns a WebElement interface reference this method will
		 * locate an element in the current web page based on the locating technique we
		 * specified using 'By' class and stores in a WebElement reference. If no
		 * element is present in the page with locating technique then this method will
		 * throw NoSuchElement exception
		 */
		By emailLoc = By.id("email");
		WebElement emailEle = driver.findElement(emailLoc);

		/*
		 * findElements(By arg) returns a java.util.List of WebElement type this method
		 * will locate either zero or more elements in the current web page based on the
		 * locating technique we specified using 'By' class and store in
		 * List<WebElement>. if no element is present in the page with locating
		 * technique then this method will return a List of size 0.
		 */
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("number of links in page are " + links.size());

		/*
		 * close() which will close the current browser window
		 */
		driver.close();

		/*
		 * quit() which will close all the browser windows opened by the driver instance
		 */
		driver.quit();

	}

}
