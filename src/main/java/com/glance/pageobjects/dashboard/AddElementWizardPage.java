package com.glance.pageobjects.dashboard;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class AddElementWizardPage extends BasePage {

	public AddElementWizardPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "metric_type")
	WebElement drpMetric;

	@FindBy(id = "ele_str_title")
	WebElement txtTitle;

	@FindBy(id = "ele_str_footer")
	WebElement txtFooter;

	@FindBy(id = "ele_str_description")
	WebElement txtDescription;

	@FindBy(xpath = "//input[@name='ele_str_multi_series']/../ins")
	WebElement checkBoxMultiSeries;

	@FindBy(xpath = "//input[@name='ele_str_multi_charts']/../ins")
	WebElement checkBoxMultiCharts;

	@FindBy(id = "ele_tbl_data")
	WebElement drpDataTable;

	@FindBy(id = "ele_fld_label")
	WebElement drpLabelColumnX;

	@FindBy(id = "ele_fld_data_series")
	WebElement drpDataSeriesField;

	@FindBy(id = "ele_fld_chart_series")
	WebElement drpChartSeriesField;

	@FindBy(id = "ele_fld_data")
	WebElement drpDataFieldY;

	@FindBy(id = "screen")
	WebElement drpScreen;

	@FindBy(id = "ele_str_class")
	WebElement txtBootstrapClass;

	@FindBy(id = "width")
	WebElement drpMakeThisWidth;

	@FindBy(id = "ele_str_color")
	WebElement txtColor;

	@FindBy(name = "ele_str_tools")
	WebElement checkBoxShowToolBar;

	@FindBy(name = "ele_str_legend")
	WebElement checkBoxShowLegend;

	@FindBy(xpath = "//div/a[contains(text(), 'Save')]")
	WebElement btnSave;

	@FindBy(xpath = "//a[text()='Next']")
	WebElement btnNext;

	@FindBy(xpath = "//a[text()='Previous']")
	WebElement btnPrevious;

	@FindBy(xpath = "//ul[@class='wizard_steps anchor']/li[1]/a/span[1]")
	WebElement linkAddElementWizardStep1;

	@FindBy(xpath = "//ul[@class='wizard_steps anchor']/li[2]/a/span[1]")
	WebElement linkAddElementWizardStep2;

	@FindBy(xpath = "//ul[@class='wizard_steps anchor']/li[3]/a/span[1]")
	WebElement linkAddElementWizardStep3;

	@FindBy(xpath = "//li/a[@id='close_wizard']/i")
	WebElement linkCloseWizard;

	@FindBy(xpath = "//div[@class='x_title']/h2")
	WebElement titleElementWizard;

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public String getElementWizardPageTitle() {

		String elementWizardPageTitle = null;
		try {
			TestLog.log.info("Reading the title");
			elementWizardPageTitle = titleElementWizard.getText();
			TestLog.log.info("The title is: " + elementWizardPageTitle);
		} catch (Exception ex) {
			TestLog.log.info("Could not read the title due to: " + ex);
		}

		return elementWizardPageTitle;
	}

	public boolean getElementWizardPageTitle(String elementWizardPageTitle) {

		// String elementWizardPageTitle=null;
		try {
			TestLog.log.info("Reading the title");
			elementWizardPageTitle = titleElementWizard.getText();
			TestLog.log.info("The title is: " + elementWizardPageTitle);
			System.out.println(elementWizardPageTitle);
		} catch (Exception ex) {
			TestLog.log.info("Could not read the title due to: " + ex);
		}

		return true;
	}

	public void selectMetric(String metric) {
		try {
			Select dropSelectMetric = new Select(drpMetric);
			wait.until(ExpectedConditions.visibilityOf(drpMetric));
			TestLog.log.info("Selecting a metric value");
			dropSelectMetric.selectByVisibleText(metric);
			TestLog.log.info("Selected " + metric + " from the drop down");
		} catch (Exception ex) {
			TestLog.log.info("Unable to select a value from the metric drop down. Due to: " + ex);
		}
	}

	public void enterMetricTitle(String metricTitle) {
		try {
			wait.until(ExpectedConditions.visibilityOf(txtTitle));
			TestLog.log.info("Entering a metric title");
			txtTitle.clear();
			txtTitle.sendKeys(metricTitle);
			TestLog.log.info("Entered the " + metricTitle + " title");
		} catch (Exception ex) {
			TestLog.log.info("Unable to enter the title. Due to: " + ex);
		}
	}

	public void enterFooter(String footer) {
		try {
			TestLog.log.info("Entering footer");
			wait.until(ExpectedConditions.visibilityOf(txtFooter));
			txtFooter.clear();
			txtFooter.sendKeys(footer);
			TestLog.log.info("Entered the " + footer);
		} catch (Exception ex) {
			TestLog.log.info("Unable to enter the footer. Due to: " + ex);
		}
	}

	public void enterDescription(String description) {
		try {
			TestLog.log.info("Entering description");
			wait.until(ExpectedConditions.visibilityOf(txtDescription));
			txtDescription.clear();
			txtDescription.sendKeys(description);
			TestLog.log.info("Entered the " + description);
		} catch (Exception ex) {
			TestLog.log.info("Unable to enter the description. Due to: " + ex);
		}
	}

	public void clickNextButton() {
		try {
			TestLog.log.info("Clicking on Next button");
			wait.until(ExpectedConditions.visibilityOf(btnNext));
			btnNext.click();
			TestLog.log.info("Clicked on Next button");
		} catch (Exception ex) {
			TestLog.log.info("Unable to enter click the next button. Due to: " + ex);
		}
	}

	public void clickPreviousButton() {
		try {
			TestLog.log.info("Clicking on Previous button");
			wait.until(ExpectedConditions.visibilityOf(btnPrevious));
			btnPrevious.click();
			TestLog.log.info("Clicked on Previous button");
		} catch (Exception ex) {
			TestLog.log.info("Unable to click the previous button. Due to: " + ex);
		}
	}

	public void selectMutiSeriesCheck() {

		try {
			TestLog.log.info("Clicking on multi series checkbox");
			wait.until(ExpectedConditions.visibilityOf(checkBoxMultiSeries));
			checkBoxMultiSeries.click();
			TestLog.log.info("Clicked on multi series checkbox");
		} catch (Exception ex) {
			TestLog.log.info("Unable to Select the multi series checkbox. Due to: " + ex);
		}
	}

	public void selectMutiChartsCheck() {

		try {
			TestLog.log.info("Clicking on multi charts checkbox");
			wait.until(ExpectedConditions.visibilityOf(checkBoxMultiCharts));
			checkBoxMultiCharts.click();
			TestLog.log.info("Clicked on multi charts checkbox");
		} catch (Exception ex) {
			TestLog.log.info("Unable to Select the multi charts checkbox. Due to: " + ex);
		}
	}

	public void selectDataTable(String dataTable) {

		try {
			wait.until(ExpectedConditions.visibilityOf(drpDataTable));
			Select dropSelectDatatable = new Select(drpDataTable);
			TestLog.log.info("Selecting a data table value");
			dropSelectDatatable.selectByVisibleText(dataTable);
			TestLog.log.info("Selected " + dataTable + " from the drop down");
		} catch (Exception ex) {
			TestLog.log.info("Unable to Select a data table. Due to: " + ex);
		}

	}

	public void selectDataSeriesField(String dataSeriesField) {
		try {
			wait.until(ExpectedConditions.visibilityOf(drpDataSeriesField));
			Select dropSelectDataSeries = new Select(drpDataSeriesField);
			TestLog.log.info("Selecting a data series value");
			dropSelectDataSeries.selectByVisibleText(dataSeriesField);
			TestLog.log.info("Selected " + dataSeriesField + " from the drop down");
		} catch (Exception ex) {
			TestLog.log.info("Unable to Select a data Series Field. Due to: " + ex);
		}
	}

	public void selectChartSeriesField(String chartSeriesField) {
		try {
			wait.until(ExpectedConditions.visibilityOf(drpChartSeriesField));
			Select dropSelectChartSeries = new Select(drpChartSeriesField);
			TestLog.log.info("Selecting a chart series value");
			dropSelectChartSeries.selectByVisibleText(chartSeriesField);
			TestLog.log.info("Selected " + chartSeriesField + " from the drop down");
		} catch (Exception ex) {
			TestLog.log.info("Unable to Select a chart Series Field. Due to: " + ex);
		}
	}

	public void selectLabelColumn(String labelColumn) {

		try {
			wait.until(ExpectedConditions.visibilityOf(drpLabelColumnX));
			Select dropLabelColumnX = new Select(drpLabelColumnX);
			TestLog.log.info("Selecting a label column X value");
			dropLabelColumnX.selectByVisibleText(labelColumn);
			TestLog.log.info("Selected " + labelColumn + " from the drop down");
		} catch (Exception ex) {
			TestLog.log.info("Unable to Select a label column. Due to: " + ex);
		}
	}

	public void selectDataField(String dataField) {

		try {
			wait.until(ExpectedConditions.visibilityOf(drpDataFieldY));
			Select dropDataFieldY = new Select(drpDataFieldY);
			TestLog.log.info("Selecting a data field value");
			dropDataFieldY.selectByVisibleText(dataField);
			TestLog.log.info("Selected " + dataField + " from the drop down");
		} catch (Exception ex) {
			TestLog.log.info("Unable to Select a data field. Due to: " + ex);
		}
	}

	public void selectWhenScreen(String whenScreen) {

		try {
			wait.until(ExpectedConditions.visibilityOf(drpScreen));
			Select dropWhenScreen = new Select(drpScreen);
			TestLog.log.info("Selecting a when screen value");
			dropWhenScreen.selectByVisibleText(whenScreen);
			TestLog.log.info("Selected " + whenScreen + " from the drop down");
		} catch (Exception ex) {
			TestLog.log.info("Unable to Select a when screen. Due to: " + ex);
		}
	}

	public void saveNewElement() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSave));
			TestLog.log.info("Saving the new element");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", btnSave);
			// btnSave.click();
			TestLog.log.info("Saved the new element");
		} catch (Exception ex) {
			TestLog.log.info("Unable to save the new element. Due to: " + ex);
		}
	}
}
