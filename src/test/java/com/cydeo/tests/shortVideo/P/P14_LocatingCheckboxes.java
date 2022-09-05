package com.cydeo.tests.shortVideo.P;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P14_LocatingCheckboxes {
    public static void main(String[] args) {
        // set up chrome driver and open chrome

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/checkboxes");


        WebElement checkbox1 = driver.findElement(By.id("box1"));
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        checkbox1.click();
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());


        WebElement checkbox2 = driver.findElement(By.id("box2"));
        System.out.println("checkbox2.getAttribute() = " + checkbox2.getAttribute("checked"));
        checkbox2.click();
        System.out.println("checkbox2.getAttribute() = " + checkbox2.getAttribute("checked"));

        //if we want to check the checkbox
        if (checkbox1.isSelected()){
            System.out.println("checkbox1 is already selected");
        }else {
            checkbox1.click();
        }


        driver.quit();


    }
}
