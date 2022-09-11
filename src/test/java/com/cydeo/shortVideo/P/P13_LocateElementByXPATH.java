package com.cydeo.shortVideo.P;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P13_LocateElementByXPATH {
    public static void main(String[] args) {

        //set up chrome driver and create WebDriver instance

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //navigate to google.com
        driver.get("https://www.google.com");

        //search for cydeo
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("cydeo"+ Keys.ENTER);


        //verify cydeo linkText is appeared in the results
        WebElement cydeoText = driver.findElement(By.xpath("//h3[.='Cydeo']"));
        if (cydeoText.getText().equals("Cydeo")){
            System.out.println("Cydeo text is appeared");
        }else {
            System.out.println("cydeo text is not appeared");
        }

        //close the browser
        driver.quit();
    }
}
