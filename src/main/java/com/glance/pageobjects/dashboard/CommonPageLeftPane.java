package com.glance.pageobjects.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class CommonPageLeftPane extends BasePage {

	public CommonPageLeftPane(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}

	//image logo
	@FindBy(xpath = "//img[@class='logo']")
	WebElement imgLogo;
    
	//text logo
	@FindBy(xpath = "//span[text()='GLANCe']")
	WebElement txtLogo;

	//user profile picture in the left panel
	@FindBy(xpath = "//img[@class='img-circle profile_img']")
	WebElement imgUserLeft;

	//text welcome 
	@FindBy(xpath = "//div[@class='profile_info']/span")
	WebElement txtWelcomeNote;

	//user name in the left panel
	@FindBy(xpath = "//div[@class='profile_info']/h2")
	WebElement txtUserNameLeft;

	// account name
	@FindBy(xpath = "//a[contains(text(),'Account')]")
	WebElement txtAccount;

	// Add new Account
	@FindBy(xpath = "//div/ul/li[1]/ul/li[6]/a")
	WebElement txtAccountAddNew;

	// engagement name
	@FindBy(xpath = "//a[contains(text(),'Engagement')]")
	WebElement txtEngagement;

	// Add new Engagement
	@FindBy(xpath = "//div/ul/li[2]/ul/li[8]/a")
	WebElement txtEngagementAddNew;

	// project name
	@FindBy(xpath = "//a[contains(text(),'Project')]")
	WebElement txtProject;

	// Add new Project
	@FindBy(xpath = "//div/ul/li[3]/ul/li/a")
	WebElement txtProjectAddNew;

	// Individual name
	@FindBy(xpath = "//a[contains(text(),'Individual')]")
	WebElement txtIndividual;

	// bottomleft corner settings icon
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-cog']")
	WebElement settingsIcon;

	// bottomleft corner full screen icon
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-fullscreen']")
	WebElement fullscreenIcon;

	// bottomleft corner lock screen icon
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-eye-close']")
	WebElement lockScreenIcon;

	// bottomleft corner logout icon
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-off']")
	WebElement LogoutIcon;
	
	@FindBy(xpath="//a[contains(text(),'Engagement')]/../ul/li[@class='btn-xs btn-primary']/a")
	WebElement linkEngagementAddNew;

	//clicking elements under the Account drop down
	By linkAccountList = By.xpath("//a[contains(text(),'Account')]/../ul/li/a");
	
	
	public ArrayList<String> getAccountNameList() {

		ArrayList listOfAcoountNames = new ArrayList();
		List<WebElement> linkAccountNameList = driver
				.findElements(linkAccountList);

		for (WebElement accountNames : linkAccountNameList) {

			listOfAcoountNames.add(accountNames.getText());
		}
		return listOfAcoountNames;
	}
	
	public void clickOnAccountName(String accountNameValue) {

		
		List<WebElement> linkAccountNameList = driver.findElements(linkAccountList);

		for (WebElement accountNameInList : linkAccountNameList) {
			
			String returnedAccountName=accountNameInList.getText();
			if(returnedAccountName.contains(accountNameValue)){
				accountNameInList.click();
				System.out.println("given Account name is clicked");
				break;
			}
		}
		
	}
	
	
	//click on engagement ******************************************* 
	public void clickEngagement() {

		try {
			TestLog.log.info("Clicking engagement icon");
			txtEngagement.click();
			TestLog.log.info("Clicked");

		} catch (Exception ex) {
			System.out.println("click on engagement failed!");
		}

	}
	
	//click on account *******************************************
		public void clickAccount() {

			try {
				TestLog.log.info("Clicking account icon");
				txtAccount.click();
				TestLog.log.info("Clicked");

			} catch (Exception ex) {
				System.out.println("click on account failed!");
			}

		}
	
	//clicking elements under the Engagement drop down
		By linkEngagementList = By.xpath("//a[contains(text(),'Engagement')]/../ul/li");

	public ArrayList<String> getEngagementNameList() {

		ArrayList listOfEngagementNames = new ArrayList();
		List<WebElement> linkEngagementNameList = driver.findElements(linkEngagementList);

		for (WebElement engagementNames : linkEngagementNameList) {

			listOfEngagementNames.add(engagementNames.getText());
		}
		return listOfEngagementNames;
	}
	
	public void clickOnEngagementName(String engagementName) {

		
		List<WebElement> linkEngagementNameList = driver.findElements(linkEngagementList);

		for (WebElement  engagementNames : linkEngagementNameList) {
		String returnedEngagementName=engagementNames.getText();
			if(returnedEngagementName.contains(engagementName)){
				engagementNames.click();
	 break;
			}
		}
		
	}
	
	//click on engagement name ***************************
public List<String> clickOnEngagementName2(String engagementName) {

		List<String> currentValue = new ArrayList<>();
		
		By linkEngagementList = By.xpath("//a[contains(text(),'Engagement')]/../ul");
		WebElement select = driver.findElement(linkEngagementList);
		List<WebElement> matches = select.findElements(By.tagName("li"));
		for (WebElement  match : matches) {
			currentValue.add(match.getText());
			//String value = currentValue.add(match.getText());
			if(currentValue.contains(engagementName)){
				match.click();
				
			}
			else{
				System.out.println("Error selecting engagement");
				break;
			}
			}
		
		return currentValue;
		
	}


//method to select add new ************************
	public void clickOnAddNewEngagementLink(){
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", linkEngagementAddNew);
		
	}

	
	
	
	//clicking elements under the Project drop down
		By linkProjectList = By.xpath("//a[contains(text(),'Project')]/../ul/li");

	public ArrayList<String> getProjectNameList() {

		ArrayList listOfProjectNames = new ArrayList();
		List<WebElement> linkProjectNameList = driver.findElements(linkProjectList);

		for (WebElement projectNames :  linkProjectNameList) {

			listOfProjectNames.add(projectNames .getText());
		}
		return listOfProjectNames;
	}
	
	public void clickOnProjectName(String projectName) {

		
		List<WebElement> linkProjectNameList = driver.findElements(linkProjectList);

		for (WebElement  projectNames :  linkProjectNameList) {
		String returnedProjectName=projectNames .getText();
			if(returnedProjectName==projectName){
				projectNames.click();
	 break;
			}
		}
		
	}
	
	//clicking elements under the Individual drop down
	By linkIndividualList = By.xpath("//a[contains(text(),'Individual')]/../ul/li");

	public ArrayList<String> getIndividualNameList() {

		ArrayList listOfIndividualNames = new ArrayList();
		List<WebElement> linkIndividualNameList = driver.findElements(linkIndividualList);

		for (WebElement individualNames :  linkIndividualNameList) {

			listOfIndividualNames.add(individualNames .getText());
		}
		return listOfIndividualNames;
	}
	
	
	public void clickOnIndividualName(String individualName) {

		List<WebElement> linkIndividualNameList = driver.findElements(linkIndividualList);

		for (WebElement individualNames :  linkIndividualNameList) {
            String returnedIndividualName=individualNames.getText();
		    if(returnedIndividualName==individualName){
		    	individualNames.click();
		    	
		    	break;
		    }
		}
		
	}
		
	//clicking on glance icon
	public void clickGlanceIcon() {

		try {
			TestLog.log.info("Clicking glance icon");
			txtLogo.click();
			TestLog.log.info("Clicked");

		} catch (Exception ex) {
			System.out.println("Navigation of default page failed!");
		}

	}

	// get the WelcomeNote
	public String getWelcomeNote() {

		return txtWelcomeNote.getText();

	}

	// get the user name
	public String getLeftPanelUserName() {

		return txtUserNameLeft.getText();

	}

	
	
  //naviagate to settings page
	public void clickSettings() {

		try {
			TestLog.log.info("Navigating to settings page");
			settingsIcon.click();
			TestLog.log.info("Navigated");

		} catch (Exception ex) {
			System.out.println("Navigation failed");
		}

	}

	//navigate to full screen page
	public void clickFullScreen() {

		try {
			TestLog.log.info("switching to full screen");
			fullscreenIcon.click();
			TestLog.log.info("switched to full screen");

		} catch (Exception ex) {
			System.out.println("full screen failed");
		}

	}

	//click screen lock
	public void clickScreenLock() {

		try {
			TestLog.log.info("locking screen");
			lockScreenIcon.click();
			TestLog.log.info("locked");

		} catch (Exception ex) {
			System.out.println("screen lock failed");
		}

	}

	//click logout
	public void clickLogout() {

		try {
			TestLog.log.info("Logging out from the system");
			LogoutIcon.click();
			TestLog.log.info("Logged out");

		} catch (Exception ex) {
			System.out.println("Logout failed");
		}

	}

}
