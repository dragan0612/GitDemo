package practice.AppiumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class utilities {
	
	AndroidDriver<AndroidElement> driver;
	
	public utilities(AppiumDriver<AndroidElement> driver)
	{
		this.driver= (AndroidDriver<AndroidElement>) driver;
	}
	
	
	public void scrollToText(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	public void clickOntext(String text)
	{
		driver.findElement(By.xpath("//*[@text='"+text+"']")).click();
	}
	
	

}
