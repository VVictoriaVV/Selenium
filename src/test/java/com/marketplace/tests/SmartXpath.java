package com.marketplace.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SmartXpath {
    public static void main(String[] args) throws IOException {

        String fruitName = "Apple";
        String updatedValue = "603";




        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
        String priceColoumn = driver.findElement(By.xpath("//div[text()='Price']")).getDomAttribute("data-column-id");
        String priceOfApple = driver.findElement(By.xpath("//div[text()='Apple']/parent::div/parent::div/div[@id='cell-" + priceColoumn + "-undefined']")).getText();
        Assert.assertEquals("345", priceOfApple);


        WebElement downLoadButton = driver.findElement(By.xpath("//button[@id='downloadButton']"));
        downLoadButton.click();

        String file = "/Users/79255/Downloads/download.xlsx";
        int col = getColoumnNumber(file, "price");
        int row = getRowNumber(file, fruitName);
        updateCell(file, row, col, updatedValue);

    }

    private static int getColoumnNumber(String file, String colName) throws IOException {
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
        Row firstrow = rows.next();
        Iterator<Cell> ce = firstrow.cellIterator();//row is collection of cells
        int k = 1;
        int coloumn = 0;
        while (ce.hasNext()) {
            Cell value = ce.next();
            if (value.getStringCellValue().equalsIgnoreCase(colName)) {
                coloumn = k;
            }
            k++;
        }
        System.out.println(coloumn);
        return coloumn;
    }

    private static boolean updateCell(String file, int row, int col, String updateValue) throws IOException {
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row rowField = sheet.getRow(row - 1);
        Cell cellField = rowField.getCell(col - 1);
        cellField.setCellValue(updateValue);
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        workbook.close();
        fis.close();
        return true;
    }

    private static int getRowNumber(String file, String fruitName) throws IOException {
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
        int k = 1;
        int rowIndex = -1;
        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
          //      if (cell.getCellType() = CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(text)) {
                    rowIndex = k;
                }
            }

            k++;
      //  }
        return rowIndex;
    }

}




