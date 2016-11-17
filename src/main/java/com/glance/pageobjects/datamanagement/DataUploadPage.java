package com.glance.pageobjects.datamanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DataUploadPage extends BasePage{

	public DataUploadPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath="//div[@class='x_title']/h2")
	WebElement lblPageName;
	
	@FindBy(id="tbl_data")
	WebElement drpSelectDataTable;
	
	@FindBy(xpath="//div[@id='dZUpload']")
	WebElement selectFile;
	
	@FindBy(xpath="//button[@id='upload']")
	WebElement btnUpload;
	
	@FindBy(xpath="//span[@id='jconfirm-box68404']")
	WebElement errorMessage;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement btnOkay;
	
	@FindBy(xpath="//a[@class='collapse-link']")
	WebElement clickCollapse;
	
	@FindBy(xpath="//i[@class='fa fa-close']")
	WebElement clickClose;
	
	//identifying page name
	public String getPageName(){
	
		return lblPageName.getText();	 
	}
	
	//selecting a table
	public void selectDataTable(String tableName){
		
		try {
		
			TestLog.log.info("Selecting a table from drop down list");
			Select dropdown = new Select(drpSelectDataTable);
			dropdown.selectByVisibleText(tableName);	
			TestLog.log.info("Selected a table from drop down list");
		}
		
		catch(Exception ex){
			TestLog.log.info("Could not select table. "+ ex);
		}
	}
		
	//clicking upload
	public void clickUpload(){
		
		try {
			
			TestLog.log.info("Clicking upload button");
			btnUpload.click();
			TestLog.log.info("Clicked upload button");
		}
		
		catch(Exception ex){
			TestLog.log.info("Could not click upload. "+ ex);
		}
	}
	
	
	//error message
	public void errorMessage(){
		
		errorMessage.getText();
	}
	
	//error message accepted
	public void clickOkay(){
			
		btnOkay.click();
	}
		
	//clicking collapse
	public void clickCollapse(){
		
		try {
			
			TestLog.log.info("Clicking collapse icon");
			clickCollapse.click();
			TestLog.log.info("Clicked collapse icon");
		}
		
		catch(Exception ex){
			TestLog.log.info("Could not click collapse. "+ ex);
		}
	}
	
	//clicking close
	public void clickClose(){
		
		try {
			
			TestLog.log.info("Clicking close icon");
			clickClose.click();
			TestLog.log.info("Clicked close icon");
		}
		
		catch(Exception ex){
			TestLog.log.info("Could not click close. "+ ex);
		}	
	}
	
	
			
}

