package numpy.seleniumsmasher.lms.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BroswerOptionsManager {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;

	/*
	 * Note: Pass meta data like browser version or platform or session name by
	 * following this:https://www.selenium.dev/documentation/grid/getting_started/
	 */
	public BroswerOptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {

		co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			co.addArguments("--headless");
		}
		co.setBrowserVersion("129");

		return co;
	}

	public FirefoxOptions getFirefoxOptions() {

		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			fo.addArguments("--headless");
		}

		return fo;
	}

	public EdgeOptions getEdgeOptions() {

		eo = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			eo.addArguments("--headless");
		}

		return eo;
	}

}
