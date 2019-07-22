package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utitlities.BrowserHelper;

public class SliderDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.axisbank.com/retail/calculators/personal-loan-emi-calculator");
		//locate slider head and slider
		WebElement sliderHead = driver.findElement(By.xpath("//input[@id='loanAmtSlider']/preceding-sibling::span//span[@class='irs-single']"));
		//create Actions class object
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(sliderHead, 150, 0).build().perform();
		sleep(3000);
		closeBrowser();

	}

}
