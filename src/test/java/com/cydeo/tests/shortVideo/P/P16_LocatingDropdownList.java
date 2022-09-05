package com.cydeo.tests.shortVideo.P;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P16_LocatingDropdownList {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/dropdown");


        //identify the select element
        WebElement dropDownElement = driver.findElement(By.id("dropdown"));


        //wrap this element inside Select object

        Select selectObj = new Select(dropDownElement);


        //use ready methods to select option

        selectObj.selectByIndex(1);
        Thread.sleep(3000);
        selectObj.selectByValue("2");
        Thread.sleep(3000);
        selectObj.selectByVisibleText("Option 2");


        // verify determined option is selected

        String expectedOption = "Option 2";
        String actualOption = selectObj.getFirstSelectedOption().getText();

        if (actualOption.equals(expectedOption)){
            System.out.println("option 2 selection passed");
        }else {
            System.out.println("option 2 selection failed");
        }



        //quit the browser

    }
}
