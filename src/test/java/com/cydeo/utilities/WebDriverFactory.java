package com.cydeo.utilities;
//task new method creation
//method name : getDriver
//static method
//accepts String arg: browserType
//  -This arg will determine what type of browser is opened
//  -if chrome passed --> it will open Chrome browser
//  -if firefox passed --> it will open firefox broser
//RETURN TYPE : WebDriver


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {


    public static WebDriver getDriver(String browserType){

        WebDriver driver;

        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Unknown Browser Type "+ browserType);
                driver = null;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    public static void clickAndVerifyRadioButton(WebDriver driver,String nameAttribute, String idValue){

        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));
        //loop through the list of WebElement and select matching result hockey

        for (WebElement each : radioButtons){

            String eachID = each.getAttribute("id");

            if (eachID.equals(idValue)){
                each.click();
                System.out.println(eachID+" is selected : "+ each.isSelected());
                break;
            }
        }
    }
}
