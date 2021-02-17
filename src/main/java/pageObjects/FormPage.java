package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	public FormPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement btnLetsShop;
	
	
	public WebElement getNameField()
	{
		System.out.println("Trying to find the Name field");
		return nameField;
	}
	
	public WebElement getCountrySelection()
	{
		System.out.println("Trying to find the country field");
		return countrySelection;
	}
	
	public WebElement getBtnLetsShop()
	{
		System.out.println("Trying to find the Let Shop btn field");
		return btnLetsShop;
	}
	


}
