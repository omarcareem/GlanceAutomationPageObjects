package com.glance.pageobjects.dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class CommonPageTopPane extends BasePage {

	public CommonPageTopPane(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	// user profile pic in the top pane
	@FindBy(xpath = "//div[1]/div/div[2]/div/nav/ul/li[1]/a/img")
	WebElement imgUserTop;

	// user name in the top pane
	@FindBy(xpath = "//li/a[@class='user-profile dropdown-toggle']")
	WebElement txtUserName;

	// drop down icon in the top pane
	@FindBy(xpath = "//div/nav/ul/li[1]/a[@class='user-profile dropdown-toggle']")
	WebElement drpDownIcon;

	@FindBy(xpath = "//div/nav/ul/li[1]/ul/li[1]/a")
	WebElement drpProfileOption;

	@FindBy(xpath = "//ul/li[1]/ul/li[2]/a/span")
	WebElement drpSettingsOption;

	@FindBy(xpath = "//div/nav/ul/li[1]/ul/li[3]/a")
	WebElement drpLogoutOption;

	@FindBy(xpath = "//i[@class='fa fa-bars']")
	WebElement btnPancake;

	@FindBy(id = "search")
	WebElement searchTextBox;

	@FindBy(id = "first-name")
	WebElement proflUpdateFirstName;

	@FindBy(xpath = "//div[3]/div[1]/strong")
	WebElement searchCatAcc;

	@FindBy(xpath = "//div[3]/div[2]/strong")
	WebElement searchCatEng;

	@FindBy(xpath = "//div[3]/div[3]/strong")
	WebElement searchCatPro;

	@FindBy(id = "frm_submit")
	WebElement btnSubmit;

	@FindBy(xpath = "//div[@class='autocomplete-no-suggestion']")
	WebElement errorSearch;

	@FindBy(xpath = "//div/div[2]/div/div/h1")
	WebElement errorAccessDenied;

	// click drop down

	public void clickDropDownIcon(String pageLinks) {
		try {
			TestLog.log.info("Selecting");
			Select dropdown = new Select(drpDownIcon);
			dropdown.selectByVisibleText(pageLinks);
			TestLog.log.info("Selected " + pageLinks);
		} catch (Exception ex) {
			TestLog.log.info("Could not select from drop down " + ex);
		}

	}

	public void clickDropDownIcon() {

		try {
			TestLog.log.info("Clicking Drop Down icon");
			drpDownIcon.click();

			TestLog.log.info("Clicked");

		} catch (Exception ex) {
			System.out.println("Clicking drop down icon failed");
		}

	}

	// Verify options
	public boolean verifyDropDownOptions() {
		boolean flag = false;

		String option1 = drpProfileOption.getText();
		String option2 = drpSettingsOption.getText();
		String option3 = drpLogoutOption.getText();

		List<WebElement> DropDownOptions = driver.findElements(By
				.xpath("//div[1]/div/div[2]/div/nav/ul/li[1]/ul"));

		for (WebElement suggestions : DropDownOptions) {
			System.out.println("The options under Drop down icon are:"
					+ option1 + option2 + option3);
			if (suggestions.getText().contains(option1)
					&& suggestions.getText().contains(option2)
					&& suggestions.getText().contains(option3)) {
				System.out.println("Drop down options are verfied");

				flag = true;
			}

		}

		return flag;
	}

	// click profile from the drop down menu
	
	  public void clickProfile() {
	 
	 try { TestLog.log.info("Clicking Profile"); drpProfileOption.click();
	  TestLog.log.info("Clicked");
	  
	  } catch (Exception ex) { System.out.println("Clicking Profile failed"); }
	  
	  }
	 

	// click settings from the drop down menu
	public void clickSettings() {

		try {
			TestLog.log.info("Clicking Settings");
			drpSettingsOption.click();
			TestLog.log.info("Clicked");

		} catch (Exception ex) {
			System.out.println("Clicking Settings failed");
		}

	}

	// click logout from the drop down menu
	public void clickLogout() {

		try {
			TestLog.log.info("Clicking Logout");
			drpLogoutOption.click();
			TestLog.log.info("Clicked");

		} catch (Exception ex) {
			System.out.println("Clicking Logout failed");
		}

	}

	// verfiy unexisting in search query

	// }*/

	public void searchTopPane(String searchUnexisting) {

		try {
			TestLog.log.info("searching");
			searchTextBox.clear();
			searchTextBox.sendKeys(searchUnexisting);

			TestLog.log.info("searching");

		} catch (Exception ex) {
			System.out.println("search failed");
		}

	}

	// search using two letters
	public void searchTwo(String searchTwo) {

		try {
			TestLog.log.info("searching");
			searchTextBox.clear();
			searchTextBox.sendKeys(searchTwo);

			TestLog.log.info("searching");

		} catch (Exception ex) {
			System.out.println("search failed");
		}

	}

	// selecting from suggestions from the search
	public void selectFromSuggestions(String searchTwo) {

		String textToSelect = "Scarlet Weeknight";
		searchTextBox.clear();
		searchTextBox.sendKeys(searchTwo);

		List<WebElement> optionsToSelect = driver.findElements(By
				.xpath("//div[@class='autocomplete-suggestion']"));

		for (WebElement suggestions : optionsToSelect) {
			System.out.println(suggestions);
			if (suggestions.getText().equals(textToSelect)) {
				System.out.println("Trying to select: " + textToSelect);
				suggestions.click();
				break;
			}
		}
	}

	// get the text in the search text box
	public boolean getSearchText(String searchText) {

		boolean flag = false;

		String valueOfSearch = searchTextBox.getAttribute("value");
		if (valueOfSearch.contains(searchText)) {
			System.out
					.println("The selected search text is:  " + valueOfSearch);
			flag = true;
		} else {
			System.out.println(" search text is not verified");
			flag = false;
		}
		return flag;

	}

	// verify error for empty input in search query
	public void searchEmpty(String searchEmpty) {

		try {
			TestLog.log.info("searching");
			searchTextBox.clear();
			searchTextBox.sendKeys(searchEmpty);

			TestLog.log.info("searching");

		} catch (Exception ex) {
			System.out.println("search failed");
		}

	}

	// verify the search selection for full text input
	public void searchfullTxt(String searchFullText) {

		try {
			TestLog.log.info("searching");
			searchTextBox.clear();
			searchTextBox.sendKeys(searchFullText);

			TestLog.log.info("searching");

		} catch (Exception ex) {
			System.out.println("search failed");
		}

	}

	// click go in the search text
	public void clickGo() {

		try {
			TestLog.log.info("clicking Go");
			btnSubmit.click();
			TestLog.log.info("clicked Go");

		} catch (Exception ex) {
			System.out.println("Cancel Add Group Failed");
		}

	}

	// click pancake icon
	public void clickPanCakeIcon() {

		try {
			TestLog.log.info("clicking Pancake");
			btnPancake.click();
			TestLog.log.info("clicked ");

		} catch (Exception ex) {
			System.out.println("Toggling of page failed");
		}

	}

	// verify the search suggestions for two letter input
	public boolean verifySearchSuggestions() {
		boolean flag = false;
		String searchSugCategory1 = searchCatAcc.getText();
		String searchSugCategory2 = searchCatEng.getText();
		String searchSugCategory3 = searchCatPro.getText();
		if (searchSugCategory1.contains("Accounts")
				&& searchSugCategory3.contains("Projects")
				|| searchSugCategory2.contains("Engagements")) {
			System.out
					.println("Search Suggestions are  Successfully is displayed category wise ");
			flag = true;
		}

		return flag;

	}

	// verify no results found error as search results
	public boolean verifyNoSearchReults() {
		boolean flag = false;
		String error = errorSearch.getText();
		if (error.contains("Sorry, no matching results")) {
			System.out.println("Correct error");
			flag = true;
		}

		return flag;

	}

	// verify the navigation to first default account details
	public boolean verifyFirstDefaultDet() {
		boolean flag = false;
		String error = searchTextBox.getText();
		if (error.contains("Scotia")) {
			System.out.println("Directed to first default details");
			flag = true;
		}

		return flag;

	}

	// verify access denied message
	public boolean verifyInvalidAccess() {
		boolean flag = false;
		String error1 = errorAccessDenied.getText();

		if (error1.contains("Access Denied!")) {
			System.out.println("Navigated to Access Denied Page");
			flag = true;
		}

		return flag;

	}

	// Verify UserName in the TopPane
	public boolean verifyUserName() throws InterruptedException {
		boolean flag = false;

		String userNameTop = txtUserName.getText();
		System.out.println("UserNameTop: " + userNameTop);

		drpDownIcon.click();
		Thread.sleep(2000);
		drpProfileOption.click();
		Thread.sleep(2000);

		String UserNameProfile = proflUpdateFirstName.getAttribute("value");
		System.out.println("UserNameProfile:" + UserNameProfile);
		if (userNameTop.contains(UserNameProfile)) {

			System.out.println("UserName Verified");

			flag = true;
		}

		return flag;

	}
}
