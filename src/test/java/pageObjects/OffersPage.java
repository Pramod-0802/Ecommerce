package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage 
{
	public WebDriver driver;
	public OffersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By searchTBX = By.xpath("//input[@type='search']");
	private By productName = By.xpath("//tr/td[1]");
	
	public void searchProduct(String name)
	{
		driver.findElement(searchTBX).sendKeys(name);
	}

	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

}
