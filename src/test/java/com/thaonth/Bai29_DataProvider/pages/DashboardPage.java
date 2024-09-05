package com.thaonth.Bai29_DataProvider.pages;

import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    private By  btn_DashboardOptions = By.xpath("//div[normalize-space()='Dashboard Options']");
    private By  totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By  totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");
    private By  totalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");
    private By  totalTasksNotFinished  = By.xpath("(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span");
    private By  checkboxQuickStatistics = By.xpath("//input[@id='widget_option_top_stats']");
    private By  sectionQuickStatistics = By.xpath("//div[@id='widget-top_stats']");

    public void verifyCheckboxQuickStatistics(){
        WebUI.sleep(1);
        Assert.assertTrue(WebUI.getWebElement(checkboxQuickStatistics).isSelected(), "FAIL! Checkbox QuickStatistics is not checked");
        Assert.assertTrue(WebUI.elementIsDisplay(sectionQuickStatistics), "FAIL! Section Quick Statistics not display");
    }

    public void clickButtonDashboardOptions(){
        WebUI.waitForPageLoaded();
       WebUI.clickElement(btn_DashboardOptions);
    }

    public void checkTotalInvoicesAwaitingPayment(String expected_totalInvoicesAwaitingPayment){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(totalInvoicesAwaitingPayment), "The section Converted Leads is not display");
        Assert.assertEquals(WebUI.getElementText(totalInvoicesAwaitingPayment), expected_totalInvoicesAwaitingPayment, "FAIL! Total of Converted Leads is not equal");
    }

    public void checkTotalconvertedLeads(String expected_TotalConvertedLeads){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(totalConvertedLeads), "The section Invoices Awaiting Payment is not display");
        Assert.assertEquals(WebUI.getElementText(totalConvertedLeads), expected_TotalConvertedLeads, "FAIL! Total of Invoices Awaiting Payment is not equal");
    }

    public void checkTotalProjectesInProgess(String expected_totalProjectsInProgress){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(totalProjectsInProgress), "The section Projects In Progress is not display");
        Assert.assertEquals(WebUI.getElementText(totalProjectsInProgress), expected_totalProjectsInProgress, "FAIL! Total of Projects In Progress is not equal");
    }

    public void checkTotalTaskNotFinishes(String expected_totalTasksNotFinished){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(totalTasksNotFinished), "The section Task Not Finished is not display");
        Assert.assertEquals(WebUI.getElementText(totalTasksNotFinished), expected_totalTasksNotFinished, "FAIL! Total of Task Not Finished is not equal");
    }

    public void checkButtonDashboardOptions(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(btn_DashboardOptions), "Button Dashboard Options is not display");
    }
}
