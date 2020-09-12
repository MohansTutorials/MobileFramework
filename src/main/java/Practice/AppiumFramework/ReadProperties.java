package Practice.AppiumFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	public static Properties readProperties() throws IOException {
		
		String ProjPath=System.getProperty("user.dir");
		FileInputStream FIO=new FileInputStream(ProjPath+"\\src\\main\\java\\global.properties");
		Properties p=new Properties();
		p.load(FIO);
		return p;
		
	}
	
	

}
