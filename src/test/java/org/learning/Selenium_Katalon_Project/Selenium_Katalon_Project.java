package org.learning.Selenium_Katalon_Project;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_Katalon_Project {


    @Test
    public void Test_Selenium_Katalon_Project(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement button = driver.findElement(By.id("btn-make-appointment"));
        button.click();

        WebElement Input_username = driver.findElement(By.id("txt-username"));
        Input_username.sendKeys("John Doe");

        WebElement Input_password = driver.findElement(By.id("txt-password"));
        Input_password.sendKeys("ThisIsNotAPassword");

        WebElement button_login = driver.findElement(By.id("btn-login"));
        button_login.click();

        //Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment", driver.getCurrentUrl());

        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Make Appointment");

        driver.quit();



    }
}
