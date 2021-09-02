package Week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NykkA {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement brand = driver.findElementByXPath("//a[text()='brands']");
		Actions builder = new Actions(driver);
		builder.moveToElement(brand).perform();
		driver.findElementByXPath("//ul[@class='l-vertical-list']/li[5]").click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		String title = driver.getTitle();
		System.out.println("TITLE OF THE PAGE IS:" + title);
		JavascriptExecutor kse = (JavascriptExecutor) driver;
		kse.executeScript("window.scrollBy(0,400)");
		driver.findElementByXPath("//span[@class='pull-right']").click();
		kse.executeScript("window.scrollBy(0,200)");
		driver.findElementByXPath("(//span[text()='customer top rated'])").click();
		// Thread.sleep(10000);
		kse.executeScript("window.scrollBy(0,400)");
		driver.findElementByXPath("//div[text()='Category']").click();
		driver.findElementByXPath("//span[text()='Hair']").click();
		driver.findElementByXPath("//span[text()='Hair Care']").click();
		driver.findElementByXPath("//span[text()='Shampoo']").click();
		Thread.sleep(1000);
		String text4 = driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']/li").getText();
		System.out.println("FILTER IS APPILED WITH:" + text4);
		kse.executeScript("window.scrollBy(0,400)");
		driver.findElementByXPath("(//div[@class='clearfix'])[8]").click();
		driver.findElementByXPath("(//span[text()='Color Protection'])").click();
		driver.findElementByXPath("(//div[@class='m-content__product-list__title'])[1]/h2").click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandlesList1.get(2));
		Thread.sleep(1000);
		driver.findElementByXPath("(//span[@class='size-pallets'])[1]").click();
		Thread.sleep(1000);
		String text = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
		System.out.println("THE MRP RATE OF SHAMPOO IS:" + text);
		driver.findElementByXPath(
				"(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]")
				.click();
		Thread.sleep(1000);
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		Thread.sleep(1000);
		String text2 = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		String REPITEM1 = text2.replaceAll("[^0-9]", "");
		int COUNT1 = Integer.parseInt(REPITEM1);
		System.out.println("GRAND TOTAL IS:" + COUNT1);
		Thread.sleep(1000);
		kse.executeScript("window.scrollBy(0,200)");
		driver.findElementByXPath("//div[@class='second-col']").click();
		Thread.sleep(1000);
		kse.executeScript("window.scrollBy(0,200)");
		driver.findElementByXPath("(//button[@type='button'])[2]").click();
		Thread.sleep(1000);
		String text3 = driver.findElementByXPath("//div[@class='payment-details-tbl grand-total-cell prl20']/div[2]")
				.getText();
		String REPITEM2 = text3.replaceAll("[^0-9]", "");
		int COUNT2 = Integer.parseInt(REPITEM2);
		System.out.println("GRAND 2 TOTAL IS:" + COUNT2);
		if (COUNT1 == COUNT2) {
			System.out.println("THEY ARE SAME");
		}
		driver.close();
		driver.switchTo().window(windowHandlesList.get(1));
		driver.close();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.close();
	}

}
