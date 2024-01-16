package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
	public WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By cartBTN = By.xpath("//img[@alt='Cart']");
	private By proceedToCheckoutBTN = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By applyPromoBTN = By.xpath("//button[contains(text(),'Apply')]");
	private By placeOrderBTN = By.xpath("//button[contains(text(),'Place Order')]");
	private By itemName = By.xpath("//p[@class='product-name']");
	
	public String getItemName()
	{
		return driver.findElement(itemName).getText();
	}

	public void viewCart()
	{
		driver.findElement(cartBTN).click();
	}

	public void proceedToCheckout()
	{
		driver.findElement(proceedToCheckoutBTN).click();
	}
	
	public boolean verifyApplyPromoCodeBTN()
	{
		return driver.findElement(applyPromoBTN).isDisplayed();
	}
	
	public void applyPromoCode()
	{
		driver.findElement(applyPromoBTN).click();
	}

	public boolean verifyPlaceOrderBTN()
	{
		return driver.findElement(placeOrderBTN).isDisplayed();
	}
	
	public void placeOrder()
	{
		driver.findElement(placeOrderBTN).click();
	}
}
