package com.cydeo.tests.shortVideo;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P15_LocatingRadioButtons {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
        if ( !(blueRadioButton.isSelected()) ){
            blueRadioButton.click();
        }
        Thread.sleep(2000);

        WebElement redRadioButton = driver.findElement(By.id("red"));
        if ( !(redRadioButton.isSelected()) ){
            redRadioButton.click();
        }
        Thread.sleep(2000);
        WebElement yellowRadioButton = driver.findElement(By.id("yellow"));
        if ( !(yellowRadioButton.isSelected()) ) {
            yellowRadioButton.click();
        }
        Thread.sleep(2000);
        WebElement greenRadioButton = driver.findElement(By.id("green"));
        if ( !(greenRadioButton.isSelected()) ) {
            greenRadioButton.click();
            System.out.println("click green ");
        }
        if (greenRadioButton.isEnabled()){
            System.out.println("enable");
        }else {
            System.out.println("disable");
        }
        Thread.sleep(2000);

        System.out.println("---------------------------------------------");

        List<WebElement> allColors = driver.findElements(By.name("color"));

        System.out.println("allColors.size() = " + allColors.size());

        for (WebElement eachColor : allColors) {
            System.out.println("current radio button is "+ eachColor.getAttribute("id"));
            System.out.println("Is it enabled: "+ eachColor.isEnabled());
            System.out.println("Is it selected: "+ eachColor.isSelected());
        }


        driver.quit();




    }
}
