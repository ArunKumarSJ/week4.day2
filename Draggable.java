package Week4.Day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		
		WebElement ITM1 = driver.findElementById("draggable");
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(ITM1, 100, 100).perform();

	}

}
