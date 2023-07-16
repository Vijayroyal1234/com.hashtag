package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import Utilities.BaseClass;

public class UI_TestCases extends BaseClass{
	
	
	
	@BeforeMethod
	public void setup() {
		driver = intializeBrowserAndOpenApplicationURL("chrome");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test
	public void TC_UITestCase_001() {
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomepageLogoISDisplayedOrNot();
	}
	@Test
	public void TC_UITestCase_002() {
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePageTitle();
	}
	@Test
	public void TC_UITestCase_003() {
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePageHeading();
	}
	@Test
	public void TC_UITestCase_004() {
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePageSummaryAndResponsiblities();
	}
	@Test
	public void TC_UITestCase_005() {
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePageFormFields();
	}
	@Test
	public void TC_UITestCase_006() {
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePageSubmitteBtn();
	}
	@Test
	public void TC_UITestCase_007() {
		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePageErrorMessage();
	}
}
