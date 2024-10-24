package lms.ui.hackathon.stepDefinitions;

import java.io.File;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lms.ui.hackathon.configs.CommonConfigs;
import lms.ui.hackathon.configs.ConfigLoader;
import lms.ui.hackathon.configs.ConfigurationManager;
import lms.ui.hackathon.utilities.TestContextSetUp;
import numpy.seleniumsmasher.lms.factory.DriverFactory;

public class Hooks {
	
	TestContextSetUp testContextSetUp;
	Properties prop;
	DriverFactory df;
	WebDriver driver;
	CommonConfigs config;
	
	/*
	 * public Hooks(TestContextSetUp testContextSetup) { this.testContextSetUp =
	 * testContextSetup; }
	 */
	
	@Before
	public void setUp() throws Throwable {
		
		String browserValueFromTestNG = null;
		
		if(ConfigLoader.getBrowserType() != null) {
			browserValueFromTestNG = ConfigLoader.getBrowserType();
		
		
		prop = ConfigurationManager.initProp();
		config.setUrl(prop.getProperty("url"));
		driver = df.initDriver(prop, browserValueFromTestNG);
		testContextSetUp = new TestContextSetUp();
			
		}
	}
	
	
	
	@After
	public void AfterScenario() throws Throwable
	{
		testContextSetUp.base.WebDriverManager().quit();
	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws Throwable
	{
		WebDriver driver =testContextSetUp.base.WebDriverManager();
		if(scenario.isFailed())
		{
			//screenshot
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}

	}

}
