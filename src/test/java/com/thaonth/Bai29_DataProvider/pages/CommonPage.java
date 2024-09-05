package com.thaonth.Bai29_DataProvider.pages;

import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;

public class CommonPage {

    //Elements
    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuSales = By.xpath("//li[@class='menu-item-sales']");
    public By iconNotification = By.xpath("//a[contains(@class,'notifications-icon')]");

    public CustomerPage clickMenuCustomer(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuCustomers);
        return new CustomerPage();
    }

    public DashboardPage clickMenuDashboard(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuDashboard);
        return new DashboardPage();
    }

    public ProjectPage clickMenuProjects(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuProjects);
        return new ProjectPage();
    }

}
