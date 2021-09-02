package Week4.Day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement men = driver.findElementByXPath("(//a[@class='menuLinks leftCategoriesProduct '])[6]/span");
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform();
		driver.findElementByXPath("(//span[text()='Sports Shoes'])[1]").click();
		// Thread.sleep(20000);
		String SHOESCOUNT = driver.findElementByXPath("(//span[@class='category-count'])[1]").getText();
		System.out.println("COUNT OF SPORTS SHOES:" + SHOESCOUNT);
		driver.findElementByXPath("//div[text()='Training Shoes']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//span[text()='Sort by:']").click();
		Thread.sleep(20000);
		driver.findElementByXPath("//ul[@class='sort-value']//li[2]").click();
		// String LTOH =
		// driver.findElementByXPath("//div[@class='sort-selected']").getText();
		// System.out.println("THE SORTED LIST IS:" + LTOH);
		Thread.sleep(20000);
		List<WebElement> PR = driver.findElementsByXPath("//span[@class='lfloat product-price']");
		List<String> PRL = new ArrayList<String>();
		for (int i = 0; i < PR.size(); i++) {
			PRL.add(PR.get(i).getText());

		}
		System.out.println(PRL);
		List<String> PRL1 = new ArrayList<String>(PRL);
		Collections.sort(PRL1);
		System.out.println(PRL1);
		if (PRL1.equals(PRL)) {
			System.out.println("SORTED");
		} else {
			System.out.println("NOT SORTED");
		}

		JavascriptExecutor kse = (JavascriptExecutor) driver;
		kse.executeScript("window.scrollBy(0,400)");
		driver.findElementByXPath("//label[@for='Color_s-Blue']").click();
		Thread.sleep(3000);
		kse.executeScript("window.scrollBy(0,400)");
		WebElement shoe = driver.findElementByXPath("(//img[@class='product-image wooble'])[3]");
		Actions builder1 = new Actions(driver);
		builder.moveToElement(shoe).perform();
		driver.findElementByXPath("(//div[@supc='SDL466138458'])[2]").click();
		Thread.sleep(20000);
		String PRC = driver.findElementByXPath("//span[@class='payBlkBig']").getText();
		String PRC1 = PRC.replaceAll("[^0-9]", "");
		int AMT = Integer.parseInt(PRC1);
		System.out.println("THE PRICE OF THE SHOE IS:" + AMT);
		String DSC = driver.findElementByXPath("//span[@class='percent-desc ']").getText();
		System.out.println("THE DISCOUNT OF THE SHOE IS:" + DSC);
		File src2 = driver.getScreenshotAs(OutputType.FILE);
		File dst1 = new File("./snaps/snapdeal.png");
		FileUtils.copyFile(src2, dst1);
		driver.findElementByXPath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]").click();
		Thread.sleep(1000);
		kse.executeScript("window.scrollBy(0,-200)");
		driver.findElementByXPath("(//a[@class='clear-filter-pill  '])[1]").click();
		Thread.sleep(10000);
		kse.executeScript("window.scrollBy(0,1000)");
		driver.findElementByXPath("//label[@for='Brand-VSS']").click();
		Thread.sleep(10000);
		String VSS = driver.findElementByXPath("//span[text()='(21 Items)']").getText();
		System.out.println("COUNT OF VSS BRAND SHOE IS :" + VSS);
	}
}
