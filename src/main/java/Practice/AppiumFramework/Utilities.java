package Practice.AppiumFramework;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Utilities {
	
	public static AppiumDriverLocalService Service;
	public static AndroidDriver<MobileElement> driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static AppiumDriverLocalService StartServer() {
		
		//if(!isAvailable(4723)) {
		Service= AppiumDriverLocalService.buildDefaultService();
		//Service.start();
		//}
		return Service;
		
	}
	
	public static boolean isAvailable(int portNr) {
		  boolean portFree;
		  try (ServerSocket ignored = new ServerSocket(portNr)) {
		      portFree = true;
		  } catch (IOException e) {
		      portFree = false;
		  }
		  return portFree;
		}
	
	public static void StartEmuator() throws IOException, Exception {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\StartEmulator.bat");
		Thread.sleep(10000);
	}
	
	public static File TakeScreenshotofScreen(String ScreenShotName) throws IOException {
		String ProjFolPath=System.getProperty("user.dir");
		File DestFile=new File(ProjFolPath+"\\Reports\\"+ScreenShotName+".png");
		try {
		TakesScreenshot scrShotObj=((TakesScreenshot)driver);
		File ScreenshotFilevar = scrShotObj.getScreenshotAs(OutputType.FILE);
		System.out.println(DestFile.toString());
		FileUtils.copyFile(ScreenshotFilevar, DestFile);
		}catch(NullPointerException e) {
			
		}
		return DestFile;
		
		
		
	}

}
