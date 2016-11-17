package com.glance.pageobjects.datamanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DataDeleteUpdatePage extends BasePage{

	public DataDeleteUpdatePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath="//div[@class='x_title']/h2")
	WebElement lblPageName;
	
	@FindBy(id="table_id")
	WebElement drpSelectDataTable;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement txtSearch;
	
	@FindBy(xpath="//button[@id='updateButton']")
	WebElement btnUpdate;
	
	@FindBy(xpath="//button[@id='deleteButton']")
	WebElement btnDelete;
	
	@FindBy(xpath="//div[@class='content']")
	WebElement errorMessage;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement btnOkay;
	
	@FindBy(xpath="//i[@class='fa fa-chevron-up']")
	WebElement clickCollapse;
	
	@FindBy(className="paginate_button first disabled")
	WebElement btnFirst;
	
	@FindBy(className="paginate_button previous disabled")
	WebElement btnPrevious;
	
	@FindBy(className="paginate_button next")
	WebElement btnNext;
	
	@FindBy(className="paginate_button last")
	WebElement btnLast;
	
	@FindBy(xpath="//i[@class='fa fa-close']")
	WebElement clickClose;
	
	//identifying page name
	public String getPageName(){
	
			return lblPageName.getText();
	}
	
	//selecting a table
	public void selectSegment(String tableName){
			
		try	{
				
			TestLog.log.info("Select a table from drop down list");
			Select dropdown = new Select(drpSelectDataTable);
			dropdown.selectByVisibleText("cdi");	
			TestLog.log.info("Selected a table from drop down list");
		}
			
		catch(Exception ex){
			TestLog.log.info("Could not select segment. "+ ex);
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
	
	public void enterSearch(String searchText){
		
		try {
			
			TestLog.log.info("Giving search text");
			txtSearch.sendKeys(searchText);
			TestLog.log.info("Gave search text");
		}
		
		catch(Exception ex){
			TestLog.log.info("Could not enter search text. "+ ex);
		}	
	}
	
	//paginate buttons
	public void clickFirst(){
		
		btnFirst.click();
	}
	
	public void clickPrevious(){
		
		btnPrevious.click();
	}
	
	public void clickNext(){
		
		btnNext.click();
	}

	public void clickLast(){
		
		btnLast.click();
	}
		
	
	//clicking update
	public void clickUpdate(){
				
		try {
					
			TestLog.log.info("Clicking update button");
			btnUpdate.click();
			TestLog.log.info("Clicked update button");
		}
				
		catch(Exception ex){
			TestLog.log.info("Could not click update. "+ ex);		
		}
	}
		
	//clicking delete
	public void clickDelete(){
				
		try {
					
			TestLog.log.info("Clicking delete button");
			String userin = null;
			WebElement selectRow = driver.findElement(By.xpath("//td[text()='"+userin+"']/.."));
			selectRow.click();
			btnDelete.click();
			TestLog.log.info("Clicked delete button");
		}
				
		catch(Exception ex){
			TestLog.log.info("Could not click delete. "+ ex);		
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
				
			TestLog.log.info("Clicking the collapse icon");
			clickCollapse.click();
			TestLog.log.info("Clicked the collapse icon");
		}
			
		catch(Exception ex){
			TestLog.log.info("Could not click collapse. "+ ex);	
		}
	}
	
	//clicking close
	public void clickClose(){
			
		try {
				
			TestLog.log.info("Clicking the close icon");
			clickClose.click();
			TestLog.log.info("Clicked the close icon");
		}
			
		catch(Exception ex){
			TestLog.log.info("Could not click close. "+ ex);	
		}
	}
}