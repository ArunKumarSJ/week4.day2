package Week4.Day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		WebElement IT1 = driver.findElementById("draggable");
		WebElement IT2 = driver.findElementById("droppable");
		Actions builder=new Actions(driver);
		builder.dragAndDrop(IT1, IT2).perform();
	}

}
