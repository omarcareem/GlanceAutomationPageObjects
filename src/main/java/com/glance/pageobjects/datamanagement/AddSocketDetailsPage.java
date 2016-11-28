package com.glance.pageobjects.datamanagement;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;



public class AddSocketDetailsPage extends BasePage{

	public AddSocketDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath="//div[@class='x_title']/h2")
	WebElement lblPageName;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement txtSocketName;
	
	@FindBy(xpath="//textarea[@id='url']")
	WebElement txtUrl;
	
	@FindBy(id="checkAuth")
	WebElement checkBox;
	
	@FindBy(id="user_name")
	WebElement txtUserName;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//textarea[@id='query']")
	WebElement txtQuery;
	
	@FindBy(xpath="//input[@id='destination']")
	WebElement txtTableName;
	
	@FindBy(xpath="//input[@class='btn btn-success']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//div[@class='content']")
	WebElement successMessage;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement btnOkay;
	
	@FindBy(xpath="//div/button[@class='btn btn-primary']")
	WebElement btnCancel;
	
/*	//identifying page name
	public String getPageName(){
		
		return lblPageName.getText();	
	}*/
	
	//add socket details page confirmation
    public boolean verifyNavigationToAddSocketPage(String expectedMessage) {
    	
        
   	boolean flag=false;
    	
        String actualMessage=lblPageName.getText();
               
        	
			if (actualMessage.contains(expectedMessage)) {
        		flag = true;
        		System.out.println("You are in the add socket details page");             
                
            } else {
            	System.out.println("You are not in the add socket details page");
                flag = false;                     
            }
        
        return flag;
    }
	
	//giving a socket name
	public void enterSocketName(String socketName){
			
		try	{
				
			TestLog.log.info("Giving a socket name");
			txtSocketName.sendKeys(socketName);
			TestLog.log.info("Gave a socket name");
		}
			
		catch(Exception ex){
			TestLog.log.info("Could not enter socket name. "+ ex);	
		}
	}
	
	//giving a url
	public void enterUrl(String url){
				
		try	{
					
			TestLog.log.info("Giving a url");
			txtUrl.sendKeys(url);
			TestLog.log.info("Gave a url");
		}
				
		catch(Exception ex){
			TestLog.log.info("Could not enter url. "+ ex);		
		}
	}
	
	//selecting check box
	public void selectCheckBox(){
					
		try	{
						
			TestLog.log.info("Selecting the check box");
			checkBox.click();
			TestLog.log.info("Selected the check box");
		}
					
		catch(Exception ex){
			TestLog.log.info("Could not select check box. "+ ex);			
		}
	}
	
	//give user name
	public void enterUserName(String userName1){
						
		try	{
							
			TestLog.log.info("Giving user name");
			txtUserName.sendKeys(userName1);
			TestLog.log.info("Gave user name");
		}
						
		catch(Exception ex){
			TestLog.log.info("Could not enter user name. "+ ex);			
		}
	}
	
	//give password
	public void enterPassword(String password1){
							
		try	{
								
			TestLog.log.info("Giving password");
			txtPassword.sendKeys(password1);
			TestLog.log.info("Gave password");
		}
							
		catch(Exception ex){
			TestLog.log.info("Could not enter password. "+ ex);				
		}
	}
	
	//give sql query
	public void enterQuery(String query){
								
			try	{
									
				TestLog.log.info("Giving query");
				txtQuery.sendKeys(query);
				TestLog.log.info("Gave query");
			}
								
			catch(Exception ex){
				TestLog.log.info("Could not enter query. "+ ex);				
			}
		}
	
	//give destination table name
	public void enterDestinationTableName(String tableName){
									
			try	{
									
				TestLog.log.info("Giving destination table name");
				txtTableName.sendKeys(tableName);
				TestLog.log.info("Gave destination table name");
			}
									
			catch(Exception ex){
				TestLog.log.info("Could not enter destination table name. "+ ex);					
			}
		}
	
	//clicking submit
	public void clickSubmit(){
			
		try {
				
			TestLog.log.info("Clicking the submit button");
			btnSubmit.click();
			TestLog.log.info("Clicked the submit button");
		}
			
		catch(Exception ex){
			TestLog.log.info("Could not click submit. "+ ex);	
		}
	}
	
	//Submit success
    public boolean verifySubmitSuccessMessage(String expectedMessage) {
    	
        
   	boolean flag=false;
    	
        String actualMessage=successMessage.getText();
               
        	
			if (actualMessage.contains(expectedMessage)) {
        		flag = true;
        		System.out.println("Added the socket successfully");             
                
            } else {
            	System.out.println("Socket didn't added successfully");
                flag = false;                     
            }
        
        return flag;
    }
	
	//success message accepted
	public void clickOkay(){
				
		btnOkay.click();
	}	
		
	//clicking cancel
	public void clickCancel(){
		
		try {
				
			TestLog.log.info("Clicking the cancel button");
			btnCancel.click();
			TestLog.log.info("Clicked the cancel button");
		}
			
		catch(Exception ex){
			TestLog.log.info("Could not click cancel. "+ ex);	
		}
	}
	
}
