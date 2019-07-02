package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingTechniques {
	/*
	 * findElement() -> is used to locate an element in the web page using locator
	 * information. If the element is not located using the given locator info this
	 * method throws NoSuchElementException.
	 */

	/*
	 * findElements() -> is used to locate multiple elements in the web page using
	 * locator information. This method returns a list of elements. if no element is
	 * not located then this method returns an empty list.
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		/*
		 * Selenium provides 8 ways to locate an element in the current web page
		 * These ways are available as static method in By class.
		 * all these 8 methods in By class accepts a string arguments and returns 
		 * a By class reference
		 */
		
		
		/*
		 * using id attribute value of an element
		 * By eleId = By.id("id attribute value")
		 */
//		By emailEleId = By.id("email");
//		WebElement emailEle = driver.findElement(emailEleId);
		WebElement emailEle = driver.findElement(By.id("email"));
		
		
		/*
		 * using name attribute value of an element
		 * By eleName = By.name("name attribute value")
		 */
		WebElement firstNameEle = driver.findElement(By.name("firstname"));
		
		
		/*
		 * using linkText of a link
		 * linkeText in an inner text in between opening <a> and closing</a> anchor tags
		 * eg: <a>link text</a>
		 * By eleLinkText = By.linkText("link text of element")
		 */
		WebElement forgotAccountLink = driver.findElement(By.linkText("Forgotten account?"));
		
		
		/*
		 * using part of the link text instead of complete link text
		 * By elePartialLinkText = By.partialLinkText("part of the link text")
		 */
		WebElement createAPageLink = driver.findElement(By.partialLinkText("a Page"));
		
		
		/*
		 * using css selector of a element
		 * Xpath and cssSelectors are used to locate an element using any attribute value
		 * basic syntax to write css is
		 * syntax: tagname[attribute_name = 'attribute_value']
		 */
		WebElement femaleRadio = driver.findElement(By.cssSelector("input[value='1']"));
		
		/*
		 * using xpath of an element
		 * basic syntax to write xpath is
		 * syntax: //tag_name[@attribute_name = 'attribute_value']
		 */
		WebElement lastNameEle = driver.findElement(By.xpath("//input[@aria-label='Surname']"));
		
		/*
		 * if we locating element using className or tagName then, there might high
		 * probability to locate multiple elements instead of single element
		 */
		
		/*
		 * using class name of a element
		 * in general class attribute contains several class names, so to locate element
		 * using class name we have to use one these class names instead of complete class
		 * attribute value
		 * eg: class = 'class1 class2 class3'
		 * above class attribute contains 3 classes separated by space 
		 * syntax: By.className('class1')
		 */
		List<WebElement> textfileds = driver.findElements(By.className("inputtext"));
		System.out.println("number of text fields = "+textfileds.size());
		
		
		/*
		 * using tag name of the element
		 */
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("number of links = "+links.size());
		
		
		driver.close();
		
	}

}
