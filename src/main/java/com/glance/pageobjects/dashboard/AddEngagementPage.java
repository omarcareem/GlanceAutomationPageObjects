package com.glance.pageobjects.dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	//variable declaration with xpath for identifying page name
	@FindBy(xpath="//div[@class='x_title']/h2")
	WebElement lblPageName;
	
	//variable declaration with xpath for Engagement txt boxes, lbls and drop downs
	@FindBy(xpath="//input[@id='engagement_name']")
	WebElement txtEngagementName;
	
	@FindBy(xpath="//span[@class='help-block form-error']")
	WebElement lblEngagementName;
	
	@FindBy(xpath="")//how to find this
	WebElement tooltipEngagementName;
	
	@FindBy(xpath="//select[@id='account_id']")
	WebElement drpdwnAccount;
	
	@FindBy(xpath="//select[@id='delivery_method_id']")
	WebElement drpdwnDeliveryMethod;
	
	@FindBy(xpath="//select[@id='contract_type_id']")
	WebElement drpdwnContractType;
	
	@FindBy(xpath="//input[@id='years']")
	WebElement txtYears;
	
	@FindBy(xpath="//span[@class='help-block form-error']")
	WebElement lblYears;
	
	@FindBy(xpath="//input[@id='managed']")
	WebElement rdbtnManageYes;
	
	@FindBy(xpath="//input[@id='not_managed']")
	WebElement rdbtnManageNo;
	
	@FindBy(xpath="//button[@id='cancel']")
	WebElement btnCancel;
	        
	@FindBy(xpath="//button[@id='submit_engagement']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//span[@id='jconfirm-box22959']")
	WebElement msgSubmit;
	
	@FindBy(xpath="//button[1][@class='btn btn-default']")
	WebElement btnAddNewEntry;
	
	@FindBy(xpath="//button[2][@class='btn btn-default']")
	WebElement btnGoToDashBoard;
	
	//method for identifying the page title
	public boolean getPageName(String lblExpectedTitle) {
        boolean flag = false;

        String pageName = lblPageName.getText();
        if (pageName.contains(lblExpectedTitle)) {
               System.out.println("Navigated to Engagement page " + pageName);
               flag = true;
        } else {
               System.out.println("Navigated to wrong page");
               flag = false;
        }
        return flag;
 }

	
	//methods for verify the empty fields
	public boolean IsFieldEmpty(String text){
		
		try{
			boolean field = driver.getPageSource().contains(text);
			 return field;
			// field.clear();
	        }
	        catch(Exception ex){
	            return false;
	        }
		//assertTrue(isTextPresent("Value is required and can't be empty"), "Msg is absent/wrong/misspelled");
	}
	
	//method for check the field values are alpha numeric
	
	/*@test
	public void verifyAlphaNumeric(String text){
		setText(By.id('myInput'), text);
	    String b = getText(By.id('myInput'));
	    assertTrue(b.matches('[a-zA-Z0-9]{8,}'));
	}
	*/
	//methods for the text fields and drop downs
	public void enterEngagementName(){
		try{
			TestLog.log.info("enter engagement name");
			txtEngagementName.sendKeys("AVA");
			TestLog.log.info("Engagement name will appear as AVA");
			
		}catch(Exception ex){
			TestLog.log.info("Error entering engagement name" + ex);
		}
	}
	
	//method for verifying engagement name
	public String verifyEngagementName(){

		return lblEngagementName.getText();
		
	}
	
	//method for verifying tool tip in engagement name
	public void verifyTooltip(){
		
		try{
			TestLog.log.info("tooltip");
			//WebElement toolTipObject = tooltipEngagementName;
			String TooltipError = tooltipEngagementName.getAttribute("Please fill out this field");
			
			TestLog.log.info("tooltip");
		}catch(Exception ex){
			
		}
		//The custom tooltip can be made visible with the following code during the execution of the automation test:
			/*Actions builder = new Actions(WebDriver);
			builder.ClickAndHold(onElement).Perform();
			builder.MoveByOffset(5, 5);*/
		/*// Create action class object
		Actions builder=new Actions(driver); 
		// find the tooltip message xpath
		WebElement element =tooltipEngagementName;
		// Mouse hover to that text
		builder.moveToElement(element).perform();
		// Extract the text from tooltip using getText
		String tooltipMessage=element.getText();
		 // Print the tooltip message
		System.out.println("Tooltip message is "+tooltipMessage);
		// This is expected message should come and store in variable
		 String expected_tooltip="You can use letters, numbers, and periods.";
		// It will compare if actual matches with expected then TC will fall else it will fail
		Assert.assertEquals(tooltipMessage, expected_tooltip);
		System.out.println("Message verifed");*/
	}
	
	//method for selecting an account
	public void selectAccount(String lblAccountValue){
		try{
			TestLog.log.info("select an account from the drop down");
			Select value = new Select(drpdwnAccount);
			value.selectByVisibleText(lblAccountValue);
					
			TestLog.log.info("selected value will appear in account field");
		}catch(Exception ex){
			TestLog.log.info("Error selecting account name" + ex);
		}
	}
	
	//method for selecting a Delivery method
	public void selectDeliveryMethod(String lblDeliveryMethodValue){
		try{
			TestLog.log.info("select a delivery method from the drop down");
			Select value = new Select(drpdwnDeliveryMethod);
			value.selectByVisibleText(lblDeliveryMethodValue);
					
			TestLog.log.info("selected value will appear in delivery method field");
		}catch(Exception ex){
			TestLog.log.info("Error selecting delivery method" + ex);
		}
	}
	
	//method for selecting a ContractType
	public void selectContractType(String lblContractTypeValue){
		try{
			TestLog.log.info("select a contract type from the drop down");
			Select value = new Select(drpdwnContractType);
			value.selectByVisibleText(lblContractTypeValue);
					
			TestLog.log.info("selected value will appear in contract type field");
		}catch(Exception ex){
			TestLog.log.info("Error selecting contract type" + ex);
		}
	}
	
	//method for enter Year
	public void enterYears(String txtYearValue){
		try{
			TestLog.log.info("enter years");
			txtYears.sendKeys(txtYearValue);
			TestLog.log.info("no of years will appear as AVA");
			
		}catch(Exception ex){
			TestLog.log.info("Error entering years" + ex);
		}
	}
	
	//method for verifying years
		public String verifyYears(){

			return lblYears.getText();
			
		}
	
	//methods for selecting radio button yes and no
	public void selectManagedYes(){
		try{
			TestLog.log.info("select yes in managed");
			rdbtnManageYes.click();
			TestLog.log.info("yes will be selected");
			
		}catch(Exception ex){
			
		}
	}
	
	public void selectManagedNo(){
		try{
			TestLog.log.info("select no in managed");
			rdbtnManageNo.click();
			TestLog.log.info("no will be selected");
			
		}catch(Exception ex){
			
		}
	}
	
	//methods for cancel and submit
	public void clickCancel(){
		try{
			TestLog.log.info("select cancel");
			btnCancel.click();
			TestLog.log.info("add new engagement will cancel");
			
		}catch(Exception ex){
			
		}
	}
	
	public void clickSubmit(){
		try{
			TestLog.log.info("select submit");
			btnSubmit.click();
			TestLog.log.info("add new engagement will submit");
			
		}catch(Exception ex){
			
		}
	}
	
	//method for verifying submit
	public String verifySubmit(){

		return msgSubmit.getText();
				
	}
	
	public void selectAddNewEntry(){
		try{
			TestLog.log.info("select add new entry");
			btnAddNewEntry.click();
			TestLog.log.info("new entry will submit");
			
		}catch(Exception ex){
			
		}
		
	}
	
	public void selectGoToDashboard(){
		try{
			TestLog.log.info("select go to dashboard");
			btnGoToDashBoard.click();
			TestLog.log.info("navigate to dashboard page");
			
		}catch(Exception ex){
			
		}
	}
		
	
	
	
	
	
	
	
	
	
	 
	            
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
