package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) {
        //1 open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2 go to google.com
        driver.navigate().to("https://www.google.com");

        //3write "apple" in search box

        WebElement googleSearchBox = driver.findElement(By.name("q"));


        //4 press enter using Keys.ENTER

        googleSearchBox.sendKeys("apple" + Keys.ENTER);





        //5 verify title
        // expected title should start with "apple" word
        String expectedTitle  ="apple - Google'da Ara";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedTitle)){
            System.out.println("Title verification passed");
        }else {
            System.out.println("Title verification failed");
        }

        driver.quit();
    }
}
