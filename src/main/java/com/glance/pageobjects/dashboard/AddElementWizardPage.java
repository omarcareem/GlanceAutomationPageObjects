package com.glance.pageobjects.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.glance.pageobjects.common.BasePage;

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
	
}
