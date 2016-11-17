package com.glance.pageobjects.userlogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class LockScreenPage extends BasePage {

	public LockScreenPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
				
		
	}
	
	@FindBy(xpath="//a[@data-original-title='Lock']")
	WebElement linkLock;
	
	@FindBy(xpath="//form[@id='loginform']/h1")
	WebElement lblLockScreenPage;
	
	
	@FindBy(xpath="//img[@id='image']")
	WebElement ProfilePic;
	
	@FindBy(xpath="//input[@id='pwd']")
	WebElement txtPassword;
	
	@FindBy(id="valEncrpt")
	WebElement btnLogIn;
	
	@FindBy(xpath ="//button[@class='btn btn-warning']")
	WebElement btnLogInOK;
	
	@FindBy(xpath ="//button[@class='btn btn-default']")
	WebElement btnLogInClose;
	
	
	//Click on Lock button in left down icon
	public void ClickLockBtn(){
		
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
	
	
	//Click on the Profile Picture
	public void ClickProfilePicture(){		
		
		try{
			TestLog.log.info("Clicking on Profile Picture Icon");
			ProfilePic.click();
			TestLog.log.info("Clicked on Profile Picture Icon");
			
			}catch(Exception ex){
				TestLog.log.info("Could not Click the on ProfilePicture Icon. "+ex);
			
			}
		
		
		}
	
	//Entering Password
	public void EnterPassword(String Password){
		
		try{
			TestLog.log.info("Entering Password");
			txtPassword.sendKeys(Password);
			TestLog.log.info("Entered Password");
			
			}catch(Exception ex){
				TestLog.log.info("Could not Enter the Password. "+ex);
			}
		
		}
	
	//Click on Login Button
	public void ClickLogInBtn(){
		
		try{
			TestLog.log.info("Clicking on Log In Button");
			btnLogIn.click();
			TestLog.log.info("Clicked onLog In Button");
			
			}catch(Exception ex){
				TestLog.log.info("Could not Click on the LogIn Button. "+ex);
			
			}
		
		}
	
	//Click on LogInOk Button
		public void ClickLogInOKBtn(){
						
			try{
				TestLog.log.info("Clicking on LogIn Ok Button");
				btnLogInOK.click();
				TestLog.log.info("Clicked on LogIn Ok Button");
							
				}catch(Exception ex){
					TestLog.log.info("Could not Click on the LogIn Ok Button. "+ex);
							
				}
						
			}
		
	//Click on LogInClose Button
			public void ClickLogInCloseBtn(){
								
				try{
					TestLog.log.info("Clicking on LogIn Close Button");
					btnLogInClose.click();
					TestLog.log.info("Clicked on LogIn Close Button");
									
					}catch(Exception ex){
						TestLog.log.info("Could not Click on the LogIn Close Button. "+ex);
									
					}
								
				}


}
