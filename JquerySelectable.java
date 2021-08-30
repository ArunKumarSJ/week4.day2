package Week4.Day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySelectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElementByXPath("//div[@id='content']/iframe");
		driver.switchTo().frame(frame1);
		WebElement ele1 = driver.findElementByXPath("(//li[@class='ui-widget-content ui-selectee'])[2]");
		WebElement ele2 = driver.findElementByXPath("(//li[@class='ui-widget-content ui-selectee'])[4]");
		Actions builder = new Actions(driver);
		builder.clickAndHold(ele1).moveToElement(ele2).release().perform();
		driver.switchTo().defaultContent();

	}

}
