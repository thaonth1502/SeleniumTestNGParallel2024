package com.thaonth.Bai27_DemoReadConfigsProperties.testcases;

import com.thaonth.Bai27_DemoReadConfigsProperties.pages.LoginPage;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginSuccess(){
        loginPage = new LoginPage();
        loginPage.logInCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginFailWithEmailInvalid(){
        loginPage = new LoginPage();
        loginPage.logInCRM("email@example.com", ConfigData.PASSWORD);
        loginPage.verifyLoginFail("Invalid email or password");
    }

    @Test
    public void testLoginFailWithPasswordInvalid(){
        loginPage = new LoginPage();

        loginPage.logInCRM(ConfigData.EMAIL, "12345");
        loginPage.verifyLoginFail("Invalid email or password");
    }

    @Test
    public void testLoginFailWithEmailNull(){
        loginPage = new LoginPage();

        loginPage.logInCRM("", "123456");
        loginPage.verifyLoginFail("The Email Address field is required.");
    }

    @Test
    public void testLoginFailWithPasswordNull(){
        loginPage = new LoginPage();

        loginPage.logInCRM("admin@example.com", "");
        loginPage.verifyLoginFail("The Password field is required.");
    }
}
