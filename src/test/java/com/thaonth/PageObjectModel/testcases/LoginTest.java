package com.thaonth.PageObjectModel.testcases;

import com.thaonth.PageObjectModel.pages.LoginPage;
import com.thaonth.common.BaseTest;
import com.thaonth.constants.ConfigData;
import com.thaonth.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginSuccess(){
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/Login.xlsx","Sheet3");

        for (int i = 1; i <= 1; i++) {
            loginPage.logInCRM(
                    excelHelper.getCellData("EMAIL", i),
                    excelHelper.getCellData("PASSWORD", i)
            );
            loginPage.verifyLoginSuccess();
            loginPage.logout();
        }
        excelHelper.setCellData("Passed", "STATUS", 1);
    }

    @Test
    public void testLoginFailWithEmailInvalid(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/Login.xlsx","Sheet1");
        loginPage = new LoginPage();
        loginPage.logInCRM(
                excelHelper.getCellData("EMAIL", 2),
                excelHelper.getCellData("PASSWORD", 2));
        loginPage.verifyLoginFail("Invalid email or password");
        excelHelper.setCellData("Passed", "STATUS", 2);
    }

    @Test
    public void testLoginFailWithPasswordInvalid(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/Login.xlsx","Sheet1");
        loginPage = new LoginPage();

        loginPage.logInCRM(
                excelHelper.getCellData("EMAIL", 3),
                excelHelper.getCellData("PASSWORD", 3));
        loginPage.verifyLoginFail("Invalid email or password");
        excelHelper.setCellData("Passed", "STATUS", 3);
    }

    @Test
    public void testLoginFailWithEmailNull(){
        ExcelHelper excelHelper = new ExcelHelper();
        loginPage = new LoginPage();
        excelHelper.setExcelFile("src/test/resources/testData/Login.xlsx","Sheet1");

        loginPage.logInCRM(
                excelHelper.getCellData("EMAIL", 4),
                excelHelper.getCellData("PASSWORD", 4));
        loginPage.verifyLoginFail("The Email Address field is required.");
        excelHelper.setCellData("Passed", "STATUS", 4);
    }

    @Test
    public void testLoginFailWithPasswordNull(){
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/Login.xlsx","Sheet1");

        loginPage.logInCRM(
                excelHelper.getCellData("EMAIL", 5),
                excelHelper.getCellData("PASSWORD", 5));
        loginPage.verifyLoginFail("The Password field is required.");
        excelHelper.setCellData("Passed", "STATUS", 5);
    }
}
