package com.thaonth.Bai27_DemoReadConfigsProperties.testcases;

import com.thaonth.Bai27_DemoReadConfigsProperties.pages.LoginPage;
import com.thaonth.common.BaseTest;
import com.thaonth.drivers.DriverManager;
import com.thaonth.helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PropertiesTest extends BaseTest {

    private LoginPage loginPage;
    private WebDriver driver;
    @BeforeClass
    public void createDriver() {
        // Gọi hàm để khởi tạo file properties
        PropertiesHelper.loadAllFiles();

        // Đọc data từ file properties với key là "browser"
        driver =  setupDriver(PropertiesHelper.getValue("BROWSER"));
        DriverManager.setDriver(driver);
    }

    @Test
    public void signinCRM(){
        loginPage = new LoginPage();
        driver.get(PropertiesHelper.getValue("URL"));

        // Đọc data từ file properties
        loginPage.logInCRM(PropertiesHelper.getValue("EMAIL"),PropertiesHelper.getValue("PASSWORD"));

    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}

