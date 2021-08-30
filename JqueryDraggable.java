package Week4.Day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDraggable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElementByXPath("//div[@id='content']/iframe");
		driver.switchTo().frame(frame1);
		WebElement ITEM1 = driver.findElementById("draggable");
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(ITEM1, 100, 100).perform();
		driver.switchTo().defaultContent();
	}

}
