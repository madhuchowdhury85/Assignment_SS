package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factory.DataProviderFactory;
import library.Utility;
import pages.HomePage;
import pages.ProductDetailsPage;

public class CustomMadeProductsSteps extends BaseTest 
{
	WebDriver driver;
	HomePage homeP;
	ProductDetailsPage productP;

	@Before
	public void setup() 
	{
		// Initiate browser
		driver = BaseTest.startBrowser();

		// Navigate to Home Page
		homeP = new HomePage();

	}

	@After(order = 0)
	public void logOut() 
	{
		driver.quit();

	}

	@After(order = 1)
	public void endTest(Scenario scenario) 
	{
		try {
			//This method will capture screenshot at the end of test
			Utility.captureScreenshot(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Given("^User is in home page and verify the title of home page$")
	public void user_is_in_home_page_and_verify_the_title_of_home_page() 
	{
		String expected_title = "Suitsupply | Men’s Suits, Jackets, Shirts, Trousers, and More | Suitsupply Online Store";
		String actual_title = driver.getTitle();

		// Verify title of Home Page
		Assert.assertEquals(expected_title, actual_title);
		System.out.println("User is in custom made page and title verified");

	}

	@When("^Navigate to a product and user is in custom made product detail page$")
	public void navigate_to_a_product_and_user_is_in_custom_made_product_detail_page() 
	{
		// Call the method to navigate cumtom made product details page
		productP = homeP.navigatetoProductDetails();
		System.out.println("User navigated to custom made product page");

	}

	@Then("^Choose the color of the product$")
	public void choose_the_color_of_the_product() 
	{
		// Call the method to choose color
		productP.choose_color(DataProviderFactory.getexcel().getstringvalue("Product", 1, 1));
		System.out.println("Color is choosen for the custom product");
	}

	@Then("^Choose the design of the product$")
	public void choose_the_design_of_the_product() 
	{
		// Call the method to choose design
		productP.choose_design(DataProviderFactory.getexcel().getstringvalue("Product", 1, 2));
		System.out.println("Design type is choosen for the custom product");
	}

	@Then("^Choose the product from color and design combination$")
	public void choose_the_product_from_color_and_design_combination() 
	{
		// Call the method to choose fabric
		productP.choose_designpattern(DataProviderFactory.getexcel().getstringvalue("Product", 1, 3));
		System.out.println("Product from color and design combination is choosen");
	}

	@Then("^Choose the fit of the product$")
	public void choose_the_fit_of_the_product() 
	{
		// Call the method to choose fit
		productP.choose_fitpattern(DataProviderFactory.getexcel().getstringvalue("Product", 1, 4));
		System.out.println("Product from fit menu is choosen");
	}

	@Then("^Choose the size of the product$")
	public void choose_the_size_of_the_product() 
	{
		// Call the method to choose size
		productP.choose_size(String.valueOf(DataProviderFactory.getexcel().getnumericvalue("Product", 1, 5)));
		System.out.println("Size is choosen for the custom made product");
	}

	@Then("^Verify the product fabric in Custom made section$")
	public void verify_the_product_fabric_in_Custom_made_section() 
	{
		String actual_fabric = productP.product_fabric().toLowerCase();
		String expected_fabric = DataProviderFactory.getexcel().getstringvalue("Product", 1, 3).toLowerCase();

		// Verify the actual fabric with the expected fabric
		Assert.assertEquals(expected_fabric, actual_fabric);
		System.out.println("Expected fabric and actual fabric matched");
	}

	@Then("^Verify the product fit in Custom made section$")
	public void verify_the_product_fit_in_Custom_made_section() 
	{
		String actual_fit = productP.product_fit().toLowerCase();
		String expected_fit = DataProviderFactory.getexcel().getstringvalue("Product", 1, 4).toLowerCase();
		
		// Verify the actual fit with the expected fit
		Assert.assertEquals(expected_fit, actual_fit);
		System.out.println("Expected fit and actual fit matched");
	}

	@Then("^Verify the product size in Custom made section$")
	public void verify_the_product_size_in_Custom_made_section() 
	{
		String actual_size = productP.product_size();
		String expected_size = String.valueOf(DataProviderFactory.getexcel().getnumericvalue("Product", 1, 5));
		
		// Verify the actual size with the expected size
		Assert.assertEquals(expected_size, actual_size);
		System.out.println("Expected size and actual size matched");
	}

}
