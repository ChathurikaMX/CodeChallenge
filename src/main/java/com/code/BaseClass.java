package com.code;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.code.util.TestUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseClass {
	protected static AppiumDriver driver;//static is given to avoid driver object getting null when coming back to BaseClass
	protected static Properties props;
	InputStream inputStream;
	
	//Initialize the page factory element
	public BaseClass() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);//This will lnitialize the UI elements for the page factory
		//this class is the super class which all POM files will extend
	}
 
  @Parameters({"platformName","platformVersion","deviceName"})
  @BeforeTest
  public void beforeTest(String platformName,String platformVersion,String deviceName)throws Exception {
	
		  try {
			  props = new Properties();
			  String propFileName ="config.properties";
			  inputStream= getClass().getClassLoader().getResourceAsStream(propFileName);
			  props.load(inputStream);
		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("platformName", platformName);
		    caps.setCapability("platformVersion", platformVersion);
		    caps.setCapability("deviceName", deviceName);
		    caps.setCapability("automationName", props.getProperty("androidAutomationNAme"));
		    caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		    caps.setCapability("appPackage",props.getProperty("androidAppPackage"));
		    caps.setCapability("appActivity",props.getProperty("androidAppActivity"));
		    //caps.setCapability("avd", "Pixel_3_API_30");
		    //caps.setCapability("avdLaunchTimeout", 180000);
		    // caps.setCapability("adbExecTimeout", 180000);
		    
		     //caps.setCapability("appWaitForLaunch", "false");
	         //caps.setCapability("appPackage","com.google.android.calendar");
		     //caps.setCapability("appActivity","com.google.android.calendar.launch.oobe.WhatsNewFullScreen");
		     //caps.setCapability("appActivity","com.android.calendar.AllInOneCalendarActivity");
		     // caps.setCapability("appActivity","com.google.android.calendar.ICalLauncher");
		    
		   URL url = new URL(props.getProperty("appiumURL"));
		  
		    driver = new AppiumDriver(url,caps);
		    String sessionid = driver.getSessionId().toString();
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  } catch (Exception e) {
			  e.printStackTrace();
			  throw e;
		  }
		  
		  //methods for basic driver commands which can be re used to use in POM
		  }
		  
		  public void waitForVisibility(MobileElement e){
			  WebDriverWait wait = new WebDriverWait (driver,TestUtils.WAIT);
			  wait.until(ExpectedConditions.visibilityOf(e));
					  
			  
		  }

		  public void click(MobileElement e) {
			  waitForVisibility (e);
			  e.click();
		  }
		  
		  public void sendKeys(MobileElement e,String txt) {
			  waitForVisibility(e);
			  e.sendKeys(txt);
		  }
	      
		  public String getAttribute(MobileElement e,String attribute) {
			  waitForVisibility(e);
			  return e.getAttribute(attribute);
		  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}
