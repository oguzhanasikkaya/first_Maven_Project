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

public class WebDriverFactory {
    WebDriver driver;

    public static WebDriver getDriver(String browserType){

        if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }else {
            System.out.println("Given browser type is does not exist/or is not currently supported");
            return null;
        }



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
