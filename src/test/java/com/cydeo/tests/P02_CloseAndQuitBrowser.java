package com.cydeo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02_CloseAndQuitBrowser {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //navigate to a practice page that open new tab
        //this practice url will open and wait 3 seconds and open new tab

        driver.get("http://practice.cydeo.com/open_new_tab");


        //wait 5 sec
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //closing any current tab
        driver.close();

       // close all browser window opened by driver
        driver.quit();







    }




}
