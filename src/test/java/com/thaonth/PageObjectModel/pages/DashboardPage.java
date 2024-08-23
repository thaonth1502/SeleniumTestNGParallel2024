package com.thaonth.PageObjectModel.pages;

import com.thaonth.drivers.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static com.thaonth.keywords.WebUI.*;

public class DashboardPage extends CommonPage {

    private By  btn_DashboardOptions = By.xpath("//div[normalize-space()='Dashboard Options']");
    private By  totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By  totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");
    private By  totalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");
    private By  totalTasksNotFinished  = By.xpath("(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span");
    private By  checkboxQuickStatistics = By.xpath("//input[@id='widget_option_top_stats']");
    private By  sectionQuickStatistics = By.xpath("//div[@id='widget-top_stats']");

    public void verifyCheckboxQuickStatistics(){
        sleep(1);
        Assert.assertTrue(DriverManager.getDriver().findElement(checkboxQuickStatistics).isSelected(), "FAIL! Checkbox QuickStatistics is not checked");
        Assert.assertTrue(DriverManager.getDriver().findElement(sectionQuickStatistics).isDisplayed(), "FAIL! Section Quick Statistics not display");
    }

    public void clickButtonDashboardOptions(){
        waitForPageLoaded();
        checkElementExist(btn_DashboardOptions);
        clickElement(btn_DashboardOptions);
    }

    public void checkTotalInvoicesAwaitingPayment(String expected_totalInvoicesAwaitingPayment){
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist(totalInvoicesAwaitingPayment), "The section Converted Leads is not display");
        Assert.assertEquals(DriverManager.getDriver().findElement(totalInvoicesAwaitingPayment).getText(), expected_totalInvoicesAwaitingPayment, "FAIL! Total of Converted Leads is not equal");
    }

    public void checkTotalconvertedLeads(String expected_TotalConvertedLeads){
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist( totalConvertedLeads), "The section Invoices Awaiting Payment is not display");
        Assert.assertEquals(DriverManager.getDriver().findElement(totalConvertedLeads).getText(), expected_TotalConvertedLeads, "FAIL! Total of Invoices Awaiting Payment is not equal");
    }

    public void checkTotalProjectesInProgess(String expected_totalProjectsInProgress){
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist( totalProjectsInProgress), "The section Projects In Progress is not display");
        Assert.assertEquals(DriverManager.getDriver().findElement(totalProjectsInProgress).getText(), expected_totalProjectsInProgress, "FAIL! Total of Projects In Progress is not equal");
    }

    public void checkTotalTaskNotFinishes(String expected_totalTasksNotFinished){
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist(totalTasksNotFinished), "The section Task Not Finished is not display");
        Assert.assertEquals(DriverManager.getDriver().findElement(totalTasksNotFinished).getText(), expected_totalTasksNotFinished, "FAIL! Total of Task Not Finished is not equal");
    }

    public void checkButtonDashboardOptions(){
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist(btn_DashboardOptions), "Button Dashboard Options is not display");
    }
}
