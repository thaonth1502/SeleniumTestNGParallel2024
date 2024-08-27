package com.thaonth.Bai27_DemoReadConfigsProperties.pages;

import com.thaonth.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static com.thaonth.keywords.WebUI.*;


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
    By linkDeleteCustomer = By.xpath("(//tbody/tr[1]/td[3]/a)/following-sibling::div/a[normalize-space()='Delete']");
    By btnSaveEditForm = By.xpath("(//div[@class='panel-body']/following-sibling::div)/button");


    //Ham xư ly cho Customer Page
    public String getTotalCustomer(){
       waitForPageLoaded();
        return getElementText(totalCustomer);
    }

    public void clickAddNewButton(){
        waitForPageLoaded();
        clickElement(btnAddNewCustomer);

    }
    public void clickSaveButton(){
        waitForPageLoaded();
        clickElement(btnSave);
        sleep(2);
        //Verify alert Message
        Assert.assertTrue(elementIsDisplay(alertMessage),"FAIL!!! Alert Message not display");
        Assert.assertEquals(getElementText(alertMessage), "Customer added successfully.", "FAIL!!! Content alert message not match");
    }

    public void createNewCustomer(String customerName){
        clickAddNewButton();
        inputDataAddNewCustomerForm(customerName);
        clickSaveButton();
    }

    public void inputDataAddNewCustomerForm(String customerName){
       inputElement(inputCompany, customerName);
       inputElement(inpVat, "10");
       inputElement(inputWebsite, "htts://anhtester.com");
       inputElement(inputPhone, "023456789");
       clickElement(dropdownGroup);
       sleep(1);
       inputElement(inputGroup, "VIP");
       setKeys(inputGroup, Keys.ENTER);
       clickElement(dropdownGroup);
       sleep(1);
       clickElement(dropdownCurrency);
       inputElement(inputCurrency, "USD");
        sleep(1);
        setKeys(inputCurrency, Keys.ENTER);
        clickElement(dropdownCurrency);
        selectLanguage("Vietnamese");
        inputElement(inputCity, "Hanoi");
        inputElement(inputStage, "Caugiay");
        inputElement(inputCode, "100000");
        clickElement(dropdownCountry);
        sleep(1);
        inputElement(inputCountry, "Vietnam");
        sleep(1);
        setKeys(inputCountry, Keys.ENTER);
    }

    public void selectLanguage(String language){
       // WebUI.clickElement(selectDefaultLanguage);
        clickElement(selectDefaultLanguage);
        sleep(1);
        clickElement(By.xpath("//span[normalize-space()='"+language+"']"));
        sleep(1);

    }

    public void clearDateInCustomerForm(){
        clearText(inputCompany);
        clearText(inpVat);
        clearText(inputWebsite);
        clearText(inputPhone);
        clearText(inputCity);
        clearText(inputStage);
        clearText(inputCode);
    }

    public void editCustomer(String customerName, String newCustomerName){
        waitForPageLoaded();
        clickElement(menuCustomers);
        waitForPageLoaded();
        inputElement(inputSearchCustomer, customerName);
        sleep(1);
        clickElement(firstItemCustomerName);
        clearDateInCustomerForm();
        inputDataAddNewCustomerForm(newCustomerName);
        clickElement(btnSaveEditForm);
    }

    public void checkCustomerInTableList(String customerName){
        waitForPageLoaded();
        clickElement(menuCustomers);
        waitForPageLoaded();
        inputElement(inputSearchCustomer, customerName);
        sleep(1);

        //Check customer name display in table
        Assert.assertTrue(elementIsDisplay(firstItemCustomerName), "FAIL!! Customer Name is display");
        Assert.assertEquals(getElementText(firstItemCustomerName),customerName, "FAIL!!! Customer name not match.");
    }
    public void checkCustomerDetail(String customerName){
        //Check customer detail in customer page
        clickElement(firstItemCustomerName);
        Assert.assertEquals(getElementAttribute(inputCompany,"value" ),customerName, "FAIL!!! The Customer Name not match");
        Assert.assertEquals(getElementAttribute(inpVat,"value"),"10", "FAIL!!! The VAT not match");
        Assert.assertEquals(getElementAttribute(inputWebsite,"value"),"htts://anhtester.com", "FAIL!!! The website not match");
        Assert.assertEquals(getElementAttribute(inputPhone,"value"),"023456789", "FAIL!!! The Phone number not match");
        Assert.assertEquals(getElementAttribute(dropdownGroup,"title"),"VIP", "FAIL!!! The Group not match");
        Assert.assertEquals(getElementAttribute(dropdownCurrency,"title"),"USD", "FAIL!!! The Currency not match");
        Assert.assertEquals(getElementAttribute(inputCity,"value"),"Hanoi" , "FAIL!!! The city not match");
        Assert.assertEquals(getElementAttribute(inputStage,"value"),"Caugiay" , "FAIL!!! The Stage not match");
        Assert.assertEquals(getElementAttribute(selectDefaultLanguage,"title"),"Vietnamese", "FAIL!!! The Language not match");
    }

    public void deleteCustomer(String customerName){
        waitForPageLoaded();
        clickElement(menuCustomers);
        waitForPageLoaded();
        inputElement(inputSearchCustomer, customerName);
        sleep(1);
        mouseHover(firstItemCustomerName);
        clickElement(linkDeleteCustomer);
        waitForAlertIsPresent();
        String confirmDelete =  DriverManager.getDriver().switchTo().alert().getText();
        System.out.println(confirmDelete);
        assertEquals(confirmDelete, "Are you sure you want to perform this action?", "FAIL!!! The content message confirm not match");
        DriverManager.getDriver().switchTo().alert().accept();
        Assert.assertTrue(elementIsDisplay(alertMessage),"FAIL!!! Alert Message not display");
        Assert.assertEquals(getElementText(alertMessage), "Customer deleted", "FAIL!!! Content alert message not match");
    }
}
