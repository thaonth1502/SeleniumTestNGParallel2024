package com.thaonth.Bai29_DataProvider.testcases;

import com.thaonth.Bai29_DataProvider.pages.DashboardPage;
import com.thaonth.Bai29_DataProvider.pages.LoginPage;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {


    @Test (priority = 2)
    public void checkTotalQuickStatisticsSection(){
        getLoginPage().logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        getDashboardPage().checkButtonDashboardOptions();
        getDashboardPage().checkTotalInvoicesAwaitingPayment("4 / 5");
        getDashboardPage().checkTotalconvertedLeads("0 / 0");
        getDashboardPage().checkTotalProjectesInProgess("2 / 2");
        getDashboardPage().checkTotalTaskNotFinishes("0 / 0");
    }

    @Test (priority = 1)
    public void checkQuickStatisticsSectionDisplay(){

        getLoginPage().logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        getDashboardPage().clickButtonDashboardOptions();
        getDashboardPage().verifyCheckboxQuickStatistics();
    }

}
