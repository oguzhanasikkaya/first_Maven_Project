package com.cydeo.utilities;

import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /**
    This method will accept int (int seconds) and execute Thread.sleep for given duration
     */
    public static void sleep ( int second){
        second*=1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    /**
    This method accepts 2 argument.
    Arg 1 expectedInUrl : for verify if the url contains given String
    Arg 2 expectedTitle to be compared against actualTitle
     */
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

    /**
    This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);
    }


}
