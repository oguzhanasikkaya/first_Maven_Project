package com.cydeo.tests.day10_Upload_Action_JSExecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T6_Scroll_JS {

    @Test
    public void scroll_test_JS() throws InterruptedException {
//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

//        3- Use below JavaScript method and scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        a.  750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,750)");
        }
//        b.  750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,-750)");
        }


    }


}
