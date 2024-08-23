package com.thaonth.PageObjectModel.testcases;

import com.thaonth.PageObjectModel.pages.*;
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

    public void testAddNewCustomer() {
        String CUSTOMER_NAME = "Customer 02";
        loginPage = new LoginPage();
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

    @Test
    public void deleteCustomer() {
        String CUSTOMER_NAME = "Customer 03";
        loginPage = new LoginPage();
        dashboardPage = loginPage.logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);

        customerPage = loginPage.clickMenuCustomer();
        int totalCustomersBefore = Integer.parseInt(customerPage.getTotalCustomer());
        System.out.println("Total Customer Before: " + totalCustomersBefore);
        customerPage.createNewCustomer(CUSTOMER_NAME);
        customerPage.deleteCustomer(CUSTOMER_NAME);
        System.out.println("Total Customer After: " + customerPage.getTotalCustomer());
        Assert.assertEquals(customerPage.getTotalCustomer(), String.valueOf(totalCustomersBefore - 1), "FAIL!! The total customer in Dashboard not match");
    }

    @Test
    public void editCustomer() {
        String CUSTOMER_NAME = "Customer 03";
        String NEW_CUSTOMER_NAME = "Customer 03 update";
        loginPage = new LoginPage();
        dashboardPage = loginPage.logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);

        customerPage = loginPage.clickMenuCustomer();
        customerPage.createNewCustomer(CUSTOMER_NAME);
        customerPage.editCustomer(CUSTOMER_NAME, NEW_CUSTOMER_NAME);
        customerPage.checkCustomerInTableList(NEW_CUSTOMER_NAME);
        customerPage.checkCustomerDetail(NEW_CUSTOMER_NAME);
        projectPage = customerPage.clickMenuProjects();
        projectPage.clickAddNewProject();
        projectPage.checkCustomerDisplayFieldOfProjectForm(NEW_CUSTOMER_NAME);
    }
}
