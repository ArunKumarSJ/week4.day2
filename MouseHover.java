package Week4.Day2;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		WebElement MOS = driver.findElementByLinkText("TestLeaf Courses");
		Actions builder = new Actions(driver);
		builder.moveToElement(MOS).perform();
		String text1 = driver.findElementByLinkText("Selenium").getText();
		String text2 = driver.findElementByLinkText("RPA").getText();
		String text3 = driver.findElementByLinkText("WebServices").getText();
		System.out.println("THE TEST LEAF COUSRES ARE");
		System.out.println(text1+ " "+text2+" "+text3);
		driver.findElementByLinkText("Selenium").click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
	}

}
