package com.thaonth.Bai27_DemoReadConfigsProperties.testcases;

import com.thaonth.Bai27_DemoReadConfigsProperties.pages.DashboardPage;
import com.thaonth.Bai27_DemoReadConfigsProperties.pages.LoginPage;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

   

    @Test (priority = 2)
    public void checkTotalQuickStatisticsSection(){
       
        getLoginPage().logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        getDashboardPage().checkButtonDashboardOptions();
        getDashboardPage().checkTotalInvoicesAwaitingPayment("4 / 5");
        getDashboardPage().checkTotalconvertedLeads("1 / 2");
        getDashboardPage().checkTotalProjectesInProgess("1 / 1");
        getDashboardPage().checkTotalTaskNotFinishes("7 / 8");
    }

    @Test (priority = 1)
    public void checkQuickStatisticsSectionDisplay(){
        
        getLoginPage().logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);

        getDashboardPage().clickButtonDashboardOptions();
        getDashboardPage().verifyCheckboxQuickStatistics();
    }

}
