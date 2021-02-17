package practice.AppiumFramework;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;



public class ApiDemoTest extends baseEcomerce  {

	@Test
	public void apiDemo() throws IOException, InterruptedException {
		
		service = startServer();
		AndroidDriver<AndroidElement> driver=Capabilities("apiDemo");
		driver.findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		Thread.sleep(1000);
		
		HomePage h= new HomePage(driver);
		Preferences p = new Preferences(driver);
		h.Preferences.click();
		Thread.sleep(1000);
		p.PreferenceDependencies.click();
		Thread.sleep(1000);
		driver.findElementById("android:id/checkbox").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		Thread.sleep(1000);
		driver.findElementByClassName("android.widget.EditText").sendKeys("Test");
		Thread.sleep(1000);
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		//xpath id className
		/*
		 * xpath syntax
		 * tagName[@atribute="value"]
		 */
		service.stop();
        
	}

}
