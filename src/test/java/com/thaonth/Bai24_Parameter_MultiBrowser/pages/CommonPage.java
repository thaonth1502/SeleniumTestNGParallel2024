package com.thaonth.Bai24_Parameter_MultiBrowser.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.thaonth.keywords.WebUI;

public class CommonPage {
    private WebDriver driver;

    public CommonPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    //Elements
    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuSales = By.xpath("//li[@class='menu-item-sales']");
    public By iconNotification = By.xpath("//a[contains(@class,'notifications-icon')]");

    public CustomerPage clickMenuCustomer(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuCustomers);
        return new CustomerPage(driver);
    }

    public DashboardPage clickMenuDashboard(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuDashboard);
        return new DashboardPage(driver);
    }

    public ProjectPage clickMenuProjects(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuProjects);
        return new ProjectPage(driver);
    }

}
