package Week4.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement SRC = driver.findElementByXPath("//ul[@class='ui-sortable']/li[2]");
		WebElement DST = driver.findElementByXPath("//ul[@class='ui-sortable']/li[4]");
		Point location = DST.getLocation();
		int x = location.getX();
		int y = location.getY();
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(SRC, x, y).perform();

	}

}
