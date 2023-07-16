package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.EmailTimeStamp;

public class FunctionalFieldsPage {
	
	private WebDriver driver;
	
	public FunctionalFieldsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Test Cases for Functionality:

		//Verify that all required fields are marked as mandatory and cannot be submitted empty.
		//Check if the form validates the email address field and only accepts valid email formats.
		//Verify that the phone number field only accepts numeric input and follows the expected format.
		//Check if the form provides real-time validation for required fields and displays error messages when they are left empty.
		//Verify that the submit button triggers the form submission process.
		//Check if a success message or confirmation is displayed after successful form submission.
		//Verify that the form clears all fields after successful submission.
		//Check if the form retains the previously entered data if there is an error during submission.
		//Verify that the form handles errors appropriately and displays relevant error messages when there are submission issues.
		//Check if the form submission triggers any  processes or notifications.
	
	public void verifyFunctionalFieldWithValidCredentials() {
		
		//to perform Scroll on application using selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("Vijay Kumar Gajula");
		js.executeScript("arguments[0].scrollIntoView();",name );
		driver.findElement(By.name("email")).sendKeys(EmailTimeStamp.generateTimestamp());
		driver.findElement(By.name("phone")).sendKeys("9346362382");
		driver.findElement(By.name("notice_time")).sendKeys("30");
		driver.findElement(By.name("experience")).sendKeys("3");
		WebElement fileInput = driver.findElement(By.id("inputFile"));
		String filepath = "C://Users//Gajula Praveen Kumar//Downloads//VijayKumarResume.doc";
		fileInput.sendKeys(filepath);
		driver.findElement(By.tagName("textarea")).sendKeys("I have over 3.5 years of experience on manual and automation testing with core java.");
		driver.findElement(By.xpath("//button[text()='APPLY NOW']")).sendKeys(Keys.ENTER);
		
		WebElement successfulMessage = driver.findElement(By.tagName("h4"));
		Assert.assertTrue(successfulMessage.isDisplayed());
		
	}
	
	public void verifyFunctionalFieldWithInvalidCredentials() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("Vijay Kumar Gajula");
		js.executeScript("arguments[0].scrollIntoView();",name );
		driver.findElement(By.name("email")).sendKeys(EmailTimeStamp.generateTimestamp());
		driver.findElement(By.name("phone")).sendKeys("9346362382");
		driver.findElement(By.name("notice_time")).sendKeys("30");        
		driver.findElement(By.name("experience")).sendKeys("3.5");          // Invalid input
		WebElement fileInput = driver.findElement(By.id("inputFile"));
		String filepath = "C://Users//Gajula Praveen Kumar//Downloads//VijayKumarResume.doc";
		fileInput.sendKeys(filepath);
		driver.findElement(By.tagName("textarea")).sendKeys("I have over 3.5 years of experience on manual and automation testing with core java.");
		driver.findElement(By.xpath("//button[text()='APPLY NOW']")).sendKeys(Keys.ENTER);
		
		WebElement ErrorMessage = driver.findElement(By.xpath("//p[text()='A valid integer is required.']"));
		Assert.assertTrue(ErrorMessage.isDisplayed());
	}
	
	public void verifyFunctionalFieldWithoutCredentials() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement btn = driver.findElement(By.xpath("//button[text()='APPLY NOW']"));
		btn.sendKeys(Keys.ENTER);
		js.executeScript("arguments[0].scrollIntoView();",btn );
		
		WebElement ErrorMessage = driver.findElement(By.xpath("//p[text()='something went wrong! please try again later']"));
		Assert.assertTrue(ErrorMessage.isDisplayed());
	}

}
