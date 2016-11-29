package com.glance.pageobjects.userlogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class LockScreenPage extends BasePage {

	public LockScreenPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
				
		
	}
	
	@FindBy(xpath="//a[@data-original-title='Lock']")
	WebElement linkLock;
	
	@FindBy(xpath="//form[@id='loginform']/h1")
	WebElement lblLockScreenPage;
	
	
	@FindBy(xpath="//img[@id='image']")
	WebElement profilePic;
	
	@FindBy(xpath="//input[@id='pwd']")
	WebElement txtPassword;
	
	@FindBy(id="valEncrpt")
	WebElement btnLogIn;
	
	@FindBy(xpath ="//button[@class='btn btn-warning']")
	WebElement btnLogInOK;
	
	@FindBy(xpath ="//button[@class='btn btn-default']")
	WebElement btnLogInClose;
	
	
	//Click on Lock button in left down icon
	public void clickLockBtn(){
		
		try{
			TestLog.log.info("Clicking on Lock Icon");
			linkLock.click();
			TestLog.log.info("Clicked on Lock Icon");
			
			}catch(Exception ex){
				TestLog.log.info("Could not Click on the Lock button. "+ex);
			
			}
		
		}
	

//Check Lock Screen Page Name
		public String getLockScreenPageTitle() {
			
			return lblLockScreenPage.getText();

		}	
		
	//verify LockScreen Page name
		public boolean verifyNavigationToLockScreen(String expectedMessage){
			boolean flag = false;
			String actualMessage=lblLockScreenPage.getText();
			if (actualMessage.contains(expectedMessage)) {
				flag = true;
				System.out.println("You are in the Lock Screen page");
				}
			else {
				System.out.println("You are not in the Lock Screen page");
				flag = false;
				}
			
			return flag;
			
			
		}
	
	
	//Click on the Profile Picture
	public void clickProfilePicture(){		
		
		try{
			TestLog.log.info("Clicking on Profile Picture Icon");
			profilePic.click();
			TestLog.log.info("Clicked on Profile Picture Icon");
			
			}catch(Exception ex){
				TestLog.log.info("Could not Click the on ProfilePicture Icon. "+ex);
			
			}
		
		
		}
	
	//Entering Password
	public void enterPassword(String password){
		
		try{
			TestLog.log.info("Entering Password");
			txtPassword.sendKeys(password);
			TestLog.log.info("Entered Password");
			
			}catch(Exception ex){
				TestLog.log.info("Could not Enter the Password. "+ex);
			}
		
		}
	
	//Click on Login Button
	public void clickLogInBtn(){
		
		try{
			TestLog.log.info("Clicking on Log In Button");
			btnLogIn.click();
			TestLog.log.info("Clicked onLog In Button");
			
			}catch(Exception ex){
				TestLog.log.info("Could not Click on the LogIn Button. "+ex);
			
			}
		
		}
	
	//Click on LogInOk Button
		public void clickLogInOKBtn(){
						
			try{
				TestLog.log.info("Clicking on LogIn Ok Button");
				btnLogInOK.click();
				TestLog.log.info("Clicked on LogIn Ok Button");
							
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the LogIn Ok Button. "+ex);
							
				}
						
			}
		
	//Click on LogInClose Button
			public void clickLogInCloseBtn(){
								
				try{
					TestLog.log.info("Clicking on LogIn Close Button");
					btnLogInClose.click();
					TestLog.log.info("Clicked on LogIn Close Button");
									
					}catch(Exception ex){
						TestLog.log.info("Could not Click on the LogIn Close Button. "+ex);
									
					}
								
				}


}
