package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestSetup;

public class CheckoutPageStepDefinition 
{
	public WebDriver driver;
	public String homePageProductName;
	public CheckoutPage checkoutPage;
	TestSetup testSetup;
	
	public CheckoutPageStepDefinition(TestSetup testSetup)
	{
		this.testSetup=testSetup;
		this.checkoutPage = testSetup.pageObjectManager.getCheckoutPageObject();
	}
	
	@Then ("^user proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_Checkout(String itemName)
	{
		checkoutPage.viewCart();
		checkoutPage.proceedToCheckout();
		String itemAddedInCart = checkoutPage.getItemName().split("-")[0].trim();
		Assert.assertEquals(itemAddedInCart, testSetup.pageObjectManager.getHomePageObject().getProductName().split("-")[0].trim());
	}
	
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		Assert.assertTrue(checkoutPage.verifyApplyPromoCodeBTN());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderBTN());
	}
	
	
}
