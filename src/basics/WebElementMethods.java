package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		
		//locate an element using findElement() of WebDriver interface 
		WebElement firstNameEle = driver.findElement(By.name("firstname"));
//		driver.findElement(By.name("firstname")).sendKeys("sunshine");
		// sendKeys(String arg): is used to send some data into a text field or text area
		firstNameEle.sendKeys("sunshine");
		Thread.sleep(3000);
		
		
		// clear(): is used to clear the contents of text field or text area if they have any
		firstNameEle.clear();
		Thread.sleep(3000);
		
		
		// click(): is used to click on any element
		WebElement signUpButton = driver.findElement(By.name("websubmit"));
		signUpButton.click();
		Thread.sleep(2000);
		
		// getText(): is used to retrieve inner text of the given element as a String value
		String innerTextSignUpBtn = signUpButton.getText();
		System.out.println("inner text of the signup button is "+innerTextSignUpBtn);
			
		// getTagName(): is used to retrieve the tag name of the given element as a string value
		String firstNameTagName = firstNameEle.getTagName();
		System.out.println("first name element tag name is "+firstNameTagName);

		// getAttribute(String attibute_name): is used to retrieve the value of the given attribute
		String firstNameClassAttValue = firstNameEle.getAttribute("class");
		System.out.println("first name class attribute value is "+firstNameClassAttValue);
		
		// getCssValue(String css_property_name): is used to retrieve the value of given CSS property name
		String singUpBtnfontSize = signUpButton.getCssValue("font-size");
		System.out.println("font size property value of signup button is "+singUpBtnfontSize);
		
		
		/* getLocation(): returns a Point class object i.e. x and y coordinate values of
		 * the given element from the top left corner of the web page 
		 */
		Point location = signUpButton.getLocation();
		System.out.println("singup button is at x = "+location.getX()+" and y = "+location.getY());
		
		/*
		 * getSize(): returns Dimension class object i.e. width and height of the given element
		 */
		Dimension size = signUpButton.getSize();
		System.out.println("signup button width is "+size.width+" and height is "+size.height);
		
		//isDisplayed(): returns true if an element is displayed on the page
		boolean signUpDisplayed = signUpButton.isDisplayed();
		System.out.println("signup button is displayed on the page "+signUpDisplayed);
		
		//isEnabled(): return true if an element is in enabled mode
		boolean firstNameEnabled = firstNameEle.isEnabled();
		System.out.println("first name element is enabled on the page "+firstNameEnabled);
		
		//isSelected(): returns true if an option dropdown list, list box, radio button or check box is selected
		WebElement femaleRadioBtn = driver.findElement(By.cssSelector("input[value='1']"));
		femaleRadioBtn.click();
		boolean femaleOptionSelected = femaleRadioBtn.isSelected();
		System.out.println("female radio button selected "+femaleOptionSelected);
		
		// submit(): is used to submit a form to the server from any element in the form
		driver.findElement(By.id("email")).submit();
		Thread.sleep(3000);
		
		driver.close();
 	}

}
