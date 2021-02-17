package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Products {
	
	public Products(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement checkOutBtn;
	
	
	public List<WebElement> getAddToCartField()
	{
		System.out.println("Trying to find the Add to cart field");
		return addToCart;
	}
	
	public WebElement getCheckOutBtn()
	{
		System.out.println("Trying to find the Checkout btn");
		return checkOutBtn;
	}
	
	

}
