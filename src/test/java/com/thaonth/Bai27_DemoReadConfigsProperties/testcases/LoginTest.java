package com.thaonth.Bai27_DemoReadConfigsProperties.testcases;

import com.thaonth.Bai27_DemoReadConfigsProperties.pages.LoginPage;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginSuccess(){
        getLoginPage().logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
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
