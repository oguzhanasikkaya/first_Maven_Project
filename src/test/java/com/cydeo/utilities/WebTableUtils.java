package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {



   /* public static String returnOrderDate(String customerName){

        String locator = "//td[.='"+customerName+"']/following-sibling::td[3]";

        WebElement customerDateCell = Driver.getDriver().findElement(By.xpath(locator));

        return customerDateCell.getText();
    }*/

    public static String returnOrderDate(String customerName){
        return Driver.getDriver().findElement(By.xpath("//td[.='"+customerName+"']/following-sibling::td[3]")).getText();
    }

    /** • Name: orderVerify ()
        • Return type: void
        • Arg1: String costumerName
        • Arg2: String expectedOrderDate
     This method should accept above-mentioned arguments and internally assert
     expectedOrderDate matching actualOrderDate. */
    public static void orderVerify(String customerName,String expectedOrderData){

        String locator = "//td[.='"+customerName+"']/following-sibling::td[3]";
        WebElement customerDateCell = Driver.getDriver().findElement(By.xpath(locator));
        String actualOrderDate = customerDateCell.getText();
        Assert.assertEquals(actualOrderDate,expectedOrderData);

    }
}
