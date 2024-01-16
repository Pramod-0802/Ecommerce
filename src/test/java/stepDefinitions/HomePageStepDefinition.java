package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utils.TestSetup;

public class HomePageStepDefinition 
{
	public WebDriver driver;
	public String homePageProductName;
	public String offersPageProductName;
	public HomePage homePage; 
	TestSetup testSetup;
	
	public HomePageStepDefinition(TestSetup testSetup)
	{
		this.testSetup=testSetup;
		this.homePage = testSetup.pageObjectManager.getHomePageObject();
	}
	
	@Given("user is on Home page")
	public void user_is_on_home_page()
	{
		String pageTitle = homePage.getPageTitle();
		 System.out.println("Page Title on Home page is : "+pageTitle);
		Assert.assertEquals(pageTitle, "GreenKart - veg and fruits kart");
	}
	
	@When("^user searched with shortname (.+) and extract the product name$")
	public void multiple_searched_with_shortname_and_extract_the_product_name(String shortname) throws InterruptedException 
	{
		homePage.searchProduct(shortname);
		Thread.sleep(2000);
	    testSetup.homePageProductName = homePage.getProductName().split("-")[0].trim();
	    System.out.println("Product name displayed on Home page is : "+testSetup.homePageProductName);
	}
	
	@When("^added (.+) quantities of selected product to the cart$")
	public void added_quantities_of_selected_product_to_the_cart(String quantity) throws InterruptedException
	{
		homePage.addProduct(Integer.parseInt(quantity));
		homePage.addToCart();
	}	
}
