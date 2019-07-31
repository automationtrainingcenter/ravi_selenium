package sikuli;

import org.openqa.selenium.support.ui.Sleeper;
import org.sikuli.hotkey.Keys;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utitlities.GenericHelper;

public class SikuliDemo2 {
	
	public static void main(String[] args) throws Exception {
		//create Pattern class objects
		Pattern chrome = new Pattern(GenericHelper.getFilePath("images", "chrome.PNG"));
		Pattern addresbar = new Pattern(GenericHelper.getFilePath("images", "addressbar.PNG"));
		Pattern search = new Pattern(GenericHelper.getFilePath("images", "search.PNG"));
		Pattern close = new Pattern(GenericHelper.getFilePath("images", "close.PNG"));
		
		
		Screen screen = new Screen();
		screen.find(chrome);
		screen.click(chrome);
		Thread.sleep(3000);
		screen.find(addresbar);
		screen.type(addresbar, "http://www.google.com"+Keys.ENTER);
		Thread.sleep(2000);
		screen.find(search);
		screen.type(search, "selenium"+Keys.ENTER);
		Thread.sleep(4000);
		screen.find(close);
		screen.click(close);
	}

}
