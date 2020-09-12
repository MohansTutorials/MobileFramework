package Practice.AppiumFramework;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class Listeners implements ITestListener{
	
	public static int PassScreenShotItr=1;
	public static int FailScreenShotItr=1;
	
	
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Utilities.TakeScreenshotofScreen(result.getName()+FailScreenShotItr);
			FailScreenShotItr=FailScreenShotItr+1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
			
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		
		try {
			Utilities.TakeScreenshotofScreen(result.getName()+PassScreenShotItr);
			PassScreenShotItr=PassScreenShotItr+1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
