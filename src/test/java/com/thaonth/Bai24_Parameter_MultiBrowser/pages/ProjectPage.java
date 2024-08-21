package com.thaonth.Bai24_Parameter_MultiBrowser.pages;

import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProjectPage extends CommonPage {

    private WebDriver driver;

    public ProjectPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
       // new WebUI(driver);
    }

    By btnNewProject = By.xpath("//a[normalize-space()='New Project']");
    By selectCustomer = By.xpath("//button[@data-id='clientid']");
    By inputSearchCustomer = By.xpath("//button[@data-id='clientid']/following-sibling::div//input");
    By itemCustomer = By.xpath("//span[@class='text']");

    public void clickAddNewProject(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(btnNewProject);
    }

    public void checkCustomerDisplayFieldOfProjectForm(String customerName){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(selectCustomer);
        WebUI.sleep(1);
        WebUI.inputElement(inputSearchCustomer, customerName);
        WebUI.sleep(1);
        System.out.println("Custoerm Name: " + WebUI.getElementText(itemCustomer));
        Assert.assertEquals(WebUI.getElementText(itemCustomer), customerName, "FAIL!! Customer Name not display in Customer Field in Project Create new form");
    }
}


