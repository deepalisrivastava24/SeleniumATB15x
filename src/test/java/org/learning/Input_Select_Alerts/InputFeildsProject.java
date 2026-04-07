package org.learning.Input_Select_Alerts;

import io.qameta.allure.Description;
import org.learning.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class InputFeildsProject {

    @Description("To verify Input fields")
    @Test
    public void InputFeildsProject(){
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://awesomeqa.com/practice.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WaitHelper.waitForVisibility(driver,5,"//input[@name=\"firstname\"]");
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        inputUsername.sendKeys("Deepali");

        WaitHelper.waitForVisibility(driver,5,"//input[@name=\"lastname\"]");
        WebElement inputLastName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        inputLastName.sendKeys("Srivastava");

        WaitHelper.waitForVisibility(driver,5,"//input[@id=\"sex-1\"]");
        WebElement radioBtn = driver.findElement(By.xpath("//input[@id=\"sex-1\"]"));
        radioBtn.click();

        if (radioBtn.isSelected()) {
            System.out.println("Radio button is selected");
        }

        WaitHelper.waitForVisibility(driver,5,"//input[@id=\"profession-1\"]");
        WebElement checkBox = driver.findElement(By.xpath("//input[@id=\"profession-1\"]"));
        checkBox.click();

        if (checkBox.isSelected()) {
            System.out.println("Checkbox is selected");
        }

        WaitHelper.waitJVM(1000);

        driver.quit();

    }
}
