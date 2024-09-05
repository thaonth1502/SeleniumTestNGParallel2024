package com.thaonth.dataproviders;

import com.thaonth.helpers.ExcelHelper;
import com.thaonth.helpers.SystemHelper;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    @DataProvider(name = "Data_Provider_01")
    public  Object[][] dataProvider01(){
        return new Object[][]{{"First Value"}, {"Second Value"}};
    }
    @DataProvider(name = "Data_Provider_02")
    public  Object[][] dataProvider02(){
        return new Object[][]{{"Value1", "Value2", "Value3"}, {"Value4", "Value5", "Value6"}};
    }

    @DataProvider(name = "Data_Provider_03", parallel = false)
    public  Object[][] dataProvider03(){
        return new Object[][]{
                {"Vietel", "0123456789", "10%", "Hanoi"},
                {"VNPT", "0987654321", "5%", "HCM"}
        };
    }

    @DataProvider(name = "data_provider_login")
    public Object[][] dataProviderLogin() {
        return new Object[][]{
                {"admin@example.com", "123456"},
                {"admin@example.com", "123456"}
        };
    }

    @DataProvider(name = "data_provider_login_excel", parallel = true)
    public Object[][] dataLoginHRMFromExcel(){
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(SystemHelper.getCurrentDir() + "src/test/resources/testData/DataExcel.xlsx","LoginDataProvider");
        System.out.println("Login Data frome excel: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_hashtable")
    public Object[][] dataLoginHRMFromExcelHashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testData/DataExcel.xlsx", "LoginDataProvider", 2, 5);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }
}
