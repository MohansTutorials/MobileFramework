package Practice.AppiumFramework;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumCapabilities {
	
	public static AndroidDriver<MobileElement> capabilities(String AppName) throws IOException {
		
		Properties readProperties = ReadProperties.readProperties();
		DesiredCapabilities DC=new DesiredCapabilities();
		DC.setCapability(MobileCapabilityType.DEVICE_NAME, readProperties.get("EmulatorName"));
		DC.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"\\src\\"+readProperties.getProperty(AppName));	
		
		URL ConnectionServerLink=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<MobileElement> AndDri=new AndroidDriver<MobileElement>(ConnectionServerLink,DC);
		
		return AndDri;
	}

}
