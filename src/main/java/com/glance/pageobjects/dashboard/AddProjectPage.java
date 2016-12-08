package com.glance.pageobjects.dashboard;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.common.CommonPageObject;
import com.glance.pageobjects.logs.TestLog;

public class AddProjectPage extends BasePage {

	public AddProjectPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='x_title']/h2")
	WebElement lblProjectForm;

	@FindBy(xpath = "//i[@class='fa fa-chevron-up']")
	WebElement clickCollapse;

	@FindBy(xpath = "//i[@class='fa fa-close']")
	WebElement clickClose;

	@FindBy(id = "project_name")
	WebElement txtProjectName;
	
	@FindBy(xpath = "//div[1]/div[1]/span")
	WebElement lblProjectName;

	@FindBy(xpath = "//input[@id='project_id']")
	WebElement txtClientProjectId;

	@FindBy(xpath = "//div[2]/div/span")
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

	@FindBy(xpath = "//span[@id='jconfirm-box80020']")
	WebElement lblDoneAddingNewEntry;

	@FindBy(xpath = "//div[4]/button[1]")
	WebElement btnAddNewEntry;

	@FindBy(xpath = "//div[4]/button[2]")
	WebElement btnGoToDashboard;
	
	
	
	
	

	
	
	// Check Project title Name
	public String getProjectTitle() {

		return lblProjectForm.getText();

	}

	public boolean verifyNavigationToAddProjectPage(String expectedMessage){
		boolean flag = false;
		String actualMessage=lblProjectForm.getText();
		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("You are in the Add project page");
		}
		else {
			System.out.println("You are not in the Add Project page");
			flag = false;
			}
		
		return flag;
		
		
	}
	
	
	
	// Click on Collapse Button on the top corner
	public void btnClickCollapseBtn() {

		try {
			TestLog.log.info("Clicking on Collapse Icon on The top corner ");
			clickCollapse.click();
			TestLog.log.info("Clicked on Collapse Icon on The top corner");

		} catch (Exception ex) {
			TestLog.log
					.info("Could not Click on Collapse Icon on The top corner. "
							+ ex);
		}

	}

	// Click on Close Button on the top corner
	public void btnClickCloseBtn() {

		try {
			TestLog.log.info("Clicking on Close Icon on The top corner ");
			clickClose.click();
			TestLog.log.info("Clicked on Close Icon on The top corner");

		} catch (Exception ex) {
			TestLog.log
					.info("Could not Click on Close Icon on The top corner. "
							+ ex);
		}

	}

	// Enter the Project Name
	public void enterProjectName(String projectName) {

		try {
			TestLog.log.info("Entering Project Name");
			txtProjectName.sendKeys(projectName);
			TestLog.log.info("Entered Project Name");

		} catch (Exception ex) {
			TestLog.log.info("Could not Enter Project Name. " + ex);
		}

	}
	
	public boolean verifyWrongProjectName(String expectedMessage){
		boolean flag = false;
		String actualMessage=lblProjectName.getText();
		if (actualMessage.contains(expectedMessage)) {
			flag = true;
			System.out.println("Error message for non alphanumeric values");
		}
		else {
			System.out.println("No any Error message for non alphanumeric values");
			flag = false;
			}
		
		return flag;
		
		
	}
	
	

	// Enter the Client Project ID
	public void enterClientProjectId(String clientProjectId) {

		try {
			TestLog.log.info("Entering Client Project ID");
			txtClientProjectId.sendKeys(clientProjectId);
			TestLog.log.info("Entered Client Project ID");

		} catch (Exception ex) {
			TestLog.log.info("Could not Enter Client Project ID. " + ex);
		}

	}

	// Select Engagement name
	public void selectEngagementName(String engagementName) {

		try {
			TestLog.log.info("Selecting Engagement Name");

			Select dropdown = new Select(drpEngagementName);
			dropdown.selectByVisibleText(engagementName);

			TestLog.log.info("Selected Engagement Name");

		} catch (Exception ex) {
			TestLog.log.info("Could not Enter Engagement Name. " + ex);
		}

	}

	// Select Application name
	public void selectApplicationName(String applicationName) {

		try {
			TestLog.log.info("Selecting Application Name");

			Select dropdown = new Select(drpApplicationName);
			dropdown.selectByVisibleText(applicationName);

			TestLog.log.info("Selected Application Name");

		} catch (Exception ex) {
			TestLog.log.info("Could not Enter Application Name. " + ex);
		}

	}

	
/*	By calendarMonthYear = By.xpath("//th[@class='month']");

	//@FindBy(xpath = "//th[@class='month']/../th/i")
	//WebElement calendarBackArrow;
	By calendarBackArrow = By.xpath("//th[@class='month']/../th/i");

	//@FindBy(xpath = "//th[@class='month']/../th[3]/i")
	//@FindBy(xpath = "//th[3]/i")
	//WebElement calendarFrontArrow;
	By calendarFrontArrow = By.xpath("//th[@class='month']/../th[3]/i");

	// select calendar date
	public void selectCalendarDate(String monthYear, String day) {
		driver.findElement(
				By.xpath("//th[text()='" + monthYear
						+ "']/../../../tbody/tr/td[text()='" + day + "']"))
				.click();
	}

	// select calendar month and year
	public void selectFundReleaseDate(String calendarMonth,
			String calendarYear, String calendarDate, int calendarMonthInNumber) {

		try {

			String selectCalendarMonthYear = calendarMonth + " " + calendarYear;
			System.out.println("selectCalendarMonthYear:"
					+ selectCalendarMonthYear);

			int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
			int currentYear = Calendar.getInstance().get(Calendar.YEAR);

			System.out.println("currentMonth: " + currentMonth);
			System.out.println("currentYear: " + currentYear);
			// CommonPageObject commonPageObject = new CommonPageObject(driver);
			// calendarMonthInNumber =
			// commonPageObject.getCurrentCalendarMonthinInt(calendarMonth);
			int calendarYearInNumber = Integer.parseInt(calendarYear);
			System.out
					.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("calendarMonthInNumber: "
					+ calendarMonthInNumber);
			System.out
					.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("calendarYearInNumber: " + calendarYearInNumber);
			System.out
					.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			List<WebElement> stringCalendarMonthYear = driver
					.findElements(calendarMonthYear);
			
			if (currentYear == calendarYearInNumber) {
				if (currentMonth == calendarMonthInNumber) {
					selectCalendarDate(selectCalendarMonthYear, calendarDate);
				} else if (currentMonth < calendarMonthInNumber) {
					for (WebElement calMonthYear : stringCalendarMonthYear) {
						System.out.println(calMonthYear.getText());
						if (calMonthYear.getText() == selectCalendarMonthYear) {
							selectCalendarDate(selectCalendarMonthYear,
									calendarDate);
							break;
						}
						//calendarFrontArrow.click();
						//driver.findElement(calendarFrontArrow).click();
						driver.findElement(By.xpath("//th[@class='month']/../th[3]/i")).click();
					}
				} else if (currentMonth > calendarMonthInNumber) {
					
					for (WebElement calMonthYear : stringCalendarMonthYear) {
						System.out.println(calMonthYear.getText());
						if (calMonthYear.getText() == selectCalendarMonthYear) {
							selectCalendarDate(selectCalendarMonthYear,
									calendarDate);
							break;
						}
						//calendarBackArrow.click();
						driver.findElement(calendarBackArrow).click();
					}
				}
			} else if (currentYear < calendarYearInNumber) {
				for (WebElement calMonthYear : stringCalendarMonthYear) {
				for(WebElement calMonthYear : driver
						.findElement(calendarMonthYear)){
						
					
					//calendarFrontArrow.click();
					//driver.findElement(calendarFrontArrow).click();
					System.out.println(calMonthYear.getText());
					driver.findElement(By.xpath("//th[@class='month']/../th[3]/i")).click();
					System.out.println(calMonthYear.getText());
					if (calMonthYear.getText() == selectCalendarMonthYear) {
						System.out.println(calMonthYear.getText());
						selectCalendarDate(selectCalendarMonthYear,
								calendarDate);
						break;
					}
					System.out.println("+++++++++++++++++++++++++");
					System.out.println(calMonthYear.getText());
				}
			} else if (currentYear > calendarYearInNumber) {
				for (WebElement calMonthYear : stringCalendarMonthYear) {
					System.out.println(calMonthYear.getText());
					//calendarBackArrow.click();
					driver.findElement(calendarBackArrow).click();
					if (calMonthYear.getText() == selectCalendarMonthYear) {
						selectCalendarDate(selectCalendarMonthYear,
								calendarDate);
						break;
					}
				}
			}

		} catch (Exception ex) {
			System.out.println("Not selected the date" + ex);
		}

	}*/

	
	
	// select funding start date
	public void selectFundingStartDate(String fundStartDate) {

		TestLog.log.info("Clicking on funding start input field");
		//txtFundingStart.click();
		TestLog.log.info("Clicked on funding start input field");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('funding_start').value = '"+fundStartDate+"';");
	}

	// select funding end date
	public void selectFundingEndDate(String fundEndDate) {

		TestLog.log.info("Clicking on funding end input field");
		//txtFundingEnd.click();
		TestLog.log.info("Clicked on funding end input field");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('funding_end').value = '"+fundEndDate+"';");
		
		

	}

	// select Release date
	public void selectFundingReleaseDate(String fundReleaseDate) {

		TestLog.log.info("Clicking on funding start input field");
		//txtFundingStart.click();
		TestLog.log.info("Clicked on funding start input field");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('release_date').value = '"+fundReleaseDate+"';");
		

	}

	// Select Status
	public void selectStatus(String status) {

		try {
			TestLog.log.info("Selecting Status");

			Select dropdown = new Select(drpStatus);
			dropdown.selectByVisibleText(status);

			TestLog.log.info("Selected Status");

		} catch (Exception ex) {
			TestLog.log.info("Could not Enter Status. " + ex);
		}

	}

	// Click on Cancel Button
	public void clickCancelBtn() {

		try {
			TestLog.log.info("Clicking on Cancel Button ");
			btnCancel.click();
			TestLog.log.info("Clicked on Cancel Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on Cancel Button. " + ex);
		}

	}

	// Click on Submit Button
	public void clickSubmitBtn() {

		try {
			TestLog.log.info("Clicking on Submit Button ");
			btnSubmit.click();
			TestLog.log.info("Clicked on Submit Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on Submit Button. " + ex);
		}

	}

	// Check Project Done Adding New Entry
	public String getDoneAddingNewEntry() {

		return lblDoneAddingNewEntry.getText();

	}

	// Click on Add New Button
	public void clickAddNewBtn() {

		try {
			TestLog.log.info("Clicking on Add New Button ");
			btnAddNewEntry.click();
			TestLog.log.info("Clicked on Add New Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on Add New Button. " + ex);
		}

	}

	// Click on Go To Dash Board Button
	public void clickGoToDashBoardBtn() {

		try {
			TestLog.log.info("Clicking on Go To Dash Board Button ");
			btnGoToDashboard.click();
			TestLog.log.info("Clicked on Go To Dash Board Button");

		} catch (Exception ex) {
			TestLog.log.info("Could not Click on Go To Dash Board Button. "
					+ ex);
		}

	}

}
