package com.thaonth.Bai29_DataProvider.pages;

import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CustomerPage extends CommonPage {

    By btnAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    By headerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input[@placeholder ='Search...']");
    By firstItemCustomerName = By.xpath("//tbody/tr[1]/td[3]/a");
    By inputCompany = By.xpath("//input[@id='company']");
    By inpVat = By.xpath("//input[@id='vat']");
    By inputWebsite = By.xpath("//input[@id='website']");
    By inputPhone = By.xpath("//input[@id='phonenumber']");
    By dropdownGroup = By.xpath("//button[@data-id='groups_in[]']");
    By inputGroup = By.xpath("//button[@data-id='groups_in[]']/following-sibling::div//input");
    By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    By inputCurrency = By.xpath("//button[@data-id='default_currency']/following-sibling::div//input");
    By selectDefaultLanguage = By.xpath("//button[@data-id='default_language']");
    By inputCity = By.xpath("//input[@id='city']");
    By inputStage = By.xpath("//input[@id='state']");
    By inputCode = By.xpath("//input[@id='zip']");
    By dropdownCountry = By.xpath("//button[@data-id='country']");
    By inputCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input");
    By btnSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");
    By alertMessage = By.xpath("//span[@class='alert-title']");
    By totalCustomer = By.xpath("//span[normalize-space() = 'Total Customers']/preceding-sibling::span");


    //Ham xư ly cho Customer Page
    public String getTotalCustomer(){
        WebUI.waitForPageLoaded();
        return WebUI.getElementText(totalCustomer);
    }

    public void clickAddNewButton(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(btnAddNewCustomer);

    }
    public void clickSaveButton(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(btnSave);
        WebUI.sleep(2);
        //Verify alert Message
        Assert.assertTrue(WebUI.elementIsDisplay(alertMessage),"FAIL!!! Alert Message not display");
        Assert.assertEquals(WebUI.getElementText(alertMessage), "Customer added successfully.", "FAIL!!! Content alert message not match");
    }

    public void inputDataAddNewCustomerForm(String customerName){
        WebUI.inputElement(inputCompany, customerName);
        WebUI.inputElement(inpVat, "10");
        WebUI.inputElement(inputWebsite, "htts://anhtester.com");
        WebUI.inputElement(inputPhone, "023456789");
        WebUI.clickElement(dropdownGroup);
        WebUI.sleep(1);
        WebUI.inputElement(inputGroup, "VIP");
        WebUI.setKeys(inputGroup, Keys.ENTER);
        WebUI.clickElement(dropdownGroup);
        WebUI.sleep(1);
        WebUI.clickElement(dropdownCurrency);
        WebUI.inputElement(inputCurrency, "USD");
        WebUI.sleep(1);
        WebUI.setKeys(inputCurrency, Keys.ENTER);
        WebUI.clickElement(dropdownCurrency);
        selectLanguage("Vietnamese");
        WebUI.inputElement(inputCity, "Hanoi");
        WebUI.inputElement(inputStage, "Caugiay");
        WebUI.inputElement(inputCode, "100000");
        WebUI.clickElement(dropdownCountry);
        WebUI.sleep(1);
        WebUI.inputElement(inputCountry, "Vietnam");
        WebUI.sleep(1);
        WebUI.setKeys(inputCountry, Keys.ENTER);
    }

    public void selectLanguage(String language){
       // WebUI.clickElement(selectDefaultLanguage);
        WebUI.clickElement(selectDefaultLanguage);
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath("//span[normalize-space()='"+language+"']"));
        WebUI.sleep(1);

    }

    public void checkCustomerInTableList(String customerName){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuCustomers);
        WebUI.waitForPageLoaded();
        WebUI.inputElement(inputSearchCustomer, customerName);
        WebUI.sleep(1);

        //Check customer name display in table
        Assert.assertTrue(WebUI.elementIsDisplay(firstItemCustomerName), "FAIL!! Customer Name is display");
        WebUI.assertEquals(WebUI.getElementText(firstItemCustomerName),customerName, "FAIL!!! Customer name not match.");
    }
    public void checkCustomerDetail(String customerName){
        //Check customer detail in customer page
        WebUI.clickElement(firstItemCustomerName);
        WebUI.assertEquals(WebUI.getElementAttribute(inputCompany, "value"),customerName, "FAIL!!! The Customer Name not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inpVat, "value"),"10", "FAIL!!! The VAT not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inputWebsite,"value"),"htts://anhtester.com", "FAIL!!! The website not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inputPhone,"value"),"023456789", "FAIL!!! The Phone number not match");
        WebUI.assertEquals(WebUI.getElementAttribute(dropdownGroup,"title"),"VIP", "FAIL!!! The Group not match");
        WebUI.assertEquals(WebUI.getElementAttribute(dropdownCurrency,"title"),"USD", "FAIL!!! The Currency not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inputCity,"value"),"Hanoi" , "FAIL!!! The city not match");
        WebUI.assertEquals(WebUI.getElementAttribute(inputStage,"value"),"Caugiay" , "FAIL!!! The Stage not match");
        WebUI.assertEquals(WebUI.getElementAttribute(selectDefaultLanguage,"title"),"Vietnamese", "FAIL!!! The Language not match");
    }
}
