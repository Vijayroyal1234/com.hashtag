package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	
	 public WebDriver intializeBrowserAndOpenApplicationURL(String browserName) {
		
		switch(browserName.toLowerCase()) {
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case"edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			default:
				System.out.println("Given browerName is not available.");
				break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.hashtag-ca.com/careers/apply?jobCode=QAE001");
		
		return driver;
	}
}
