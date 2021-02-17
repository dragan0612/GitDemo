package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPage {
	
	public CheckOutPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private List<WebElement> totalAmount;
	
	public List<WebElement> getProductList()
	{
		return productList;
	}
	
	public List<WebElement> getTotalAmount()
	{
		return totalAmount;
	}

}
