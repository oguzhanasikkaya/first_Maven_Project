package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.cydeo.utilities.WebDriverFactory.clickAndVerifyRadioButton;

public class T3_RadioButton_cont {
    public static void main(String[] args) {
        /*
        TC #3: Utility method task for (continuation of Task2)
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

Create a utility method to handle above logic.
Method name: clickAndVerifyRadioButton
Return type: void or boolean
Method args:
1. WebDriver
2. Name attribute as String (for providing which group of radio buttons)
3. Id attribute as String (for providing which radio button to be clicked)

Method should loop through the given group of radio buttons. When it finds the
matching option, it should click and verify option is Selected.
Print out verification: true

         */


        //        1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//        2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");


        clickAndVerifyRadioButton(driver,"sport","hockey");

        System.out.println("----------------------------------------------------------------------");

//       Locate name sports radio buttons and store them in a list of Web Element

        List<WebElement> sportRadioButtons = driver.findElements(By.name("sport"));


        //loop through the list of WebElement and select matching result hockey

        for (WebElement each : sportRadioButtons){

            String eachID = each.getAttribute("id");
            System.out.println("eachID = " + eachID);
            if (eachID.equals("hockey")){
                each.click();
                System.out.println("Hockey is selected : "+ each.isSelected());
                break;

            }
        }
    }

}
