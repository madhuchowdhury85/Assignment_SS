package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DataProviderFactory;
import library.Utility;

public class ProductDetailsPage extends HomePage 
{
	// Constructor
	public ProductDetailsPage()

	{
		// Initiate a webdriver instance and all elements will be initialised
		PageFactory.initElements(driver, this);
	}

	// ProductDetailsPage Object repository
	@FindBy(xpath = "//span[contains(text(),'Color')]")
	WebElement product_color;

	@FindBy(xpath = "//span[contains(text(),'Design')]")
	WebElement product_design;

	@FindBy(xpath = "//div[contains(@class,'side-bar-content')]//button[contains(text(),'Add To Bag')]")
	WebElement addtobag_Btn;

	@FindBy(xpath = "//a[contains(text(),'Secure checkout')]")
	WebElement secure_checkout_Btn;

	@FindBy(xpath = "//*[@id=\"legacy-overide-id-bottom\"]//div[contains(@class,'side-bar-content')]//span[text()='Fabric']//following::span[1]")
	WebElement actual_fabric;

	@FindBy(xpath = "//*[@id=\"legacy-overide-id-bottom\"]//div[contains(@class,'side-bar-content')]//span[text()='Fit']//following::span[1]")
	WebElement actual_fit;

	@FindBy(xpath = "//*[@id=\"legacy-overide-id-bottom\"]//div[contains(@class,'side-bar-content')]//span[text()='Size']//following::span[1]")
	WebElement actual_size;

	// Method to choose color
	public String choose_color(String color) 
	{
		Utility.waitforElementVisible(driver, product_color).click();

		// Find a list of color options
		List<WebElement> color_filter = driver
				.findElements(By.xpath("//li[contains(@class,'filter-color-container')]//label"));

		for (WebElement color_all : color_filter) {
			// Get the color using the attribute value
			String color_name = color_all.getAttribute("data-color-code");

			// Verify the color in application with the name entered from excel
			if (color_name.contains(color)) {
				/* if yes then click on link (item) */
				Utility.sleep(1);
				color_all.click();

				break;
			}
		}
		return color;
	}

	// Method to choose design
	public String choose_design(String design) 
	{
		Utility.waitforElementVisible(driver, product_design).click();

		// Find a list of design options
		List<WebElement> design_filter = driver
				.findElements(By.xpath("//li[contains(@class,'filter-dessin-container')]//label"));

		for (WebElement design_all : design_filter) {
			// Get the design using the attribute value
			String design_name = design_all.getAttribute("data-dessin-code");

			// Verify the design in application with the name entered from excel
			if (design_name.contains(design)) {
				/* if yes then click on link (item) */
				Utility.sleep(1);
				design_all.click();

				break;
			}
		}
		return design;
	}

	// Method to choose fabric
	public String choose_designpattern(String design_pattern) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Utility.sleep(2);

		// Locate the fabric using xpath
		WebElement design_image = driver
				.findElement(By.xpath("//div[contains(text(),'" + design_pattern + "')]//preceding::img[1]"));

		// Identify the webelemnt using javascriptexecutor as this is present inside a view
		js.executeScript("arguments[0].scrollIntoView(true)", design_image);

		// Click on fabric
		Utility.waitforElementVisible(driver, design_image).click();

		return design_pattern;
	}

	// Method to choose fit
	public String choose_fitpattern(String fit_pattern) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Utility.sleep(3);

		// Locate the fit using xpath
		WebElement fit_image = driver.findElement(By.xpath("//div[contains(text(),'" + fit_pattern + "')]"));

		// Identify the webelemnt using javascriptexecutor as this is present inside a view
		js.executeScript("arguments[0].scrollIntoView(true)", fit_image);

		// Click on fit
		Utility.waitforElementVisible(driver, fit_image).click();

		return fit_pattern;
	}

	// Method to choose size
	public String choose_size(String size) {

		// List of size options
		List<WebElement> size_chart = driver
				.findElements(By.xpath("//div[contains(@class,'configurators--sizes-group')]//label "));

		for (WebElement ele_size : size_chart) {
			// Get the text of size
			String product_size = ele_size.getText();

			// Verify the size in application with the size entered from excel
			if (product_size.contentEquals(size)) 
			{
				/* if yes then click on link (iteam) */
				Utility.sleep(1);
				ele_size.click();

				break;
			}
		}
		return size;
	}

	// Method to get the actual value of fabric from application
	public String product_fabric() 
	{
		return actual_fabric.getText();
	}

	// Method to get the actual value of fit from application
	public String product_fit() 
	{
		return actual_fit.getText();
	}

	// Method to get the actual value of size from application
	public String product_size() 
	{
		return actual_size.getText();
	}

	/*
	 * public CheckoutPage navigatetoCheckoutPage() { Actions act= new
	 * Actions(driver);
	 * act.pause(3000).moveToElement(addtobag_Btn).click().build().perform();
	 * act.pause(3000).moveToElement(secure_checkout_Btn).click().build().perform();
	 * 
	 * return new CheckoutPage(); }
	 */

}
