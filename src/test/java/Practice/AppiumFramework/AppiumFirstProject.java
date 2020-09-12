package Practice.AppiumFramework;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import io.appium.java_client.MobileElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import pageObjectpac.HomePage;


public class AppiumFirstProject {
	
	ExtentTest test = Utilities.test;
	ExtentReports report=Utilities.reports;
	
	@BeforeSuite
	public void startEmulator() throws IOException, Exception {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();   
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		//Utilities.StartEmuator();
	}
	
	@BeforeTest
	public static void startTest()
	{
		Utilities.reports = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\ExtentReportResults.html");
		Utilities.reports.loadConfig(new File(System.getProperty("user.dir")+"\\Reports\\Extent-Config.xml"));
		Utilities.test = Utilities.reports.startTest("DemoTest");
	}

	@Test
	public void FirstTestCase() throws MalformedURLException, Exception {
		
		Utilities.StartServer().start();
		AndroidDriver<MobileElement> driver=AppiumCapabilities.capabilities("AppName");
		Utilities.driver=driver;
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		HomePage HP=new HomePage(driver);
		//HP.ViewButton.click();
		
		//MobileElement ViewsBtnObj = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		//Tapping
		TouchAction touchActionObj=new TouchAction(driver);
		touchActionObj.tap(tapOptions().withElement(element(HP.ViewButton))).perform();
		test.log(LogStatus.PASS, "Clicked Succesflly on View Button");
		
		Utilities.StartServer().stop();

	}
	
	@AfterTest
	public void reportsflush() {
		
		report.endTest(test);
		report.flush();
		
	}
	
}

