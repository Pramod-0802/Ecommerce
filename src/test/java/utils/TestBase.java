package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public WebDriver driver;
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("QA-URL");	
		
		if(driver==null)
		{
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				System.getProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
			{
				System.getProperty("webdriver.edge.driver", System.getProperty("user.dir")+ "\\src\\test\\resources\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(URL);	
		}
		return driver;
	}

}
