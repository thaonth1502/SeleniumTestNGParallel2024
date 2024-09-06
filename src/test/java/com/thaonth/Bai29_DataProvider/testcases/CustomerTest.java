package com.thaonth.Bai29_DataProvider.testcases;

import com.thaonth.Bai29_DataProvider.pages.*;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import com.thaonth.helpers.ExcelHelper;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    @Test
    @Parameters({"customerName"})
    public void testAddNewCustomer(String customerName){
        String CUSTOMER_NAME = customerName;
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/DataExcel.xlsx","LoginDataProvider");

        //Get simple data from Excel
        getLoginPage().logInCRM(excelHelper.getCellData("EMAIL", 1), excelHelper.getCellData("PASSWORD", 1));
        getLoginPage().clickMenuCustomer();

        int totalCustomersBefore = Integer.parseInt(getCustomerPage().getTotalCustomer());
        System.out.println("Total Customer Before: " + totalCustomersBefore);
        getCustomerPage().addNewCustomerSuccess();
        getCustomerPage().checkCustomerInTableList(CUSTOMER_NAME);
        System.out.println("Total Customer After: " + getCustomerPage().getTotalCustomer());
        Assert.assertEquals(getCustomerPage().getTotalCustomer(), String.valueOf(totalCustomersBefore + 1), "FAIL!! The total customer in Dashboard not match");
        getCustomerPage().checkCustomerDetail(CUSTOMER_NAME);
        getCustomerPage().clickMenuProjects();
        getProjectPage().clickAddNewProject();
        getProjectPage().checkCustomerDisplayFieldOfProjectForm(CUSTOMER_NAME);
    }
}
