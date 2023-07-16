package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//Test Cases for UI:

	//Verify that the page displays the company logo and branding elements.
	//Check if the page has a clear and descriptive title.
	//Verify that the form fields are properly labeled.
	//Check if the form includes fields for name, email, phone number, and any other required information.
	//Verify that the form has a submit button to initiate the application process.
	//Check if the page layout is responsive and adjusts appropriately on different screen sizes.
	//Verify that the page has a consistent and visually appealing color scheme.
	//Check if the page contains relevant images and icons.
	//Verify that the form fields and buttons have proper alignment and spacing.
	//Check if the page includes appropriate error messages or validations for incorrect input.

	public void verifyHomepageLogoISDisplayedOrNot() {
		
		WebElement logo = driver.findElement(By.xpath("(//img[@id='logo'])[1]"));
		if(logo.isDisplayed())
			System.out.println("After navigating to homepage,logo is displayed");
		else
			System.out.println("After navigating to homepage,logo is not displayed");
	}
	
	public void verifyHomePageTitle() {
		
		String expectedTitle = "hashtag-ca.com/careers/apply?jobCode=QAE001";
		String currentTitle = driver.getTitle();
		if(currentTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("After navigating to homepage, title contains same as expected.");
		else
			System.out.println("After navigating to homepage, title not contains same as expected.");
	}
	
	public void verifyHomePageHeading() {
		
		String expectedHeading = "Quality Assurance (QA) Engineer";
		String currentHeading = driver.findElement(By.xpath("//span[text()='Quality Assurance (QA) Engineer']")).getText();
		if(currentHeading.equalsIgnoreCase(expectedHeading))
			System.out.println("After navigating to homepage, heading contains same as expected.");
		else
			System.out.println("After navigating to homepage, heading not contains same as expected.");
	}
	
	public void verifyHomePageSummaryAndResponsiblities() {
		
		WebElement summary_responsibilities = driver.findElement(By.xpath("//p[text()='We are looking for a Quality Assurance (QA) engineer to develop and execute manual and automated tests to ensure product quality.']"));
		
		Assert.assertTrue(summary_responsibilities.isDisplayed());
	}
	
	public void verifyHomePageFormFields() {
		
		WebElement name = driver.findElement(By.name("name"));
		WebElement email = driver.findElement(By.name("email"));
		WebElement contact = driver.findElement(By.name("phone"));
		
		if(name.isDisplayed()&& email.isDisplayed()&&contact.isDisplayed())
			System.out.println("Form fields is displayed.");
		else
			System.out.println("Form fields is not displayed.");
	}
	
	public void verifyHomePageSubmitteBtn() {
		
		WebElement applyNow= driver.findElement(By.xpath("//button[text()='APPLY NOW']"));
		if(applyNow.isDisplayed())
			System.out.println("Apply Now Button is displayed.");
		else
			System.out.println("Apply Now Button is not displayed.");
	}
	
	public void verifyHomePageErrorMessage() {
		
       JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement btn = driver.findElement(By.xpath("//button[text()='APPLY NOW']"));
		btn.sendKeys(Keys.ENTER);
		js.executeScript("arguments[0].scrollIntoView();",btn );
		
		WebElement ErrorMessage = driver.findElement(By.xpath("//p[text()='something went wrong! please try again later']"));
		Assert.assertTrue(ErrorMessage.isDisplayed());
	}
}
