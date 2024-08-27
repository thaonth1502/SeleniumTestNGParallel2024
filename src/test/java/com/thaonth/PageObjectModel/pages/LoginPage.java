package com.thaonth.PageObjectModel.pages;

import com.thaonth.constants.ConfigData;

import com.thaonth.drivers.DriverManager;
import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.thaonth.keywords.WebUI.*;

public class LoginPage extends CommonPage {

    //Khai báo các element dạng đối tượng By ( phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By btnLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class,'alert alert-danger')]");

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By dropdownProfile = By.xpath("//li[contains(@class,'user-profile')]");
    private By menuLogut = By.xpath("//a[text()='Logout']");

    //Khai báo các hàm xử lý thuộc trang Login

    public void enterEmail(String email){
        inputElement(inputEmail, email);
    }

    public void enterPassword(String password){
        inputElement(inputPassword, password);
    }

    public void clickLoginButton(){
        clickElement(btnLogin);
    }

    public DashboardPage logInCRM(String email, String password){
        openURL(ConfigData.URL);
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        return new DashboardPage();
    }

    public void verifyLoginSuccess(){
        waitForPageLoaded();
        Assert.assertTrue(elementIsDisplay(menuDashboard), "\uD83D\uDC1E FAIL, Can not redirect to Dashboard page");
        assertEquals(DriverManager.getDriver().getCurrentUrl(), "https://crm.anhtester.com/admin/", " \uD83D\uDC1E FAIL, The current URL is not matching");
    }

    public void verifyLoginFail(String expectedMessage){
        waitForPageLoaded();
        Assert.assertTrue(elementIsDisplay(errorMessage), "\uD83D\uDC1E FAIL, The error message not display");
        assertEquals(getElementText(errorMessage), expectedMessage, "\uD83D\uDC1E FAIL, The content of error message is not matching" );
    }

    public void logout(){
        clickElement(dropdownProfile);
        clickElement(menuLogut);
    }
}
