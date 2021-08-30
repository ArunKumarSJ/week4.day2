package Week4.Day2;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElementByXPath("//div[@id='content']/iframe");
		driver.switchTo().frame(frame1);
		WebElement SRC1= driver.findElementByXPath("//li[text()='Item 1']");
		WebElement DST1= driver.findElementByXPath("//li[text()='Item 5']");
		Point location=DST1.getLocation();
		int x = location.getX();
		int y = location.getY();
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(SRC1,x, y).perform();

	}

}
