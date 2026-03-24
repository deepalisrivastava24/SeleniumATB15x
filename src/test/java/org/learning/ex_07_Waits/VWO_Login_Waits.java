package org.learning.ex_07_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VWO_Login_Waits {

    @Test
    public void TestSelenium() throws InterruptedException {

        //Driver Managing
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-username")));
        Email.sendKeys("admin@admin.com");

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-password")));
        Password.sendKeys("admin");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-login-btn")));
        button.click();

        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notification-box-description")));

        String Error_Text=error.getText();

        String expectedText = "Your email, password, IP address or location did not match";

        Assert.assertEquals(Error_Text,expectedText);

        driver.quit();

    }
}
