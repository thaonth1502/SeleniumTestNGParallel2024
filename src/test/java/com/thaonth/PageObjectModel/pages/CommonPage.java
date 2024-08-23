package com.thaonth.PageObjectModel.pages;

import org.openqa.selenium.By;
import com.thaonth.keywords.WebUI;

import static com.thaonth.keywords.WebUI.*;

public class CommonPage {

    //Elements
    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuSales = By.xpath("//li[@class='menu-item-sales']");
    public By iconNotification = By.xpath("//a[contains(@class,'notifications-icon')]");

    public CustomerPage clickMenuCustomer(){
        WebUI.waitForPageLoaded();
        clickElement(menuCustomers);
        return new CustomerPage();
    }

    public DashboardPage clickMenuDashboard(){
        waitForPageLoaded();
        clickElement(menuDashboard);
        return new DashboardPage();
    }

    public ProjectPage clickMenuProjects(){
        waitForPageLoaded();
        clickElement(menuProjects);
        return new ProjectPage();
    }

}
