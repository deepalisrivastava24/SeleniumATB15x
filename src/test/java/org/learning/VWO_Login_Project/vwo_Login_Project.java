package org.learning.VWO_Login_Project;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class vwo_Login_Project {

    @Description("Verify error message on incorrect login credentials")
    @Test
    public void vwo_login(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("admin@admin.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("admin");

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-login-btn")));

        WebElement loginButton = driver.findElement(By.id("js-login-btn"));
        loginButton.click();

        //WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));
        String notification = driver.findElement(By.id("js-notification-box-msg")).getText();

        Assert.assertEquals(notification, "Your email, password, IP address or location did not match");

        driver.quit();




    }
}
