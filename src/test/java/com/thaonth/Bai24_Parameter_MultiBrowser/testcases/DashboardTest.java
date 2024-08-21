package com.thaonth.Bai24_Parameter_MultiBrowser.testcases;

import com.thaonth.Bai24_Parameter_MultiBrowser.pages.DashboardPage;
import com.thaonth.Bai24_Parameter_MultiBrowser.pages.LoginPage;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test (priority = 2)
    public void checkTotalQuickStatisticsSection(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        dashboardPage.checkButtonDashboardOptions();
        dashboardPage.checkTotalInvoicesAwaitingPayment("4 / 5");
        dashboardPage.checkTotalconvertedLeads("0 / 0");
        dashboardPage.checkTotalProjectesInProgess("2 / 2");
        dashboardPage.checkTotalTaskNotFinishes("0 / 0");
    }

    @Test (priority = 1)
    public void checkQuickStatisticsSectionDisplay(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);

        dashboardPage.clickButtonDashboardOptions();
        dashboardPage.verifyCheckboxQuickStatistics();
    }

}
