package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_WebTable_Order_Verify {


   // @Test
    public void order_name_verify_test(){
//        1. Go to: https://practice.cydeo.com/web-tables
        Driver.getDriver().get("https://practice.cydeo.com/web-tables");

            //Locate the cell that has Bob Martin text in it
        WebElement bobMartinCell =
           Driver.getDriver().findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[7]//td[2]"));

       // System.out.println("bobMartinCell = " + bobMartinCell);
       // System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());


//        2. Verify Bob’s name is listed as expected.
//        Expected: “Bob Martin”
        String expectedBobName = "Bob Martin";
        String actualBobName = bobMartinCell.getText();
        Assert.assertEquals(actualBobName,expectedBobName);

//        3. Verify Bob Martin’s order date is as expected
//        Expected: 12/31/2021
        WebElement orderDate = Driver.getDriver().findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[7]//td[2]/following-sibling::td[3]"));
        String expectedOrderDate = "12/31/2021";
        String actualOrderDate= orderDate.getText();
        //System.out.println("orderDate = " + orderDate.getText());

        Assert.assertEquals(expectedOrderDate,actualOrderDate);

    }

    //We use the utility method we created.
    @Test
    public void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/web-tables");
        String costumerOrderDate = WebTableUtils.returnOrderDate("Ned Stark");
        System.out.println("costumerOrderDate = " + costumerOrderDate);

    }
}
