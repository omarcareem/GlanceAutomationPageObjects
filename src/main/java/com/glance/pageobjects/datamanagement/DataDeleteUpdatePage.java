package com.glance.pageobjects.datamanagement;

import java.util.List;

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
	
	@FindBy(xpath="//span[@class='title']")
	WebElement deleteConfirmationMessage;
	
	@FindBy(xpath="//span[@class='title']")
	WebElement updateConfirmationMessage;
	
	@FindBy(xpath="//body/div[6]/div[2]/div/div/div/div/div[4]/button[1]")
	WebElement btnDeleteOkay;
	
	@FindBy(xpath="//body/div[6]/div[2]/div/div/div/div/div[4]/button[2]")
	WebElement btnDeleteClose;
	
	@FindBy(xpath="//button[@class='btn btn-warning']")
	WebElement btnUpdateOkay;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement btnUpdateClose;
	
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
	
	
	//add data delete update page confirmation
    public boolean verifyNavigationToDataDeleteUpdatePage(String expectedMessage) {
       
        
       boolean flag;
       
        String actualMessage=lblPageName.getText();
               
              
                     if (actualMessage.contains(expectedMessage)) {
                     flag = true;
                     System.out.println("You are in the delete update page");             
                
            } else {
              System.out.println("You are not in the delete update page");
                flag = false;                     
            }
        
        return flag;
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
		
	//update confirmation message
		public boolean verifyUpdateConfirmation(String expectedMessage) {
		    
				boolean flag;
		    
				String actualMessage=updateConfirmationMessage.getText();
		            
		        if (actualMessage.contains(expectedMessage)) {
		        	flag = true;
		            System.out.println("You are in the delete update page");             
		             
		        } else {
		        	System.out.println("You are not in the delete update page");
		            flag = false;                     
		        }
		     
		        return flag;
			}
	
		//update confirmation click
		public void clickUpdateOkay(){
						
			btnUpdateOkay.click();
		}
				
		public void clickUpdateClose(){
				
			btnUpdateOkay.click();
		}
		
	//clicking delete
	public void clickDelete(String userin){
				
		try {
					
			TestLog.log.info("Clicking delete button");
			WebElement selectRow = driver.findElement(By.xpath("//td[text()='"+userin+"']/.."));
			selectRow.click();
			btnDelete.click();
			TestLog.log.info("Clicked delete button");
		}
				
		catch(Exception ex){
			TestLog.log.info("Could not click delete. "+ ex);		
		}
	}
	
	//delete confirmation message
		public boolean verifydeleteConfirmationMessage(String expectedMessage){
			    
				boolean flag=false;
		    
				String actualMessage=deleteConfirmationMessage.getText();
		            
		        if (actualMessage.contains(expectedMessage)) {
		        	flag = true;
		            System.out.println("You have deleted the record");             
		             
		        } else {
		        	System.out.println("You have not deleted the record");
		            flag = false;                     
		        }
		     
		        return flag;
		}
		
		//delete confirmation click
		public void clickDeleteOkay(){
					
			btnDeleteOkay.click();
		}
			
		public void clickDeleteClose(){
			
			btnDeleteClose.click();
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
	
	//verify delete
		public boolean verifyDeleted(String userin){
	        boolean flag = true;

	        WebElement tblUser = driver.findElement(By.xpath("//tbody"));
	        List<WebElement> tblRow = tblUser.findElements(By.tagName("tr"));

	        outerloop: {
	               for (WebElement row : tblRow) {

	                     List<WebElement> tblData = row.findElements(By.xpath("//td[1]"));

	                     for (WebElement data : tblData) {

	                            String userName = data.getText();
	                            //System.out.println(userName);
	                            if (userName.contains(userin)) {
	                                   System.out.println("Deleted");
	                                   flag = false;
	                                   break outerloop;

	                            }
	                     }
	               }
	        }
	        
	        return flag;
		}
	}


