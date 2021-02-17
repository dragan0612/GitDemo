package practice.AppiumFramework;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckOutPage;
import pageObjects.FormPage;
import pageObjects.Products;


public class ecomerce_tc_4 extends baseEcomerce {

	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void totalValidation(String input) throws IOException, InterruptedException {	
		
		service = startServer();
		AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FormPage formpage = new FormPage(driver);
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		utilities u = new utilities(driver);
		Products p = new Products(driver);
		formpage.getNameField().sendKeys(input);
		formpage.femaleOption.click();
		formpage.getCountrySelection().click();
		u.scrollToText("Bahamas");
		u.clickOntext("Bahamas");
		formpage.getBtnLetsShop().click();
		
		p.getAddToCartField().get(0).click();
		p.getAddToCartField().get(0).click();
		
		p.getCheckOutBtn().click();
		
		Thread.sleep(3000);
		
		int size = checkOutPage.getProductList().size(); 
		
		double sum = 0;
		for(int i=0;i<size;i++)
		{
			String amount = checkOutPage.getProductList().get(i).getText();
			double amountValue= getAmount(amount);
			sum = sum + amountValue;
		}
		
		System.out.println(sum);
		
		String totalAmount = checkOutPage.getTotalAmount().get(0).getText();
		double doubleTotalAmount= getAmount(totalAmount);
		System.out.println(doubleTotalAmount);
		
		Assert.assertEquals(sum, doubleTotalAmount);
		
		service.stop();
	}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		 Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		 Thread.sleep(3000);
	}
	
	public static double getAmount(String value) 
	{
		value = value.substring(1);
		double amount= Double.parseDouble(value);
		return amount;
	}

}
