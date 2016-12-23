package com.glance.pageobjects.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class CommonPageLeftPane extends BasePage {

	public CommonPageLeftPane(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	 @FindBy(xpath="//li/a[@class='user-profile dropdown-toggle']")
	    WebElement txtUserName;
	// image logo
	@FindBy(xpath = "//img[@class='logo']")
	WebElement imgLogo;

	// text logo
	@FindBy(xpath = "//span[text()='GLANCe']")
	WebElement txtLogo;

	// user profile picture in the left panel
	@FindBy(xpath = "//img[@class='img-circle profile_img']")
	WebElement imgUserLeft;

	// text welcome
	@FindBy(xpath = "//div[@class='profile_info']/span")
	WebElement txtWelcomeNote;

	// user name in the left panel
	@FindBy(xpath = "//div[@class='profile_info']/h2")
	WebElement txtUserNameLeft;
	
	

	// account name ******************
	@FindBy(xpath = "//a[contains(text(),'Account')]")
	WebElement txtAccount;

	
	//error no dashborad define
	@FindBy(xpath = "//p[contains(text(),'No dashboard elements defined for the selected account.')]")
	WebElement errorNodbDefineAcc;
			
	// Add new Account
	@FindBy(xpath = "//a[contains(text(),'Account')]/../ul/li[@class='btn-xs btn-primary']/a")
	WebElement linkAccountAddNew;

	// Add new Account
	@FindBy(xpath = "//div/ul/li[1]/ul/li[6]/a")
	WebElement txtAccountAddNew;

	// engagement name ****************
	@FindBy(xpath = " //a[contains(text(),'Engagement')]")
	WebElement txtEngagement;
	
	//error msg for Project
		//@FindBy(xpath = "//h1[contains(text(),'Access Denied!')]")
		//WebElement errorAccessDProj;

	// Add new Engagement
	@FindBy(xpath = "//div/ul/li[2]/ul/li[8]/a")
	WebElement txtEngagementAddNew;

	// project name ******************
	@FindBy(xpath = "//a[contains(text(),'Project')]")
	WebElement txtProject;

	// Add new Project
	@FindBy(xpath = "//div/ul/li[3]/ul/li/a")
	WebElement txtProjectAddNew;

	// Individual name *************
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

	@FindBy(xpath = "//a[contains(text(),'Engagement')]/../ul/li[@class='btn-xs btn-primary']/a")
	WebElement linkEngagementAddNew;
	
	@FindBy(xpath="//a[@class='site_title']/span")
	WebElement linkLeftGlanceTitle;
	
	  @FindBy(xpath="//div[1]/div/div[2]/div/nav/ul/li[1]/a/img")
	    WebElement imgUserTop;

	// clicking add new account
	public void clickOnAddNewAccountLink() {

		// WebElement element = driver.findElement(By.id("gbqfd"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", linkAccountAddNew);

	}

	// clicking elements under the Account drop down
	By linkAccountList = By.xpath("//a[contains(text(),'Account')]/../ul/li/a");

	public ArrayList<String> getAccountNameList() {

		ArrayList listOfAcoountNames = new ArrayList();
		List<WebElement> linkAccountNameList = driver.findElements(linkAccountList);

		for (WebElement accountNames : linkAccountNameList) {

			listOfAcoountNames.add(accountNames.getText());
		}
		return listOfAcoountNames;
	}

	public void clickOnAccountName(String accountName) {

		List<WebElement> linkAccountNameList = driver.findElements(linkAccountList);
		int noOfAccounts = driver.findElements(linkAccountList).size();
		System.out.println(noOfAccounts);

		for (int i = 0; i < noOfAccounts; i++) {
			String returnedAccountName = linkAccountNameList.get(i).getText();
			System.out.println(returnedAccountName);
			if (returnedAccountName.contains(accountName)) {

				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(linkAccountNameList.get(i)));
				linkAccountNameList.get(i).click();
				System.out.println("click on account name");
				break;
			}

		}

		

	}

	// click on engagement *******************************************
	public void clickEngagement() {

		try {
			TestLog.log.info("Clicking engagement icon");
			txtEngagement.click();
			TestLog.log.info("Clicked");

		} catch (Exception ex) {
			System.out.println("click on engagement failed!");
		}

	}

	@FindBy(xpath = "//a[contains(text(),'Individual')]/../ul/li[@class='btn-xs btn-primary']/a")
	WebElement linkIndividualAddNew;

	public void clickOnAddNewIndividualLink() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", linkIndividualAddNew);

	}
	// click on account *******************************************
	public void clickAccount() {

		try {
			TestLog.log.info("Clicking account icon");
			txtAccount.click();
			TestLog.log.info("Clicked");
			System.out.println("click is done");
		} catch (Exception ex) {
			System.out.println("click on account failed!");
		}

	}
	
	// click on project *******************************************
		public void clickProject() {

			try {
				TestLog.log.info("Clicking account icon");
				txtProject.click();
				TestLog.log.info("Clicked");

			} catch (Exception ex) {
				System.out.println("click on account failed!");
			}

		}
		
		// click on individual *******************************************
				public void clickIndividual() {

					try {
						TestLog.log.info("Clicking account icon");
						txtIndividual.click();
						TestLog.log.info("Clicked");

					} catch (Exception ex) {
						System.out.println("click on account failed!");
					}

				}
	
	

	// clicking elements under the Engagement drop down
	By linkEngagementList = By.xpath("//a[contains(text(),'Engagement')]/../ul/li");

	public ArrayList<String> getEngagementNameList() {

		ArrayList listOfEngagementNames = new ArrayList();
		List<WebElement> linkEngagementNameList = driver.findElements(linkEngagementList);
		
		for (WebElement engagementNames : linkEngagementNameList) {

			listOfEngagementNames.add(engagementNames.getText());
		//	ArrayList EngamentList = listOfEngagementNames;
		//	System.out.println(EngamentList);
			
		}
		return listOfEngagementNames;
		
	}
	
	

public void clickOnEngagementName(String engagementName) {

		
		List<WebElement> linkEngagementNameList = driver.findElements(linkEngagementList);
			
			int noOfEngagements = driver.findElements(linkEngagementList).size();
		System.out.println(noOfEngagements);
           
		   for(int i=0;i<noOfEngagements;i++){
			String returnedEngagementName=linkEngagementNameList.get(i).getText(); 
			System.out.println(returnedEngagementName);
			if(returnedEngagementName.contains(engagementName)){
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(linkEngagementNameList.get(i)));
				linkEngagementNameList.get(i).click();
				break;
			}
			
		}
		
	
			
		
	}

	// method to select add new ************************
	public void clickOnAddNewEngagementLink() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", linkEngagementAddNew);

	}

	@FindBy(xpath = "//a[contains(text(),'Project')]/../ul/li[@class='btn-xs btn-primary']/a")
	WebElement linkProjectAddNew;

	public void clickOnAddNewProjectLink() {

		// WebElement element = driver.findElement(By.id("gbqfd"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", linkProjectAddNew);

	}

	// verify added Project
	public boolean verifyAddedProject(String projectName) {
		txtAccount.click();
		boolean flag = false;
		String bodyText = driver.getPageSource();
		if (bodyText.contains(projectName)) {
			System.out.println("Project is added" + projectName);
			flag = true;
		} else {
			System.out.println("Project is not added" + projectName);
		}
		return flag;
	}

	public void selectAddNewProject() {
		txtProject.click();
		txtProjectAddNew.click();

	}

	// clicking elements under the Project drop down
	By linkProjectList = By.xpath("//a[contains(text(),'Project')]/../ul/li");

	public ArrayList<String> getProjectNameList() {

		ArrayList listOfProjectNames = new ArrayList();
		List<WebElement> linkProjectNameList = driver.findElements(linkProjectList);

		for (WebElement projectNames : linkProjectNameList) {

			listOfProjectNames.add(projectNames.getText());
		}
		return listOfProjectNames;
	}

public void clickOnProjectName(String projectName) {

		
		List<WebElement> linkProjectNameList = driver.findElements(linkProjectList);
			
			int noOfProjects = driver.findElements(linkProjectList).size();
		System.out.println(noOfProjects);
           
		   for(int i=0;i<noOfProjects;i++){
			String returnedProjectName=linkProjectNameList.get(i).getText(); 
			System.out.println(returnedProjectName);
			if(returnedProjectName.contains(projectName)){
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(linkProjectNameList.get(i)));
				linkProjectNameList.get(i).click();
				break;
			}
			
		}
		
	}

	// clicking elements under the Individual drop down
	By linkIndividualList = By.xpath("//a[contains(text(),'Individual')]/../ul/li");

	public ArrayList<String> getIndividualNameList() {

		ArrayList listOfIndividualNames = new ArrayList();
		List<WebElement> linkIndividualNameList = driver.findElements(linkIndividualList);

		for (WebElement individualNames : linkIndividualNameList) {

			listOfIndividualNames.add(individualNames.getText());
		}
		return listOfIndividualNames;
	}

	public void clickOnIndividualName(String individualName) {

		List<WebElement> linkIndividualNameList = driver.findElements(linkIndividualList);

		int noOfIndividuals = driver.findElements(linkIndividualList).size();
		System.out.println(noOfIndividuals);
		
		 for(int i=0;i<noOfIndividuals;i++){
			String returnedIndividualName=linkIndividualNameList.get(i).getText(); 
			System.out.println(returnedIndividualName);
			if(returnedIndividualName.contains(individualName)){
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(linkIndividualNameList.get(i)));
				linkIndividualNameList.get(i).click();
				break;
		
		    }
		}
		
	}

	// clicking on glance icon
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
	
	   public boolean verifyUserNameLeft() throws InterruptedException {
		    boolean flag= false;
		    
		   
		    
		    String userNameTop = txtUserName.getText();
		    System.out.println("UserNameTop: "+userNameTop);
		    
		    String userNameLeft = txtUserNameLeft.getText();
		    System.out.println("UserNameLeft: "+userNameLeft);
		    
		    if(userNameLeft.contains(userNameTop)) {
		
		    	System.out.println("UserNameLeft Verified");
		    	
		    	flag = true;
		    }
		    
		    return flag;
		    
		}
	   
	   //Verify UserImage in the LeftPanel
	    public boolean verifyUserImageLeft() throws InterruptedException {
		    boolean flag= false;
		    		  	  
		    String userImageTop = imgUserTop.getAttribute("alt");
		    System.out.println("UserImageTopName: "+userImageTop);
		    
		    String userImageLeft =imgUserLeft.getAttribute("alt");
		    System.out.println("UserIamgeLeft:"+userImageLeft);
		    if(userImageTop.contains(userImageLeft)) {
		
		    	System.out.println("UserImage in the Left Panel Verified");
		    	
		    	flag = true;
		    }
		    
		    return flag;
		    
		}

	// get the user name
	public String getLeftPanelUserName() {

		return txtUserNameLeft.getText();

	}

	// naviagate to settings page
	public void clickSettings() {

		try {
			TestLog.log.info("Navigating to settings page");
			settingsIcon.click();
			TestLog.log.info("Navigated");

		} catch (Exception ex) {
			System.out.println("Navigation failed");
		}

	}

	// navigate to full screen page
	public void clickFullScreen() {

		try {
			TestLog.log.info("switching to full screen");
			fullscreenIcon.click();
			TestLog.log.info("switched to full screen");

		} catch (Exception ex) {
			System.out.println("full screen failed");
		}

	}

	// click screen lock
	public void clickScreenLock() {

		try {
			TestLog.log.info("locking screen");
			lockScreenIcon.click();
			TestLog.log.info("locked");

		} catch (Exception ex) {
			System.out.println("screen lock failed");
		}

	}

	// click logout
	public void clickLogout() {

		try {
			TestLog.log.info("Logging out from the system");
			LogoutIcon.click();
			TestLog.log.info("Logged out");

		} catch (Exception ex) {
			System.out.println("Logout failed");
		}

	}


	
	public void clickOnAccount(){
		try {
			TestLog.log.info("Clicking on account");
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(txtAccount));
			txtAccount.click();
			
			TestLog.log.info("Clicked on Account");

		} catch (Exception ex) {
			System.out.println("Could not click on Account link. Due to: "+ex);
		}
		
		
		
	}
	
	
	
	public void clickOnIndividual(){
		try {
			TestLog.log.info("Clicking on individual");
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(txtIndividual));
			txtIndividual.click();
			
			TestLog.log.info("Clicked on individual");

		} catch (Exception ex) {
			System.out.println("Could not click on individual link. Due to: "+ex);
		}
		
		
		
	}
	
	public void clickOnEngagement(){
		try {
			TestLog.log.info("Clicking on engagement");
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(txtEngagement));
			txtEngagement.click();
			
			TestLog.log.info("Clicked on Engagement");

		} catch (Exception ex) {
			System.out.println("Could not click on Engagement link. Due to: "+ex);
		}
		
		
		
	}
	
	public void clickOnProject(){
		try {
			TestLog.log.info("Clicking on project");
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(txtProject));
			txtProject.click();
			
			TestLog.log.info("Clicked on project");

		} catch (Exception ex) {
			System.out.println("Could not click on project link. Due to: "+ex);
		}
		
		
		
	}
	 
	/*public boolean verifyAccessDenied(){
	WebElement errorAccessDProj;
	errorAccessDProj=driver.findElement(By.xpath("//h1[contains(text(),'Access Denied!')]"));

	
	boolean flag = false;
	
	
	String text = errorAccessDProj.getText();
	if (text.contains("Access Denied")){
		flag=true;
	
	}
	
	return flag;
}*/
	//verify no dashboard define error
	public boolean verifyNoDashboardDefineAcc() {
		WebElement errorNodbDefineAcc;
		errorNodbDefineAcc=driver.findElement(By.xpath("//p[contains(text(),'No dashboard elements defined for the selected account.')]"));
		
		//button[@class='btn btn-primary btn-lg new_element']
		WebElement btnDefineNow;
		btnDefineNow=driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg new_element']"));
	    boolean flag = false;
		
		String text1 = errorNodbDefineAcc.getText();
		String text2 =btnDefineNow.getText();
		if(text1.contains("No dashboard elements defined") && text2.contains("Define Now")){
			flag= true;
		}
		
		return flag;
	}
	
	//Verify the Pancake icon
		 public boolean verifyToggling() {
			    boolean flag= false;
			    //String glanceLink = txtLogo.getText();
			  
			    if(!linkLeftGlanceTitle.isDisplayed()) {
			    	System.out.println("Toggling verified");
			    	flag = true;
			    }
			    
			    return flag;
			    
			}
	

	// verify added
	public boolean verifyAdded(String accountName) {

		txtAccount.click();
		boolean flag = false;

		String bodyText = driver.getPageSource();

		if (bodyText.contains(accountName)) {

			System.out.println("Account is added");
			flag = true;

		} else {

			System.out.println("Account is not added");

		}
		return flag;

	}
	
}
