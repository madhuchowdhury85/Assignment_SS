package library;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility 
{

	// Method to wait for an element to be visible or clickable and return the
	// webelement
	public static WebElement waitforElementVisible(WebDriver driver, WebElement element) 
	{
		// create an object of webdriver wait
		WebDriverWait wait = new WebDriverWait(driver, 45);

		// wait until webelement is visible
		wait.until(ExpectedConditions.visibilityOf(element));

		// wait until webelement is clickable
		wait.until(ExpectedConditions.elementToBeClickable(element));

		// return webelement
		return element;
	}

	// Method to halt the program for given time
	public static void sleep(int time) 
	{
		// halt the program for given time
		try {
			Thread.sleep(time * 1000);
		}
		// print the exception
		catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Method to generate current date and time in the desired format
	// return the dateandtime
	public static String getCurrentDate_Time() 
	{

		// Create a Date object
		Date data = new Date();

		// Create an object of SimpleDateFormat with the given format
		SimpleDateFormat dateFormater = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

		// Return the date in the given format
		return dateFormater.format(data);
	}

	// Method to capture screenshot and return the file destination
	public static String captureScreenshot(WebDriver driver) 
	{
		// Convert web driver object to TakeScreenshot- typecasting
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Take screenshot and store as a file format
		File src = ts.getScreenshotAs(OutputType.FILE);

		// File destination
		String destination = System.getProperty("user.dir") + "\\Screenshots\\SS_" + getCurrentDate_Time() + ".png";
		try 
		{
			// now copy the screenshot to desired location using copyFile
			FileUtils.copyFile(src, new File(destination));

		} catch (Exception e) {
			System.out.println("Unable to capture screenshots " + e.getMessage());
		}
		// return file destination
		return destination;
	}

}
