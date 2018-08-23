package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import factory.DataProviderFactory;
import library.Utility;

public class HomePage extends BaseTest 
{
	// Constructor
	public HomePage() 
	{
		// Initiate a webdriver instance and all elements will be initialised
		PageFactory.initElements(driver, this);
	}

	// Home Page Object Repository
	@FindBy(xpath = "//span[contains(text(),'Custom made')][not(contains(text(),'suit'))]")
	WebElement custom_made_Btn;

	@FindBy(xpath = "//div[contains(@class,'dyo-menu-container')]//span[text()='Jacket']")
	WebElement product;

	public ProductDetailsPage navigatetoProductDetails() 
	{
		Utility.waitforElementVisible(driver, custom_made_Btn).click();

		Utility.waitforElementVisible(driver, product).click();

		return new ProductDetailsPage();
	}

}
