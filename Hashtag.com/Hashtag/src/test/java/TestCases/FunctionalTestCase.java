package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.FunctionalFieldsPage;
import Utilities.BaseClass;

public class FunctionalTestCase extends BaseClass{
	
	
	@BeforeMethod
	public void setup() {
		intializeBrowserAndOpenApplicationURL("chrome");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void TC_FunctionalTestCase_001() {
		FunctionalFieldsPage fieldsPage = new FunctionalFieldsPage(driver);
		fieldsPage.verifyFunctionalFieldWithValidCredentials();
	}
	@Test(priority = 2)
	public void TC_FunctionalTestCase_002() {
		FunctionalFieldsPage fieldsPage = new FunctionalFieldsPage(driver);
		fieldsPage.verifyFunctionalFieldWithInvalidCredentials();
	}
	@Test(priority = 3)
	public void TC_FunctionalTestCase_003() {
		FunctionalFieldsPage fieldsPage = new FunctionalFieldsPage(driver);
		fieldsPage.verifyFunctionalFieldWithoutCredentials();
	}

}
