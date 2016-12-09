package com.glance.pageobjects.usermanagement;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class EditGroupMembership extends BasePage {

	public EditGroupMembership(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	

	@FindBy(xpath=("//select[@id='select_group']"))
	WebElement drpEditSelectGroup;
	
	@FindBy(xpath=("//button[@class='btn btn-danger']"))   
	WebElement btnOk;
	
	@FindBy(xpath=("//button[contains(text(),'Close')]"))   
	WebElement btnClose;
	
	@FindBy(xpath=("//div[@id='main_body']/div/div/div[1]/div[1]/h2"))
	WebElement pagelbl;
	
	@FindBy(xpath=("//input[@type='search']"))  
	WebElement txtSearch;
	
	@FindBy(xpath = ("//tr[@class='headings']"))
	WebElement table;
	
	By linkDelete=By.xpath("//a[contains(text(),'Delete')]");
	
	
	//Verify page
	
	public boolean getTitle(){
		Boolean flag;
		flag= false;
		String actual = driver.getPageSource();
		
		if (actual.contains("Add group membership ")){
			System.out.println("In group membership page");
			flag=true;
		}
		return flag;
		
		
	}
	
	//select group from drop down
	
	public void selectGroup(String group){
		try{
			TestLog.log.info("Selecting group");
			//drpEditSelectGroup.click();
			
			Select dropdown= new Select(drpEditSelectGroup);
			dropdown.selectByVisibleText(group);
			
			TestLog.log.info("Group selected");
		
		} catch (Exception ex) {
			
		}
		
	}
	
	// To remove a user in the selected group	
	public void removeUser(String user) {
		try{
			TestLog.log.info("Deleting the user");
					
			WebElement btnDelete=driver.findElement(By.xpath("//td[text()='"+user+"']/../td[7]/div[@class='fa-hover']"));
			btnDelete.click();
			
			Thread.sleep(5000);

			//btnOk.click();
	
			TestLog.log.info("Details were deleted");

		}
			catch (Exception ex) {
		
		}}
	
	//Conform remove user
	
	public void ClickOkToRemoveUser() {
		try{
			TestLog.log.info("Deleting the user");
			
			btnOk.click();
			TestLog.log.info("Details were deleted");

		}
			catch (Exception ex) {
		
		}}
	
		
	//Close Remove user
		public void closeRemove() throws InterruptedException{
			btnClose.click();
			Thread.sleep(5000);
		
		}
	
	//Check removed or not
	public boolean verifyRemove(String user){
		txtSearch.sendKeys(user);
		
		String source=driver.getPageSource();
		
		//WebElement table = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		//String text = table.getText();
		boolean flag = false;
	
		if(source.contains("No data available in table")){
			flag = true;
		}
		
		return flag;
		
		
		
		/*boolean flag = true;
		
		WebElement tblUser = driver.findElement(By.xpath("//tbody"));
		List<WebElement> tblRow = tblUser.findElements(By.tagName("tr"));

		outerloop: {
			for (WebElement row : tblRow) {

				List<WebElement> tblData = row
						.findElements(By.xpath("//td[3]"));

				for (WebElement data : tblData) {

					String userName = data.getText();
					System.out.println(userName);
					if (userName.contains(user)) {
						System.out.println("Success");
						flag = false;
						break outerloop;
					}
				}
			}
		}
		return flag;*/
			
	}
	
	public void closeDelete(String user) {
		try{
			TestLog.log.info("Deleting the user");

			WebElement btnDelete = driver.findElement(By.xpath("//td[text()='"+user+"']/../td[7]/div[@class='fa-hover']"));
			btnDelete.click();
			btnClose.click();

			TestLog.log.info("Details were deleted");
			
		} catch (Exception ex) {
		
		}
			
	}
	public boolean verifyTableIsDisplayed(){
		boolean flag = false;
		String tableData=table.getText();
		
		if(tableData.contains("User ID")){
			flag=true;
		}
		return flag;
		
	}
}
	
	
	

	
