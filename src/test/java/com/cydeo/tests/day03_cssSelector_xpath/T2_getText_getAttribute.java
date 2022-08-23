package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {

    public static void main(String[] args) {

//        TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//        2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

//        3- Verify “remember me” label text is as expected:
//        Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String expectedRememberMeLAbel = "Remember me on this computer";
        String actualRememberMeLabel = rememberMeLabel.getText();

        if (expectedRememberMeLAbel.equals(actualRememberMeLabel)){
            System.out.println("remember me label verification passed!");
        }else {
            System.out.println("remember me label verification failed!");
        }
//        4- Verify “forgot password” link text is as expected:
//        Expected: Forgot your password?
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgotPasswordLinkText = "FORGOT YOUR PASSWORD?";
        String actualForgotPasswordLİnkText = forgotPasswordLink.getText();

        if (actualForgotPasswordLİnkText.equals(expectedForgotPasswordLinkText)){
            System.out.println("forgot password link verification passed!");
        }else {
            System.out.println("actualForgotPasswordLİnkText = " + actualForgotPasswordLİnkText);
            System.out.println("expectedForgotPasswordLinkText = " + expectedForgotPasswordLinkText);

            System.out.println("forgot password link verification failed!!!");
        }
//        5- Verify “forgot password” href attribute’s value contains expected:
//        Expected: forgot_password=yes

        String expectedInHref = "forgot_password=yes";
        String actualInHrefAttributeValue = forgotPasswordLink.getAttribute("href");

        System.out.println("actualInHrefAttributeValue = " + actualInHrefAttributeValue);

        if (actualInHrefAttributeValue.contains(expectedInHref)){
            System.out.println("HREF attribute value verification PASSED!");
        }else {
            System.out.println("HREF attribute value verification FAILED!!!");
        }


    }
}





/*PS: Inspect and decide which locator you should be using to locate web
elements. */
