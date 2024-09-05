package com.thaonth.Bai29_DataProvider.testcases;

import com.thaonth.Bai29_DataProvider.pages.LoginPage;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import com.thaonth.dataproviders.DataProviderFactory;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Hashtable;

public class LoginTest extends BaseTest {

    @Test (dataProvider = "data_provider_login", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String email, String password){
        getLoginPage().logInCRM(email, password);
        getLoginPage().verifyLoginSuccess();
    }

    @Test (dataProvider = "data_provider_login_excel", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccessFromDataProviderExcel(String email, String password){
        getLoginPage().logInCRM(email, password);
        getLoginPage().verifyLoginSuccess();
    }

    @Test(priority = 1, dataProvider = "data_provider_login_excel_hashtable", dataProviderClass = DataProviderFactory.class)
    public void testLoginFromDataProviderExcelHashtable(Hashtable< String, String > data) {
        getLoginPage().logInCRM(data.get("EMAIL"), data.get("PASSWORD"));
        getLoginPage().verifyLoginSuccess();
    }


    @Test
    public void testLoginFailWithEmailInvalid(){

        getLoginPage().logInCRM("email@example.com", ConfigData.PASSWORD);
        getLoginPage().verifyLoginFail("Invalid email or password");
    }

    @Test
    public void testLoginFailWithPasswordInvalid(){
        getLoginPage().logInCRM(ConfigData.EMAIL, "12345");
        getLoginPage().verifyLoginFail("Invalid email or password");
    }

    @Test
    public void testLoginFailWithEmailNull(){

        getLoginPage().logInCRM("", "123456");
        getLoginPage().verifyLoginFail("The Email Address field is required.");
    }

    @Test
    public void testLoginFailWithPasswordNull(){

        getLoginPage().logInCRM("admin@example.com", "");
        getLoginPage().verifyLoginFail("The Password field is required.");
    }
}
