package com.opencart.tests;

import org.testng.annotations.DataProvider;

import com.opencart.utilities.ExcelUtility;

public class RegisterDataProvider {

    @DataProvider(name = "registerData")
    public static Object[][] getRegisterData() {

        String sheetName = "RegisterData";

        int rows = ExcelUtility.getRowCount(sheetName);
        int columns = ExcelUtility.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][columns];

        String timestamp =
                String.valueOf(System.currentTimeMillis());

        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                data[i - 1][j] =
                        ExcelUtility.getCellData(
                                sheetName,
                                i,
                                j);
            }

            // Generate unique email
            String firstName = (String) data[i - 1][0];

            data[i - 1][2] =
                    firstName.toLowerCase()
                    + timestamp
                    + "@test.com";
        }

        return data;
    }
}