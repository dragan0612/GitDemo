package practice.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class baseEcomerce {
	
	public static AppiumDriverLocalService service;
	
	public static AndroidDriver<AndroidElement> driver;
	
	
	public AppiumDriverLocalService startServer()
	{
		boolean flag = checkIfServerIsRunnning(4723);
		if(!flag)
		{
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}
	
     public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
     
     public static void startEmulator() throws InterruptedException, IOException
     {	 
    	 Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
         Thread.sleep(6000);
     }
          

	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practice\\AppiumFramework\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);				
		
		File f = new File("src");
		File fs = new File(f,(String) prop.get(appName));
		
		DesiredCapabilities cap = new DesiredCapabilities();
		String device = (String) prop.get("device");
		if(device.contains("emulator"))
		{
			startEmulator();
		}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		//cap.setCapability(MobileCapabilityType.VERSION, "10.0");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "14");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		//cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		//cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}
	
	public static void getScreenshot(String s) throws IOException
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\"+s+".png"));
	}

}
