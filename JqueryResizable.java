package Week4.Day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryResizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElementByXPath("//div[@id='content']/iframe");
		driver.switchTo().frame(frame1);
		WebElement Resize =driver.findElementByXPath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']");
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(Resize, 100, 50).perform();
		driver.switchTo().defaultContent();
	}

}
