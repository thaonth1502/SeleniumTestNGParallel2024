package com.thaonth.PageObjectModel.pages;

import static com.thaonth.keywords.WebUI.*;
import org.openqa.selenium.By;

import org.testng.Assert;

public class ProjectPage extends CommonPage {

    By btnNewProject = By.xpath("//a[normalize-space()='New Project']");
    By selectCustomer = By.xpath("//button[@data-id='clientid']");
    By inputSearchCustomer = By.xpath("//button[@data-id='clientid']/following-sibling::div//input");
    By itemCustomer = By.xpath("//span[@class='text']");

    public void clickAddNewProject(){
        waitForPageLoaded();
        clickElement(btnNewProject);
    }

    public void checkCustomerDisplayFieldOfProjectForm(String customerName){
        waitForPageLoaded();
        clickElement(selectCustomer);
        sleep(1);
        inputElement(inputSearchCustomer, customerName);
        sleep(1);
        System.out.println("Custoerm Name: " + getElementText(itemCustomer));
        Assert.assertEquals(getElementText(itemCustomer), customerName, "FAIL!! Customer Name not display in Customer Field in Project Create new form");
    }
}


