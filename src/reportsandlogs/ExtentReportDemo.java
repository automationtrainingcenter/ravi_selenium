package reportsandlogs;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utitlities.GenericHelper;
import utitlities.ScreenshotHelper;

public class ExtentReportDemo{
	ExtentReports report;
	ExtentTest test;
	static WebDriver driver;
	
	//launch browser
	public void testLaunchBrowser() {
		test = report.startTest("test launch browser");
		System.setProperty("webdriver.chrome.driver", GenericHelper.getFilePath("drivers", "chromedriver.exe"));
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "chrome browser launched");
		driver.get("https://learn.letskodeit.com/p/practice");
		test.log(LogStatus.INFO, "browser navigated to "+driver.getCurrentUrl());
		driver.manage().window().maximize();
		test.log(LogStatus.PASS, "test launch browser passed");
		report.endTest(test);
	}
	
	// verify alerts
	public void testAlerts() throws InterruptedException {
		test = report.startTest("test alerts");
		driver.findElement(By.id("name")).sendKeys("surya");
		test.log(LogStatus.INFO, "enter your name filed located and entered name as surya");
		driver.findElement(By.id("alertbtn")).click();
		test.log(LogStatus.INFO, "located alert button and clicked on alert");
		Thread.sleep(2000);
		String text = driver.switchTo().alert().getText();
		test.log(LogStatus.INFO, "alert came with text as: "+text);
		driver.switchTo().alert().accept();
		test.log(LogStatus.INFO, "alert accepted");
		test.log(LogStatus.PASS, "test alerts passed");
		report.endTest(test);
	}
	
	//course search in a frame
	public void testCourseSearch() throws InterruptedException {
		test = report.startTest("test course search");
		//switch to frame which contains course search field
		driver.switchTo().frame("courses-iframe");
		test.log(LogStatus.INFO, "switched to frame");
		driver.findElement(By.id("search-courses")).sendKeys("Ruby"+Keys.ENTER);
		test.log(LogStatus.INFO, "located search course text field and entered course as Ruby");
		Thread.sleep(2000);
		String imgPath = ScreenshotHelper.takeScreenShot(driver, "images", "report1");
		test.log(LogStatus.INFO, "captured the screenshot of result window");
		driver.switchTo().defaultContent();
		test.log(LogStatus.INFO, "switched to default content");
		test.log(LogStatus.INFO, test.addScreenCapture(imgPath));
		test.log(LogStatus.FAIL, "test course search is passed");
		report.endTest(test);
	}
	
	//login with invalid credentials
	public void testLoginWithInvlaidCred() throws InterruptedException {
		test = report.startTest("test login with invalid credentials");
		driver.findElement(By.partialLinkText("Login")).click();
		test.log(LogStatus.INFO, "login link located and clicked");
		Thread.sleep(5000);
		driver.findElement(By.id("user_email")).sendKeys("test@test.com");
		test.log(LogStatus.INFO, "user name locate and entered as test@test.com");
		driver.findElement(By.id("user_password")).sendKeys("test123");
		test.log(LogStatus.INFO, "password located and entered as test123");
		driver.findElement(By.name("commit")).click();
		test.log(LogStatus.INFO, "login button located and clicked");
		try {
			if(driver.findElement(By.xpath("//form[@id='new_user']/preceding-sibling::div")).isDisplayed()) {
				test.log(LogStatus.PASS, "test login with invalid credential passed");
			}
		}catch(NoSuchElementException e) {
			test.log(LogStatus.FAIL, "test login with invalid credentials failed");
		}
		report.endTest(test);
	}
	
	public static void main(String[] args) throws Exception {
		ExtentReportDemo obj = new ExtentReportDemo();
		obj.report = new ExtentReports(GenericHelper.getFilePath("reports", "report.html"));
		obj.testLaunchBrowser();
		obj.testAlerts();
		obj.testCourseSearch();
		obj.testLoginWithInvlaidCred();
		obj.report.flush();
		obj.report.close();
		driver.close();
	}

}
