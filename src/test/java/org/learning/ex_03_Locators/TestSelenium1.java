package org.learning.ex_03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium1 {

    @Test
    public void TestSelenium() throws InterruptedException {

        //Driver Managing
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        //Locators
        // <input type="email" class="text-input W(100%)" name="username"
        // vwo-html-translate-attr="placeholder" vwo-html-translate-placeholder="login:enterEmailID"
        // id="login-username" data-qa="hocewoqisi" placeholder="Enter email ID">

        WebElement Email_Input_Box = driver.findElement(By.id("login-username"));
        Email_Input_Box.sendKeys("admin@admin.com");

        //Password locators
        //<input type="password" class="text-input W(100%) Pend(36px)"
        // vwo-html-translate-attr="placeholder" vwo-html-translate-placeholder="login:enterPassword"
        // name="password" id="login-password" data-qa="jobodapuxe" placeholder="Enter password">

        WebElement Password_Input_Box = driver.findElement(By.id("login-password"));
        Password_Input_Box.sendKeys("admin");

        WebElement button_Submit = driver.findElement(By.id("js-login-btn"));
        button_Submit.click();

        //wait for sometime

        Thread.sleep(5000);

        //Verify error message

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        System.out.println(error_msg.getText());

        //Assertions

        Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");

        driver.quit();

    }
}
