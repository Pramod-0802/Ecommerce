package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage 
{
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By searchTBX = By.xpath("//input[@type='search']");
	private By productName = By.xpath("//h4[@class='product-name']");
	private By topDealsLNK = By.linkText("Top Deals");
	private By addProductBTN = By.xpath("//a[@class='increment']");
	private By removeProductBTN = By.xpath("//a[@class='decrement']");
	private By addToCartBTN = By.xpath("//button[contains(text(),'ADD TO CART')]");

	public void addToCart()
	{
		driver.findElement(addToCartBTN).click();
	}
	
	public void addProduct(int quantity)
	{
		int i=1;
		while(i<quantity)
		{
			driver.findElement(addProductBTN).click();
			i++;
		}
	}
	
	public void removeProduct()
	{
		driver.findElement(removeProductBTN).click();
	}
		
	public void searchProduct(String name)
	{
		driver.findElement(searchTBX).sendKeys(name);
	}

	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public WebElement getWebElementProduct()
	{
		return driver.findElement(productName);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickTopDealsLink()
	{
		driver.findElement(topDealsLNK).click();
	}
}
