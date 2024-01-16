package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.OffersPage;
import utils.TestSetup;

public class OffersPageStepDefinition 
{
	public String offersPageProductName;
	TestSetup testSetup;

	public OffersPageStepDefinition(TestSetup testSetup)
	{
		this.testSetup=testSetup;
	}
		
	@Then("^user searched with same shortname (.+) on Offers page$")
	public void user_searched_with_same_shortname_on_offers_page(String shortname) 
	{
		switchToOffersPage();
		OffersPage offersPage = testSetup.pageObjectManager.getOffersPageObject();
		offersPage.searchProduct(shortname);
		WebDriverWait wait = testSetup.genericUtils.explicitWaitForElement();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[1]")));
	    offersPageProductName = offersPage.getProductName();
	    System.out.println("Product name displayed on Offers page is : "+offersPageProductName);
	}
	
	public void switchToOffersPage()
	{
		HomePage homePage = testSetup.pageObjectManager.getHomePageObject();
		homePage.clickTopDealsLink();
		testSetup.genericUtils.switchToChildWindow();
	}

	@Then("validate the product name matches with that on the Home page")
	public void validate_the_product_name_matches_with_that_on_the_Home_page()
	{
		Assert.assertEquals(offersPageProductName, testSetup.homePageProductName);
	}
}
