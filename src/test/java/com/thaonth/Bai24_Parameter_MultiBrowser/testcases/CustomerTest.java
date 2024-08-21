package com.thaonth.Bai24_Parameter_MultiBrowser.testcases;

import com.thaonth.Bai24_Parameter_MultiBrowser.pages.*;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    CommonPage commonPage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProjectPage projectPage;

    @Test
    @Parameters({"customerName"})
    public void testAddNewCustomer(String customerName){
        String CUSTOMER_NAME = customerName;
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);

        customerPage = loginPage.clickMenuCustomer();
        int totalCustomersBefore = Integer.parseInt(customerPage.getTotalCustomer());
        System.out.println("Total Customer Before: " + totalCustomersBefore);
        customerPage.clickAddNewButton();
        customerPage.inputDataAddNewCustomerForm(CUSTOMER_NAME);
        customerPage.clickSaveButton();
        customerPage.checkCustomerInTableList(CUSTOMER_NAME);
        System.out.println("Total Customer After: " + customerPage.getTotalCustomer());
        Assert.assertEquals(customerPage.getTotalCustomer(), String.valueOf(totalCustomersBefore + 1), "FAIL!! The total customer in Dashboard not match");
        customerPage.checkCustomerDetail(CUSTOMER_NAME);
        projectPage = customerPage.clickMenuProjects();
        projectPage.clickAddNewProject();
        projectPage.checkCustomerDisplayFieldOfProjectForm(CUSTOMER_NAME);
    }
}
