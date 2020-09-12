package Practice.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumSecondProject {
	
	
	@Test
	public void SecondTest() throws IOException {
		
		Utilities.StartServer().start();
		ExtentTest test = Utilities.test;
		AndroidDriver<MobileElement>  driver=AppiumCapabilities.capabilities("AppNameSecond");
		Utilities.driver=driver;
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		driver.findElementByXPath("//android.widget.Button[@text='Displays a Toast']").click();
		test.log(LogStatus.PASS, "Succesfully Clicked on Display a Toast");
		Utilities.StartServer().stop();
	}

}
