package org.learning.ex_03_Locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium2_LinkTextPartialLinkText {

    @Description("Verify create account negative testcase")
    @Test
    public void test_LinkText_PartialLinkText(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        //Full link text
//        WebElement Full_Link_Text = driver.findElement(By.linkText("Start a free trial"));
//        Full_Link_Text.click();


        WebElement Partial_Link_Text = driver.findElement(By.partialLinkText("Start"));
        Partial_Link_Text.click();

        driver.quit();

    }
}
