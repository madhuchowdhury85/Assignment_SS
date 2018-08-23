package base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseTest 
{

   public static WebDriver driver;
	public static Properties prop;
   
	public BaseTest()
	{
		// Specify the file location here. I used
				// object repository inside project directory only
		File src = new File("./Config/config.properties");

		try {
			// Create FileInputStream object
			FileInputStream input = new FileInputStream(src);
			
			// Create Properties class object to read properties file
			prop = new Properties();
			
			// Load file so we can use into our script
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method to start the web browser with browser name and URL
   public static WebDriver startBrowser()
	
	{
	// browser is the parameter fetching from config file
	   String browserName= prop.getProperty("browser");
	   
		if(browserName.equalsIgnoreCase("chrome"))
		{
			// Specify the driver location here. I used
			// object repository inside project directory
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			// Specify the driver location here. I used
			// object repository inside project directory
			System.setProperty("webdriver.gecko.driver",  "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			// Specify the driver location here. I used
						// object repository inside project directory
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer1.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Please provide valid browser");
		}
		
		driver.manage().window().maximize();
		
		// Wait for 20 seconds when trying to find an element or elements
		// (if) they are not immediately available
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Pass application- url is the parameter fetching from config file
		driver.get(prop.getProperty("url"));
		return driver;
		}
   
   
   
}
