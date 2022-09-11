package com.cydeo.shortVideo.tests;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables_Practice extends TestBase {

    @Test
    public void webTablesTest()throws InterruptedException{
        driver.get("https://practice.cydeo.com/tables");

        //print out Jason from row and cell number
        WebElement jasonRow = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[3]//td[2]"));
        System.out.println(jasonRow.getText());

        WebElement firstName = driver.findElement(By.xpath("(//span[.='First Name'])[1]"));
        firstName.click();

        jasonRow = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[3]//td[2]"));
        System.out.println(jasonRow.getText());

        //print out the Jason text

        WebElement jasonCell = driver.findElement(By.xpath("//table[@id='table1']//td[.='Jason']"));
        System.out.println(jasonCell.getText());

        firstName.click();
        System.out.println(jasonCell.getText());



        //print out all cell in row 3

        List<WebElement> allRow3Cells = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));

        for (WebElement eachCell : allRow3Cells) {
            System.out.println("eachCell.getText() = " + eachCell.getText());
        }





        System.out.println("------------------------------------------------------------------------------------");

        //challenge yourself to store  the table column names into a list of String

        List<WebElement>  columnNames = driver.findElements(By.xpath("//table[@id='table1']//thead//tr"));

        for (WebElement eachColumn : columnNames) {
                System.out.println(eachColumn.getText());

        }

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------");

        //challenge  yourself to print out each and every cell values
        List<WebElement> table1 = driver.findElements(By.xpath("//table[@id='table1']"));

        for (WebElement eachCell : table1) {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            System.out.println(eachCell.getText());

        }


    }

}
