package com.glance.pageobjects.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.Index;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class AddEngagementPage extends BasePage {

	public AddEngagementPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// variable declaration with xpath for identifying page name
	@FindBy(xpath = "//div[@class='x_title']/h2")
	WebElement lblPageName;

	// variable declaration with xpath for Engagement txt boxes, lbls and drop
	// downs
	@FindBy(xpath = "//input[@id='engagement_name']")
	WebElement txtEngagementName;

	@FindBy(xpath = "//span[@class='help-block form-error']")
	WebElement lblEngagementName;

	@FindBy(xpath = "//select[@id='account_id']")
	WebElement drpdwnAccount;

	@FindBy(xpath = "//select[@id='delivery_method_id']")
	WebElement drpdwnDeliveryMethod;

	@FindBy(xpath = "//select[@id='contract_type_id']")
	WebElement drpdwnContractType;

	@FindBy(xpath = "//input[@id='years']")
	WebElement txtYears;

	@FindBy(xpath = "//span[@class='help-block form-error']")
	WebElement lblYears;

	@FindBy(xpath = "//input[@type='radio']")
	String rdbtnManage;

	@FindBy(xpath = "//input[@id='managed']")
	String rdbtnManageYes;

	@FindBy(xpath = "//input[@id='not_managed']")
	WebElement rdbtnManageNo;

	@FindBy(xpath = "//button[@id='cancel']")
	WebElement btnCancel;

	@FindBy(xpath = "//button[@id='submit_engagement']")
	WebElement btnSubmit;

	@FindBy(xpath = "//div[@class='jconfirm-box']/div[@class='title-c']/span[@class='title']")
	WebElement msgSubmit;

	@FindBy(xpath = "//button[1][@class='btn btn-default']")
	WebElement btnAddNewEntry;

	@FindBy(xpath = "//button[2][@class='btn btn-default']")
	WebElement btnGoToDashBoard;

	@FindBy(xpath = "//div[@class='row tile_count']/div[@class='jumbotron']/h1")
	WebElement lblDashboardPageName;

	// method for identifying the page title
	public boolean getPageName(String lblExpectedTitle) {
		boolean flag = false;

		String pageName = lblPageName.getText();
		if (pageName.contains(lblExpectedTitle)) {
			System.out.println("Navigated to engagement add operation page " + pageName);
			flag = true;
		} else {
			System.out.println("Not Navigated to engagement add operation page");
			flag = false;
		}
		return flag;
	}

	// methods for the text fields and drop downs
	public void enterEngagementName(String valueEngagementName) {
		try {
			TestLog.log.info("enter engagement name");
			txtEngagementName.sendKeys(valueEngagementName);
			TestLog.log.info("Engagement name will appear as AVA");

		} catch (Exception ex) {
			TestLog.log.info("Error entering engagement name" + ex);
		}
	}

	// method for selecting an account
	public void selectAccount(String lblAccountValue) {
		try {
			TestLog.log.info("select an account from the drop down");
			Select value = new Select(drpdwnAccount);
			value.selectByVisibleText(lblAccountValue);

			TestLog.log.info("selected value will appear in account field");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting account name" + ex);
		}
	}

	// method for selecting a Delivery method
	public void selectDeliveryMethod(String lblDeliveryMethodValue) {
		try {
			TestLog.log.info("select a delivery method from the drop down");
			Select value = new Select(drpdwnDeliveryMethod);
			value.selectByVisibleText(lblDeliveryMethodValue);

			TestLog.log.info("selected value will appear in delivery method field");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting delivery method" + ex);
		}
	}

	// method for selecting a ContractType
	public void selectContractType(String lblContractTypeValue) {
		try {
			TestLog.log.info("select a contract type from the drop down");
			Select value = new Select(drpdwnContractType);
			value.selectByVisibleText(lblContractTypeValue);

			TestLog.log.info("selected value will appear in contract type field");
		} catch (Exception ex) {
			TestLog.log.info("Error selecting contract type" + ex);
		}
	}

	// method for enter Year
	public void enterYears(String txtYearValue) {
		try {
			TestLog.log.info("enter years");
			txtYears.sendKeys(txtYearValue);
			TestLog.log.info("no of years will appear as AVA");

		} catch (Exception ex) {
			TestLog.log.info("Error entering years" + ex);
		}
	}

	public void selectRadioButton4() {

		driver.findElement(By.xpath("//input[@id='managed']")).click();

	}

	// methods for cancel and submit
	public void clickCancel() {
		try {
			TestLog.log.info("select cancel");
			btnCancel.click();
			TestLog.log.info("add new engagement will cancel");

		} catch (Exception ex) {
			TestLog.log.info("Error clicking cancel" + ex);
		}
	}

	public void clickSubmit() {
		try {
			TestLog.log.info("select submit");
			btnSubmit.click();
			TestLog.log.info("add new engagement will submit");

		} catch (Exception ex) {
			TestLog.log.info("Error clicking submit" + ex);
		}
	}

	// method for verifying submit
	public boolean verifySubmit(String lblExpectedTitle) {

		boolean flag = false;

		String popupMessageName = msgSubmit.getText();
		if (popupMessageName.contains(lblExpectedTitle)) {
			System.out.println("Navigated to done adding new entry message " + popupMessageName);
			flag = true;
		} else {
			System.out.println("Not Navigated to done adding new entry message");
			flag = false;
		}
		return flag;

	}

	public void selectAddNewEntry() {
		try {
			TestLog.log.info("select add new entry");
			btnAddNewEntry.click();
			TestLog.log.info("new entry will submit");

		} catch (Exception ex) {
			TestLog.log.info("Error selecting add new entry" + ex);
		}

	}

	public void selectGoToDashboard() {
		try {
			TestLog.log.info("select go to dashboard");
			btnGoToDashBoard.click();
			TestLog.log.info("navigate to dashboard page");

		} catch (Exception ex) {
			TestLog.log.info("Error selecting got to dashboard" + ex);
		}
	}

	// method to verify the new entry added to the left pane
	By dropDownShowEntryValue = By.xpath("//div[@id='sidebar-menu']/div/ul/li[@class='nv active']/ul/li");

	public boolean verifyValueEngagement(String getvalue) {
		List<String> dropDownTexts = new ArrayList<>();

		List<WebElement> showDropdownList = driver.findElements(dropDownShowEntryValue);

		for (int i = 0; i < showDropdownList.size(); i++) {

			dropDownTexts.add(showDropdownList.get(i).getText());

			if (getvalue.equals(dropDownTexts)) {
				
				System.out.println("Engagement is in the list " + dropDownTexts);

			} else {
				System.out.println("Engagement is not in the list");
				break;
			}
		}
		return false;
	}

	// method to verify the new account entry added to the left pane
	By dropDownShowEntryValueAccount2 = By.xpath("//div[@id='sidebar-menu']/div/ul/li[@class='nv active']/ul/li");

	public void verifyValueAccount2() {

	}

	By dropDownShowEntryValueAccount3 = By.xpath("//div[@id='sidebar-menu']/div/ul/li[@class='nv active']/ul/li/a[contains(text(),'Scotia')]");

	public void verifyValueAccount3() {
		driver.findElement(dropDownShowEntryValueAccount3).click();

	}

	// method for identifying the page relevant to left pane
	public boolean getDashbordPageName(String lblExpectedTitle) {
		boolean flag = false;

		String pageName = lblDashboardPageName.getText();
		if (pageName.contains(lblExpectedTitle)) {
			System.out.println("Navigated to relevany dashboard " + pageName);
			flag = true;
		} else {
			System.out.println("Not Navigated to relevant dashboard");
			flag = false;
		}
		return flag;
	}

}
