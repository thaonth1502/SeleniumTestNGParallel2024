package com.thaonth.Bai29_DataProvider;

import com.thaonth.dataproviders.DataProviderFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider {


    @Test(dataProvider = "Data_Provider_01", dataProviderClass = DataProviderFactory.class)
    public void testDataProvider01(String value){
        System.out.println("Test: " + value);
    }

    @Test(dataProvider = "Data_Provider_02", dataProviderClass = DataProviderFactory.class)
    public void testDataProvider02(String value1, String value2, String value3){
        System.out.println("Value1: " + value1);
        System.out.println("Value2: " + value2);
        System.out.println("Value3: " + value3);
        System.out.println("-----------------");
    }

    @Test(dataProvider = "Data_Provider_03", dataProviderClass = DataProviderFactory.class)
    public void testDataProvider03(String name, String phone, String vat, String address){
        System.out.println("Parameter 1: " + name);
        System.out.println("Parameter 2: " + phone);
        System.out.println("Parameter 3: " + vat);
        System.out.println("Parameter 4: " + address);
        System.out.println("\n");
    }


}
