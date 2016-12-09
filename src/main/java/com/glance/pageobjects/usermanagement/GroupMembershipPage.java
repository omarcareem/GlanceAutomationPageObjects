package com.glance.pageobjects.usermanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class GroupMembershipPage extends BasePage {

	public GroupMembershipPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "user_data")
	WebElement drpSelectUser;

	@FindBy(id = "group_data")
	WebElement drpSelectGroup;

	@FindBy(id = "submit")
	WebElement btnAddMembership;

	@FindBy(xpath = ("//button[@type='button']"))
	WebElement btnCancel;

	@FindBy(xpath = ("//div[@class='x_title']/h2"))
	WebElement pagelbl;

	@FindBy(xpath = ("//button[@class='btn btn-success']"))
	WebElement btnDone;

	@FindBy(xpath = ("//button[@class='btn btn-warning']"))
	WebElement btnOk;

	@FindBy(xpath = ("//select[@id='select_group']"))
	WebElement drpEditSelectGroup;
	
	@FindBy(xpath = ("//div[@class='content']"))
	WebElement alertMsg;
	
	
	
	
	//Verify the page
	
	public boolean verifyNavigationToGroupMembershipPage(String expectedMessage){
		boolean flag = false;
		String actualMessage=pagelbl.getText();
		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You are in the Group Membership page");
			}
		else {
			System.out.println("You are not in the Group Membership page");
			flag = false;
			}
		
		return flag;
		
	} 
	
	//Verify alert message when submitting with empty field(s)
	
	public boolean getMsg(){
		Boolean flag;
		flag= false;
		//String title= alertMsg.getText();
		String title=driver.getPageSource();
		if (title.contains("Please select user and group")){
			System.out.println("Message is displayed as expected");
			flag=true;
		}
		return flag;
		
		
	}
	
	//Verify alert message when submitting duplicate entries
		public boolean getMsgDuplicateEntried(){
			Boolean flag;
			flag= false;
			String title= alertMsg.getText();
			if (title.contains("This is duplicate entry!")){
				System.out.println("Message is displayed as expected");
				flag=true;
			}
			return flag;
		
		}
	
	//Click ok
		
	public void clickOk(){
		btnOk.click();
	}
	
	
	// Select the user

	public void selectUser(String addUser) {
		try {
			TestLog.log.info("Selecting user");

			drpSelectUser.click();
			Select dropdown = new Select(drpSelectUser);
			dropdown.selectByVisibleText(addUser);
			TestLog.log.info("User is selected");

		} catch (Exception ex) {

		}
	}

	// Select the group

	public void selectGroup(String addSelectGroup) {
		try {
			TestLog.log.info("Selecting group");

			drpSelectGroup.click();
			Select dropdown = new Select(drpSelectGroup);
			dropdown.selectByVisibleText(addSelectGroup);
			TestLog.log.info("Group is selected");

		} catch (Exception ex) {

		}

	}

	// Submit to add member
	public void submit() {
		try {
			TestLog.log.info("Submitting group membership");
			btnAddMembership.click();
			Thread.sleep(5000);
			//btnDone.click();

			TestLog.log.info("Group membership may get submitted");

		} catch (Exception ex) {

		}

	}
	
	//Click done
	public void clickDone() {
		try {
			TestLog.log.info("Submitting group membership");
			btnDone.click();

			TestLog.log.info("Group membership may get submitted");

		} catch (Exception ex) {

		}

	}

	// Verify submit
	public boolean verifyAdded(String group, String addUser) {

		boolean flag = false;

		Select dropdown = new Select(drpEditSelectGroup);
		dropdown.selectByVisibleText(group);
		WebElement tblUser = driver.findElement(By.xpath("//tbody"));
		List<WebElement> tblRow = tblUser.findElements(By.tagName("tr"));

		outerloop: {
			for (WebElement row : tblRow) {

				List<WebElement> tblData = row
						.findElements(By.xpath("//td[3]"));

				for (WebElement data : tblData) {

					String userName = data.getText();
					System.out.println(userName);
					if (userName.contains(addUser)) {
						System.out.println("Success");
						flag = true;
						break outerloop;

					}

				}

			}
		}
		return flag;
	}
	
	

	// Canceling
	public void cancel() {
		try {
			TestLog.log.info("Canceling group membership");
			btnCancel.click();
			TestLog.log.info("canceled and in user details");

		} catch (Exception ex) {

		}

	}
	
	

}
