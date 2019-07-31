package sikuli;

import org.openqa.selenium.By;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utitlities.BrowserHelper;
import utitlities.GenericHelper;

public class SikuliDemo extends BrowserHelper{
	
	public static void main(String[] args) throws Exception{
		openBrowser("chrome", "https://smallpdf.com/word-to-pdf");
		/*
		 * sikuli mainly contains two classes
		 * 1. Screen class : it contains all the methods to automate any application
		 * 2. Pattern class: is used to store image details of the elements we want to automate
		 */
		driver.findElement(By.xpath("//div[text()='Choose file']")).click();
		sleep(2000);
		
		// create Patter class objects by stoting all the elements we want to automate
		Pattern fileName = new Pattern(GenericHelper.getFilePath("images", "filename.PNG"));
		Pattern open = new Pattern(GenericHelper.getFilePath("images", "open.PNG"));
		
		Screen screen = new Screen();
		screen.find(fileName);
		screen.type(fileName, "D:\\selenium\\Notes\\sikuli.doc");
		sleep(2000);
		screen.find(open);
		screen.click(open);
		sleep(2000);
		closeBrowser();
		
	}

}
