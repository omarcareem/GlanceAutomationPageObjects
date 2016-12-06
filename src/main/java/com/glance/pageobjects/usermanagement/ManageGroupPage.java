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

public class ManageGroupPage extends BasePage {

	public ManageGroupPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//div[@id='main_body']/div/div/div[1]/div[1]/h2")
	WebElement lblAddGroup;

	@FindBy(xpath = "//i[@class='fa fa-group']")
	WebElement manageGroupsIcon;

	@FindBy(xpath = "//div/div[4]/div/div[2]/a[2]/span")
	WebElement manageGroupsCount;

	@FindBy(id = "group_name")
	WebElement txtGroupName;

	@FindBy(id = "myFile")
	WebElement btnChooseFile;

	@FindBy(xpath = "//input[@class='btn btn-success']")
	WebElement btnAdd;
	
	@FindBy(xpath=("//button[@class='btn btn-success']"))   
	WebElement btnOkayforAddGrp;
	
	@FindBy(xpath=("//button[@class='btn btn-danger']"))   
	WebElement btnOkayforDeleteGrp;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement btnCancel;

	@FindBy(xpath = "//i[@class='fa fa-chevron-up']")
	WebElement btnDrpDown;

	@FindBy(xpath = "//i[@class='fa fa-wrench']")
	WebElement btnSettings;

	@FindBy(xpath = "//i[@class='fa fa-close']")
	WebElement btnClose;

	@FindBy(xpath = "//select")
	WebElement dropShow;

	@FindBy(xpath = "//label/input")
	WebElement search;

	@FindBy(xpath = "//a[@class='paginate_button first disabled']")
	WebElement btnFirst;

	@FindBy(xpath = "//a[@class='paginate_button previous disabled']")
	WebElement btnPrevious;

	@FindBy(xpath = "  //a[@class='paginate_button current']")
	WebElement btnCurrent;

	@FindBy(xpath = "//span/a[2]")
	WebElement btnOne;

	@FindBy(xpath = "//span/a[2]")
	WebElement btnTwo;

	@FindBy(xpath = " //a[@class='paginate_button next']")
	WebElement btnNext;

	@FindBy(xpath = " //a[@class='paginate_button next']")
	WebElement btnLast;

	public boolean verifyNavigationToManageGroupPage(String expectedMessage){
		boolean flag = false;
		String actualMessage=lblAddGroup.getText();
		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You are in the Manage Group page");
			}
		else {
			System.out.println("You are not in the Manage Group page");
			flag = false;
			}
		
		return flag;
		
		
	}
	

	public void inputGroupName(String grpName) {

		try {
			TestLog.log.info("Typing on Group Name input field");
			txtGroupName.sendKeys(grpName);
			TestLog.log.info("Typed on Group Name input field");

		} catch (Exception ex) {
			System.out.println("Couldn't input Group name!");
		}

	}

	public void inputGroupImage() {

		try {
			TestLog.log.info("choosing File to input Group Image");
			btnChooseFile.click();
			TestLog.log.info("chosed File to input Group Image");

		} catch (Exception ex) {
			System.out.println("choosing a group image failed!");
		}

	}

	public void clickAddGroup() {

		try {
			TestLog.log.info("Adding group");
			btnAdd.click();
			TestLog.log.info("Added group");

		} catch (Exception ex) {
          System.out.println("Add Group Failed");
		}

	}

	public void clickCancelGroup() {

		try {
			TestLog.log.info("clicking cancel");
			btnCancel.click();
			TestLog.log.info("clicked cancel");

		} catch (Exception ex) {
          System.out.println("Cancel Add Group Failed");
		}

	}

	public void searchGroup(String searchText) {

		try {
			TestLog.log.info("searching group");
			search.sendKeys(searchText);
			TestLog.log.info("searching group");

		} catch (Exception ex) {
             System.out.println("search failed");
		}

	}

	public void selectRecords(int number) {

		try {
			TestLog.log.info("Selecting the number of records to be viewed");
			// drpJobRole.click();
			Select dropdown = new Select(dropShow);
			// dropdown.selectByVisibleText(number);

			TestLog.log.info("Selected the number of records to be viewed");

		} catch (Exception ex) {
           System.out.println("Selecting group details failed!");
		}

	}

	public void clickEdit(String groupName) {

		try {
			TestLog.log.info("clicking Edit");
			WebElement btnEdit = driver.findElement(By.xpath("//td[text()='"
					+ groupName + "']/../td[5]/div/a[1]"));
			btnEdit.click();
			TestLog.log.info("clicked Edit");

		} catch (Exception ex) {

		}

	}

	public void clickDelete(String groupNameNew) {

		try {
			TestLog.log.info("clicking Delete");
			
			WebElement btnDelete = driver.findElement(By.xpath("//td[text()='" + groupNameNew + "']/../td[5]/div/a[2]"));
			btnDelete.click();
			Thread.sleep(1000);
			btnOkayforDeleteGrp.click();
			TestLog.log.info("clicked Delete");

		} catch (Exception ex) {

		}

	}
	//verfiy added group
		public boolean verifyAdded(String grpName) {

	        boolean flag = false;

	        WebElement tblUser = driver.findElement(By.xpath("//tbody"));
	        List<WebElement> tblRow = tblUser.findElements(By.tagName("tr"));

	        outerloop: {
	               for (WebElement row : tblRow) {

	                     List<WebElement> tblData = row
	                                   .findElements(By.xpath("//td[3]"));

	                     for (WebElement data : tblData) {

	                            String groupName = data.getText();
	                            System.out.println(groupName);
	                            if (groupName.contains(grpName)) {
	                                   System.out.println("Successfully Added");
	                                   flag = true;
	                                   break outerloop;

	                            }

	                     }

	               }
	        }
	        return flag;
	 }
	   
		//verify group deleted
		public boolean verifyDeleted(String grpNameNew) {

	        boolean flag = true;

	        WebElement tblUser = driver.findElement(By.xpath("//tbody"));
	        List<WebElement> tblRow = tblUser.findElements(By.tagName("tr"));

	        outerloop: {
	               for (WebElement row : tblRow) {

	                     List<WebElement> tblData = row
	                                   .findElements(By.xpath("//td[3]"));

	                     for (WebElement data : tblData) {

	                            String groupName = data.getText();
	                            System.out.println(groupName);
	                            if (groupName.contains(grpNameNew)) {
	                                   System.out.println("Successfully Deleted");
	                                   flag = false;
	                                   break outerloop;

	                            }

	                     }

	               }
	        }
	        return flag;
	 }
	
	

}
