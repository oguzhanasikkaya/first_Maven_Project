package com.cydeo.utilities;

import org.openqa.selenium.By;

public class WebTableUtils {



   /* public static String returnOrderDate(String customerName){

        String locator = "//td[.='"+customerName+"']/following-sibling::td[3]";

        WebElement customerDateCell = Driver.getDriver().findElement(By.xpath(locator));

        return customerDateCell.getText();
    }*/

    public static String returnOrderDate(String customerName){
        return Driver.getDriver().findElement(By.xpath("//td[.='"+customerName+"']/following-sibling::td[3]")).getText();
    }

}
