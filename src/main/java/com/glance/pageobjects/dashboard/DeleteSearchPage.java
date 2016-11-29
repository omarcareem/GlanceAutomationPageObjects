package com.glance.pageobjects.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DeleteSearchPage extends BasePage{

	public DeleteSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//variable declaration with xpath for identifying page name
		@FindBy(xpath="//div[@class='x_title']/h2")
		WebElement lblPageName;
	
	//variable declaration with xpath for Delete search page
		@FindBy(xpath="//a[@id='search_tab']")
		WebElement tabSearch;
		
		@FindBy(xpath="//select[@id='table_id']")
		WebElement drpdwnSelectType;
		
		@FindBy(xpath="//input[@id='id']")
		WebElement txtId;
		
		@FindBy(xpath="//input[@id='entity_name']")
		WebElement txtName;
		
		@FindBy(xpath="//button[@id='submit_form']")
		WebElement btnSearch;
		
		@FindBy(xpath="//a[@id='sql_tab']")
		WebElement tabSql;
		
		@FindBy(xpath="//textarea[@id='sql']")
		WebElement txtareaSql;
		
		@FindBy(xpath="//button[@id='submit_sql']")
		WebElement btnSubmit;
		        
		//variable diclaration with xpath for Search page icons
		@FindBy(xpath="//i[@class='fa fa-chevron-up']")
		WebElement icnMaxMin;
		
		@FindBy(xpath="//i[@class='fa fa-close']")
		WebElement icnClose;
		
		
		// page specifying method(verification)
		public String verifyPageName() {
			return lblPageName.getText();
		}
		
		//delete search page confirmation
	    public boolean verifyNavigationToDeleteSearchPage(String expectedMessage) {
	       
	        
	       boolean flag;
	       
	        String actualMessage=lblPageName.getText();
	               
	              
	                     if (actualMessage.contains(expectedMessage)) {
	                     flag = true;
	                     System.out.println("You are in the Delete Search page");             
	                
	            } else {
	              System.out.println("You are not in the Delete Search page");
	                flag = false;                     
	            }
	        
	        return flag;
	    }
	    
		//methods for the Search tab in Delete search page
		public void clickSearchTab(){
			try{
				TestLog.log.info("click on search tab");
				tabSearch.click();
				TestLog.log.info("navigate to search tab");
				
			}catch(Exception ex){
				
			}
		}
		
		public void selectType(String drpdwnTypeValue){
			try{
				TestLog.log.info("select Type from the drop down list");
				Select value = new Select(drpdwnSelectType);
				value.selectByVisibleText(drpdwnTypeValue);
						
				TestLog.log.info("selected value will appear in the Type field");
			}catch(Exception ex){
				
			}
		}
		
		public void enterId(String enterTxtID){
			try{
				TestLog.log.info("enter ID");
				txtId.sendKeys(enterTxtID);
				TestLog.log.info("entered ID will appear in the ID field");
				
			}catch(Exception ex){
				
			}
		}
		
		public void enterName(String enterTxtName){
			try{
				TestLog.log.info("enter Name");
				txtName.sendKeys(enterTxtName);
				TestLog.log.info("entered Name will appear in the Name field");
				
			}catch(Exception ex){
				
			}
		}
		
		public void clickSearch(){
			try{
				TestLog.log.info("click on search button");
				btnSearch.click();
				TestLog.log.info("This will navigate to Delete Search Record page");
				
			}catch(Exception ex){
				
			}
		}
		
		//methods for the SQL tab in Delete search page
		public void clickSqlTab(){
			try{
				TestLog.log.info("click on sql tab");
				tabSql.click();
				TestLog.log.info("navigate to sql tab");
				
			}catch(Exception ex){
				
			}
		}
		
		public void enterSqlQuery(String sqlQuery){
			try{
				TestLog.log.info("enter sql query");
				txtareaSql.sendKeys(sqlQuery);
				TestLog.log.info("sql query will appear in the sql field");
				
			}catch(Exception ex){
				
			}
		}
		
		public void clickSubmit(){
			try{
				TestLog.log.info("click on submit button");
				btnSubmit.click();
				TestLog.log.info("All the records relevant to accounts will listed in a tabel");
				
			}catch(Exception ex){
				
			}
		}
		
}
