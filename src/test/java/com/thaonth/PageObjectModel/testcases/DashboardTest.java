package com.thaonth.PageObjectModel.testcases;

import com.thaonth.PageObjectModel.pages.DashboardPage;
import com.thaonth.PageObjectModel.pages.LoginPage;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test (priority = 2)
    public void checkTotalQuickStatisticsSection(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        dashboardPage.checkButtonDashboardOptions();
        dashboardPage.checkTotalInvoicesAwaitingPayment("4 / 5");
        dashboardPage.checkTotalconvertedLeads("1 / 2");
        dashboardPage.checkTotalProjectesInProgess("2 / 2");
        dashboardPage.checkTotalTaskNotFinishes("2 / 3");
    }

    @Test (priority = 1)
    public void checkQuickStatisticsSectionDisplay(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage.clickButtonDashboardOptions();
        dashboardPage.verifyCheckboxQuickStatistics();
    }

}
