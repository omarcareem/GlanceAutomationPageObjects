package com.glance.pageobjects.dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class DeleteSearchRecordPage extends BasePage{

	public DeleteSearchRecordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//variable declaration with xpath for identifying page name
	@FindBy(xpath="//div[@class='x_title']/h2")
	WebElement lblPageName;
		
	//initialization of variables with the xpath in Delete Search Record page
	@FindBy(xpath="//div[@id='searchTable_length']/label/select[@name='searchTable_length']")
	WebElement drpdwnShowEntry;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement txtSearch;

	@FindBy(xpath="//a[@id='dataTable_first']")
	WebElement btnFirst;
	
	@FindBy(xpath="//a[@id='dataTable_previous']")
	WebElement btnPrevious;
	
	@FindBy(xpath="//a[@id='dataTable_next']")
	WebElement btnNext;
	
	@FindBy(xpath="//a[@id='dataTable_last']")
	WebElement btnLast;
	
	@FindBy(xpath="//a[@class='paginate_button current']")
	WebElement btnPageNumber;
	
	@FindBy(xpath="//a[@onclick='deleteData(this.id);']")
	WebElement btnDelete;

	// method for identifying the page title
		public boolean getPageName(String lblExpectedTitle) {
			boolean flag = false;

			String pageName = lblPageName.getText();
			if (pageName.contains(lblExpectedTitle)) {
				System.out.println("Navigated to delete Search result page " + pageName);
				flag = true;
			} else {
				System.out.println("Not Navigated to delete Search result page");
				flag = false;
			}
			return flag;
		}
			
	//methods for the Delete Search Record page
	public void clicktShowEntry(){
		try{
			TestLog.log.info("select the dropdwn list");
			drpdwnShowEntry.click();
			TestLog.log.info("drop down will appear");
		}catch(Exception ex){
			TestLog.log.info("Error clicking show entry" + ex);
		}
	}
	
	//methods for one by one selection
	By dropDownShowEntryValue = By.xpath("//div[@id='searchTable_length']/label/select[@name='searchTable_length']/option");
	
	public void selectValue(String inputShowEntry){
		
		List<WebElement> showEntryList = driver.findElements(dropDownShowEntryValue);
		
		for(WebElement showEntry : showEntryList){
			String selectShowEntry = showEntry.getText();
			if(selectShowEntry.contains(inputShowEntry)){
				showEntry.click();
				break;
			}else{
				System.out.println("Error selecting show entry");
			}
		}
	}
	
	public void enterSearch(String txtSerachValue){
		try{
			TestLog.log.info("enter value in the search text field");
			txtSearch.sendKeys(txtSerachValue);
			
			TestLog.log.info("AVA record will appear in the table");
		}catch(Exception ex){
			
		}
	}
	
	public void selectFirst(){
		try{
			TestLog.log.info("select first button");
			btnFirst.click();
			
			TestLog.log.info("first records will display in the table");
		}catch(Exception ex){
			
		}
	}
	public void selectPrevious(){
		try{
			TestLog.log.info("select previous button");
			btnPrevious.click();
			
			TestLog.log.info("previous records will display in the table");
		}catch(Exception ex){
			
		}
	}
	
	public void selectNext(){
		try{
			TestLog.log.info("select next button");
			btnNext.click();
			
			TestLog.log.info("next records will display in the table");
		}catch(Exception ex){
			
		}
	}
	
	public void selectLast(){
		try{
			TestLog.log.info("select last button");
			btnLast.click();
			
			TestLog.log.info("last records will display in the table");
		}catch(Exception ex){
			
		}
	}
	
	public void selectPageNumber(){
		try{
			TestLog.log.info("select page number");
			btnPageNumber.click();
			
			TestLog.log.info("records relevant to the selected page will display in the table");
		}catch(Exception ex){
			
		}
	}
	
	public void selectDelete(){
		try{
			TestLog.log.info("delete the record");
			btnDelete.click();
			
			TestLog.log.info("record will delete from the database");
		}catch(Exception ex){
			
		}
	}
	
	//method for verify the table
	@FindBy(xpath="//table[@id='searchTable']")
	WebElement searchResultTable;
	
	public void handleDynamicWebTable(String needToDeleteText){
		//locate rows of the located table
		List<WebElement> tableRow = searchResultTable.findElements(By.tagName("tr"));
		//get the row count
		int rowCount = tableRow.size();
		
		//now this will start the loop till find the last row of the table
		for(int row=0; row<rowCount; row++){
			
			//here it will take the column number by get it into a list
			List<WebElement> tableColumn = searchResultTable.findElements(By.tagName("td"));
			//get the column count
			int columnCount = tableColumn.size();
			
			//now this will start to loop till find the last column of the particular row
			for(int column=0; column<columnCount; column++){
				
				//this will retrieve a text from that particular cell
				String cellText = tableColumn.get(column).getText();
				
				//this will check whether the passing value is equal to the column text
				if (cellText.contains(needToDeleteText)){
					btnDelete.click();
				}else{
					System.out.println("Can not delete, There is no such data in the table");
					
				}
				
			}
			
		}
		
	}
	
	/*WebElement btnDelete = driver.findElement(By.xpath("//td[text()='"+user+"']/../td[7]/div[@class='fa-hover']"));
	btnDelete.click();*/
}
