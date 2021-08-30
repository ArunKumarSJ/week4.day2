package Week4.Day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();	
		
		WebElement ITEM1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement ITEM2 = driver.findElementByXPath("//li[text()='Item 5']");
		Actions builder=new Actions(driver);
		builder.clickAndHold(ITEM1).moveToElement(ITEM2).release().perform();
	}

}
