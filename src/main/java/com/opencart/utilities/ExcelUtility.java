package com.opencart.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private static final String FILE_PATH =
            System.getProperty("user.dir")
            + "/test-data/TestData.xlsx";

    // Get number of rows
    public static int getRowCount(String sheetName) {

        try (FileInputStream file =
                     new FileInputStream(FILE_PATH);
             Workbook workbook =
                     new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet not found: " + sheetName);
            }

            return sheet.getPhysicalNumberOfRows();

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to read Excel file: " + FILE_PATH, e);
        }
    }

    // Get number of columns
    public static int getColumnCount(String sheetName) {

        try (FileInputStream file =
                     new FileInputStream(FILE_PATH);
             Workbook workbook =
                     new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet not found: " + sheetName);
            }

            Row headerRow = sheet.getRow(0);

            if (headerRow == null) {
                throw new RuntimeException(
                        "Header row is empty");
            }

            return headerRow.getPhysicalNumberOfCells();

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to read Excel file: " + FILE_PATH, e);
        }
    }

    // Get cell data
    public static String getCellData(
            String sheetName,
            int rowNumber,
            int columnNumber) {

        try (FileInputStream file =
                     new FileInputStream(FILE_PATH);
             Workbook workbook =
                     new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet not found: " + sheetName);
            }

            Row row = sheet.getRow(rowNumber);

            if (row == null) {
                return "";
            }

            Cell cell = row.getCell(columnNumber);

            if (cell == null) {
                return "";
            }

            return cell.toString();

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to read Excel file: " + FILE_PATH, e);
        }
    }
}