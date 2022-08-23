package com.cydeo.tests.shortVideo;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P12_LocateElementByCSS {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.navigate().to("https://google.com");

        //search for cydeo
        WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
        searchBox.sendKeys("cydeo"+ Keys.ENTER);

        // verify Cydeo linkText is appeared in the result

        WebElement cydeoText = driver.findElement(By.cssSelector("a[href='https://cydeo.com/']>h3"));

        if (cydeoText.getText().equals("Cydeo")){
            System.out.println("cydeo text test is passed");
        }else {
            System.out.println("cydeo text test is failed");
        }

        //close the browser
        driver.quit();
    }
}
