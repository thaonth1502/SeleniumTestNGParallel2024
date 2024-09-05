package com.thaonth.common;

import com.thaonth.Bai27_DemoReadConfigsProperties.pages.DashboardPage;
import com.thaonth.Bai27_DemoReadConfigsProperties.pages.LoginPage;
import com.thaonth.Bai27_DemoReadConfigsProperties.pages.ProjectPage;
import com.thaonth.Bai29_DataProvider.pages.CustomerPage;
import com.thaonth.constants.ConfigData;
import com.thaonth.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProjectPage projectPage;
    private CustomerPage customerPage;

    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browser) {
        if(ConfigData.BROWSER != null || !ConfigData.BROWSER.isEmpty()){
            driver =  setupDriver(ConfigData.BROWSER);
            DriverManager.setDriver(driver);
        }else {
            driver = setupDriver(browser);
            DriverManager.setDriver(driver);
        }
    }

    public CustomerPage getCustomerPage() {
        if (customerPage == null){
            customerPage = new CustomerPage();
        }
        return customerPage;
    }

    public ProjectPage getProjectPage() {
        if (projectPage == null){
            projectPage = new ProjectPage();
        }
        return projectPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null){
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public WebDriver setupDriver(String browserName) {

        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeDriver(){
        DriverManager.quit();
    }
}
