package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestSetup;

public class Hooks 
{
	TestSetup testSetup;
	public Hooks(TestSetup testSetup)
	{
		this.testSetup=testSetup;
	}
	
	@After
	public void AfterScenario() throws IOException
	{
		testSetup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
		public void addScreenshot(Scenario scenario) throws WebDriverException, IOException
		{
			if(scenario.isFailed())
			{
				File sourcePath = ((TakesScreenshot)testSetup.testBase.WebDriverManager()).getScreenshotAs(OutputType.FILE);
				byte[] fileContent=FileUtils.readFileToByteArray(sourcePath);
				scenario.attach(fileContent, "image/png", "image");
			}
		}
}
