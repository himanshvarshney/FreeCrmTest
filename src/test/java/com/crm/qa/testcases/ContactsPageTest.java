package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("Test Test");
	}
	@Test(priority = 3)
	public void selectMutltipleContactsTes() {
		contactsPage.selectContactsByName("Test Test");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

