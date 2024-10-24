package lms.ui.hackathon.configs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigurationManager {

	private static Properties prop;
	private static FileInputStream ip;

	public static Properties initProp() {
		
		try {
			prop = new Properties();
		
		String envName = System.getProperty("env");
		
		
			if(envName == null) {
				ip = new FileInputStream("src\\test\\resources\\config\\envconfig_qa.properties");
				
			}
			else 
			{
				System.out.println("Running test on "+envName+" environment");
				
					switch (envName.toLowerCase().trim()) {
					case "qa":
						ip = new FileInputStream("src\\test\\resources\\config\\envconfig_qa.properties");
						break;
					case "dev":
						ip = new FileInputStream("src\\test\\resources\\config\\envconfig_dev.properties");
						break;
					case "stage":
						ip = new FileInputStream("src\\test\\resources\\config\\envconfig_stage.properties");
						break;						
					default:
						throw new RuntimeException("Please padd the right env name ..\" + envName");
					}				
			}
			
			prop.load(ip);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
		
	}
}
