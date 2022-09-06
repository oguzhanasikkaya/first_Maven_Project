package com.cydeo.tests.day07_webtables_utilities;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T1_WindowHandling {


    @Test
    public void window_handling_test(){
        //1 go to Amazon.com
        Driver.getDriver().get("https://www.amazon.com");

        //2 Copy paste the lines from below into your class

        //3 Create a logic to switch to the tab where Etsy.com is open
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://facebook.com','_blank');");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://google.com','_blank');");

        //4 Assert:Title contains "Etsy"
        BrowserUtils.switchWindowAndVerify("etsy","Etsy");

        Driver.getDriver().quit();



    }


}
