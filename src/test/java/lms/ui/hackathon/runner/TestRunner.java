package lms.ui.hackathon.runner;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lms.ui.hackathon.configs.ConfigLoader;
//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
					glue = {"lms.ui.hackathon.stepdefinitions"},
					//tags="@loginPage-21",
					plugin = {"pretty", "html:target/cucumber-Reports.html" , "json:target/cucumber.json",
							"junit:target/Cucumber.xml",
							//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"rerun:target/failed_scenarios.txt"},
					//monochrome = true,
					publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
@Override
@DataProvider(parallel = true)
public Object[][] scenarios() { 
	return super.scenarios(); }
@BeforeTest
@Parameters({"browser"})
public void defineBrowser(@Optional("Chrome")String browser) throws Throwable {
	ConfigLoader.setBrowserType(browser);
	}
}
