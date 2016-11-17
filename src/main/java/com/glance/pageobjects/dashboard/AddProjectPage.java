package com.glance.pageobjects.dashboard;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class AddProjectPage extends BasePage {

	public AddProjectPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@class='x_title']/h2")
	WebElement lblProjectForm;
	
	@FindBy(xpath = "//i[@class='fa fa-chevron-up']")
	WebElement ClickCollapse;

	@FindBy(xpath = "//i[@class='fa fa-close']")
	WebElement ClickClose;

	@FindBy(id = "project_name")
	WebElement txtProjectName;
	
	@FindBy(xpath="//div[1]/div[1]/span")
	WebElement lblProjectName;

	@FindBy(xpath = "//input[@id='project_id']")
	WebElement txtClientProjectId;
	
	@FindBy(xpath="//div[2]/div/span")
	WebElement lblClientProjectId;

	@FindBy(id = "engagement_id")
	WebElement drpEngagementName;

	@FindBy(id = "application_id")
	WebElement drpApplicationName;
	
	@FindBy(id = "funding_start")
	WebElement txtFundingStart;

	@FindBy(id = "funding_end")
	WebElement txtFundingEnd;
	
	@FindBy(id = "release_date")
	WebElement txtReleaseDate;

	@FindBy(xpath = "//select[@id='status']")
	WebElement drpStatus;

	@FindBy(xpath = "//button[@id='cancel']")
	WebElement btnCancel;

	@FindBy(id = "submit_project")
	WebElement btnSubmit;
	
	@FindBy(xpath="//span[@id='jconfirm-box80020']")
	WebElement lblDoneAddingNewEntry;
	
	@FindBy(xpath="//div[4]/button[1]")
	WebElement btnAddNewEntry;
	
	@FindBy(xpath="//div[4]/button[2]")
	WebElement btnGoToDashboard;
	
	

	


//Check Project title Name
	public String getProjectTitle() {
		
		return lblProjectForm.getText();

	}


//Click on Collapse Button on the top corner
		public void ClickCollapseBtn() {

			try {
				TestLog.log.info("Clicking on Collapse Icon on The top corner ");
				ClickCollapse.click();
				TestLog.log.info("Clicked on Collapse Icon on The top corner");

			} catch (Exception ex) {
				TestLog.log.info("Could not Click on Collapse Icon on The top corner. "+ex);
			}

		}
		
//Click on Close Button on the top corner
		public void ClickCloseBtn() {

			try {
				TestLog.log.info("Clicking on Close Icon on The top corner ");
				ClickClose.click();
				TestLog.log.info("Clicked on Close Icon on The top corner");

			} catch (Exception ex) {
				TestLog.log.info("Could not Click on Close Icon on The top corner. "+ex);
			}

		}
		
//Enter the Project Name
	public void EnterProjectName(String ProjectName){
			
			try{
				TestLog.log.info("Entering Project Name");
				txtProjectName.sendKeys(ProjectName);
				TestLog.log.info("Entered Project Name");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Enter Project Name. "+ex);
				}
			
		}

//Enter the Client Project ID
	public void EnterClientProjectId(String ClientProjectId){
			
			try{
				TestLog.log.info("Entering Client Project ID");
				txtClientProjectId.sendKeys(ClientProjectId);
				TestLog.log.info("Entered Client Project ID");
				
				}catch(Exception ex){
					TestLog.log.info("Could not Enter Client Project ID. "+ex);
				}
			
		}

//Select Engagement name
	public void SelectEngagementName(String EngagementName){
		
		try{
			TestLog.log.info("Selecting Engagement Name");
			
			Select dropdown= new Select(drpEngagementName);
			dropdown.selectByVisibleText(EngagementName);
			
			TestLog.log.info("Selected Engagement Name");
			
			}catch(Exception ex){
				TestLog.log.info("Could not Enter Engagement Name. "+ex);
			}
		
	}

//Select Application name
	public void SelectApplicationName(String ApplicationName){
		
		try{
			TestLog.log.info("Selecting Application Name");
			
			Select dropdown= new Select(drpApplicationName);
			dropdown.selectByVisibleText(ApplicationName);
			
			TestLog.log.info("Selected Application Name");
			
			}catch(Exception ex){
				TestLog.log.info("Could not Enter Application Name. "+ex);
			}
		
	}
	
	By calendarMonthYear = By.xpath("//th[@class='month']");

	@FindBy(xpath = "//th[@class='month']/../th/i")
	WebElement calendarBackArrow;

	@FindBy(xpath = "//th[@class='month']/../th[3]/i")
	WebElement calendarFrontArrow;
	
	
	
// select calendar date
	public void selectCalendarDate(String monthYear, String day) {
		driver.findElement(
				By.xpath("//th[text()='" + monthYear
						+ "']/../../../tbody/tr/td[text()='" + day + "']"))
				.click();
	}

// select calendar month and year
	public void selectFundReleaseDate(String calendarMonth,
			String calendarYear, String calendarDate) {

		try {

			List<WebElement> stringCalendarMonthYear = driver
					.findElements(calendarMonthYear);

			String selectCalendarMonthYear = calendarMonth + " " + calendarYear;

			int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);

			int calendarMonthInNumber = Integer.parseInt(calendarMonth);
			int calendarYearInNumber = Integer.parseInt(calendarYear);

			if (currentYear == calendarYearInNumber) {
				if (currentMonth == calendarMonthInNumber) {
					selectCalendarDate(selectCalendarMonthYear, calendarDate);
				} else if (currentMonth < calendarMonthInNumber) {
					for (WebElement calMonthYear : stringCalendarMonthYear) {
						if (calMonthYear.getText() == selectCalendarMonthYear) {
							selectCalendarDate(selectCalendarMonthYear,
									calendarDate);
							break;
						}
						calendarFrontArrow.click();
					}
				} else if (currentMonth > calendarMonthInNumber) {
					for (WebElement calMonthYear : stringCalendarMonthYear) {
						if (calMonthYear.getText() == selectCalendarMonthYear) {
							selectCalendarDate(selectCalendarMonthYear,
									calendarDate);
							break;
						}
						calendarBackArrow.click();
					}
				}
			} else if (currentYear < calendarYearInNumber) {
				for (WebElement calMonthYear : stringCalendarMonthYear) {
					calendarFrontArrow.click();
					if (calMonthYear.getText() == selectCalendarMonthYear) {
						selectCalendarDate(selectCalendarMonthYear, calendarDate);
						break;
					}
				}
			} else if (currentYear > calendarYearInNumber) {
				for (WebElement calMonthYear : stringCalendarMonthYear) {
					calendarBackArrow.click();
					if (calMonthYear.getText() == selectCalendarMonthYear) {
						selectCalendarDate(selectCalendarMonthYear, calendarDate);
						break;
					}
				}
			}

		} catch (Exception ex) {
			System.out.println("Sucessfully select the calendar date");
		}

	}

// select funding start date 
	public void selectFundingStartDate(String fundStartMonth,
			String fundStartYear, String fundStartDate) {

		TestLog.log.info("Clicking on funding start input field");
		txtFundingStart.click();
		TestLog.log.info("Clicked on funding start input field");
		selectFundReleaseDate(fundStartMonth, fundStartYear, fundStartDate);

	}
	
// select funding end date 	
	public void selectFundingEndDate(String fundEndMonth,
			String fundEndYear, String fundEndDate) {

		TestLog.log.info("Clicking on funding end input field");
		txtFundingEnd.click();
		TestLog.log.info("Clicked on funding end input field");
		selectFundReleaseDate(fundEndMonth, fundEndYear, fundEndDate);

	}
	
	
// select Release date 	
	public void selectReleaseDate(String fundReleaseMonth,
			String fundReleaseYear, String fundReleaseDate) {

		TestLog.log.info("Clicking on funding start input field");
		txtFundingStart.click();
		TestLog.log.info("Clicked on funding start input field");
		selectFundReleaseDate(fundReleaseMonth, fundReleaseYear, fundReleaseDate);

	}


//Select Status
public void SelectStatus(String Status){
	
	try{
		TestLog.log.info("Selecting Status");
		
		Select dropdown= new Select(drpStatus);
		dropdown.selectByVisibleText(Status);
		
		TestLog.log.info("Selected Status");
		
		}catch(Exception ex){
			TestLog.log.info("Could not Enter Status. "+ex);
		}
	
}

//Click on Cancel Button 
	public void ClickCancelBtn() {

		try {
			TestLog.log.info("Clicking on Cancel Button ");
			btnCancel.click();
			TestLog.log.info("Clicked on Cancel Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on Cancel Button. "+ex);
		}

	}

	//Click on Submit Button 
		public void ClickSubmitBtn() {

			try {
				TestLog.log.info("Clicking on Submit Button ");
				btnSubmit.click();
				TestLog.log.info("Clicked on Submit Button");

			} catch (Exception ex) {
				TestLog.log.info("Could not Click on Submit Button. "+ex);
			}

		}
		
	//Check Project Done Adding New Entry
		public String getDoneAddingNewEntry() {
			
			return lblDoneAddingNewEntry.getText();

		}
		
	//Click on Add New Button 
		public void ClickAddNewBtn() {

			try {
				TestLog.log.info("Clicking on Add New Button ");
				btnAddNewEntry.click();
				TestLog.log.info("Clicked on Add New Button");

			} catch (Exception ex) {
				TestLog.log.info("Could not Click on Add New Button. "+ex);
			}

		}
	
	//Click on Go To Dash Board Button 
		public void ClickGoToDashBoardBtn() {

			try {
				TestLog.log.info("Clicking on Go To Dash Board Button ");
				btnGoToDashboard.click();
				TestLog.log.info("Clicked on Go To Dash Board Button");

			} catch (Exception ex) {
				TestLog.log.info("Could not Click on Go To Dash Board Button. "+ex);
			}

		}
	



}
