package org.learning.ex_03_Locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium_MiniProject1 {

    @Owner("Deepali")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the Error message")
    @Test
    public void vwo_FreeTrail_Verify_msg(){

////        WebDriver driver = new ChromeDriver();
////        driver.get("https://app.vwo.com");
////        driver.manage().window().maximize();
////
////        WebElement link_text_msg = driver.findElement(By.linkText("Start a free trial"));


        WebDriver driver = new ChromeDriver();
        driver.get("https://vwo.com/free-trial/");
        driver.manage().window().maximize();

        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));


        WebElement business_email_textbox= driver.findElement(By.id("page-v1-step1-email"));
        business_email_textbox.sendKeys("admin@admin1234");

        WebElement checkbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox.click();

        WebElement submit_button = driver.findElement(By.tagName("button"));
        submit_button.click();

        WebElement error_message = driver.findElement(By.className("invalid-reason"));

        Assert.assertEquals(error_message.getText(),"The email address you entered is incorrect.");

        driver.quit();

    }
}
