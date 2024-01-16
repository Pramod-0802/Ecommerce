package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager 
{
	public WebDriver driver;
	public HomePage homePage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public HomePage getHomePageObject()
	{
		homePage = new HomePage(driver);
		return homePage;
	}
	
	public OffersPage getOffersPageObject()
	{
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CheckoutPage getCheckoutPageObject()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
}
