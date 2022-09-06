package com.cydeo.utilities;

import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /*
    This method will accept int (int seconds) and execute Thread.sleep for given duration
     */
    public void sleep ( int second){
        second*=1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }


    public static void switchWindowAndVerify(String expectingInUrl, String expectedInTitle){
        Set<String> allWindowHandles =Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: "+ Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectingInUrl)){
                break;
            }
        }
        // Assert: Title contains expected title
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


}
