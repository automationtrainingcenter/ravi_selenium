package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Navigation is an inner interface in WebDriver interface and this interface 
 * contains several methods to work with browse navigations like back, forward and refresh
 * 
 * WebDriver interface provides navigate() which returns Navigation interface reference
 * using that reference we can call methods of Navigation interface
 */

public class NavigationCommands {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//navigate to a url using get()
		driver.get("http://www.google.com");
		Thread.sleep(3000);
		
		//create Navigation interface reference using navigate() of WebDriver interface
		Navigation nav = driver.navigate();
		
		// navigate to url using to() of Navigation interface
//		nav.to(new URL("http://www.google.com"));
		
		nav.to("http://www.gmail.com");
		Thread.sleep(3000);
		
		//to automate the back button of browser we can use back() of Navigation interface
		nav.back();
		Thread.sleep(3000);
		
		//to automate the forward button of browser we can use forward() of Navigation interface
		nav.forward();
		Thread.sleep(3000);
		
		// to refresh the current web page we can use refresh() of  Navigation interface
		nav.refresh();
		Thread.sleep(3000);
		
		
		
		driver.close();
		
		
	}

}
