package com.thaonth.Bai28_ExcelFileData;

import com.thaonth.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoExcelFile {
    @Test
    public void getDataFromExcel(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testData/Login.xlsx","Sheet1");

        //Get simple data from Excel
        System.out.println(excelHelper.getCellData("EMAIL", 1));
        System.out.println(excelHelper.getCellData("PASSWORD", 1));

        //Get multiple data from Excel
        for (int i = 1; i <= 5 ; i++) {
            System.out.println(excelHelper.getCellData("EMAIL", i));
            System.out.println(excelHelper.getCellData("PASSWORD", i));
        }
        System.out.println("*******************************");
        //Set data to Excel
        excelHelper.setCellData("PASS", "STATUS", 1);
    }
}
