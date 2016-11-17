package com.glance.pageobjects.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.glance.pageobjects.common.BasePage;
import com.glance.pageobjects.logs.TestLog;

public class AddElementWizardPage extends BasePage{

	public AddElementWizardPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="metric_type")
	WebElement drpMetric;
	
	@FindBy(id="ele_str_title")
	WebElement txtTitle;
	
	@FindBy(id="ele_str_footer")
	WebElement txtFooter;
	
	@FindBy(id="ele_str_description")
	WebElement txtDescription;
	
	@FindBy(name="ele_str_multi_series")
	WebElement checkBoxMultiSeries;
	
	@FindBy(name="ele_str_multi_charts")
	WebElement checkBoxMultiCharts;
	
	@FindBy(id="ele_tbl_data")
	WebElement drpDataTable;
	
	@FindBy(id="ele_fld_label")
	WebElement drpLabelColumnX;
	
	@FindBy(id="ele_fld_data_series")
	WebElement drpDataSeriesField;
	
	@FindBy(id="ele_fld_chart_series")
	WebElement drpChartSeriesField;
	
	@FindBy(id="ele_fld_data")
	WebElement drpDataFieldY;
	
	@FindBy(id="screen")
	WebElement drpScreen;
	
	@FindBy(id="ele_str_class")
	WebElement txtBootstrapClass;
	
	@FindBy(id="width")
	WebElement drpMakeThisWidth;
	
	@FindBy(id="ele_str_color")
	WebElement txtColor;
	
	@FindBy(name="ele_str_tools")
	WebElement checkBoxShowToolBar;
	
	@FindBy(name="ele_str_legend")
	WebElement checkBoxShowLegend;
	
	@FindBy(xpath="//a[text()='Save']")
	WebElement btnSave;
	
	@FindBy(xpath="//a[text()='Next']")
	WebElement btnNext;
	
	@FindBy(xpath="//a[text()='Previous']")
	WebElement btnPrevious;
	
	@FindBy(xpath="//ul[@class='wizard_steps anchor']/li[1]/a/span[1]")
	WebElement linkAddElementWizardStep1;
	
	@FindBy(xpath="//ul[@class='wizard_steps anchor']/li[2]/a/span[1]")
	WebElement linkAddElementWizardStep2;
	
	@FindBy(xpath="//ul[@class='wizard_steps anchor']/li[3]/a/span[1]")
	WebElement linkAddElementWizardStep3;
	
	@FindBy(xpath="//li/a[@id='close_wizard']/i")
	WebElement linkCloseWizard;
	
	@FindBy(xpath="//div[@class='x_title']/h2")
	WebElement titleElementWizard;
	
	
	public String getElementWizardPageTitle(){
		
		String elementWizardPageTitle=null;
		try{
			TestLog.log.info("Reading the title");
			elementWizardPageTitle=titleElementWizard.getText();
			TestLog.log.info("The title is: "+elementWizardPageTitle);
		}catch(Exception ex){
			TestLog.log.info("Could not read the title due to: "+ex);
		}
		
		return elementWizardPageTitle;
	}
	
	public void selectMetric(String metric){
		try{
			Select dropSelectMetric = new Select(drpMetric);
			TestLog.log.info("Selecting a metric value");
			dropSelectMetric.selectByVisibleText(metric);
			TestLog.log.info("Selected "+metric+" from the drop down");
		}catch(Exception ex){
			TestLog.log.info("Unable to select a value from the metric drop down. Due to: "+ex);
		}		
	}
	
	public void enterMetricTitle(String metricTitle){
		try{
			TestLog.log.info("Entering a metric title");
			txtTitle.clear();
			txtTitle.sendKeys(metricTitle);
			TestLog.log.info("Entered the "+ metricTitle+" title");
		}catch(Exception ex){
			TestLog.log.info("Unable to enter the title. Due to: "+ex);
		}
	}
	
	public void enterFooter(String footer){
		try{
			TestLog.log.info("Entering footer");
			txtFooter.clear();
			txtFooter.sendKeys(footer);
			TestLog.log.info("Entered the "+ footer);
		}catch(Exception ex){
			TestLog.log.info("Unable to enter the footer. Due to: "+ex);
		}
	}
		
	
	
}
