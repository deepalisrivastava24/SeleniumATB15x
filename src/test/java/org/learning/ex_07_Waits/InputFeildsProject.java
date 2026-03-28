package org.learning.ex_07_Waits;

import io.qameta.allure.Description;
import org.learning.WaitHelpers.WaitHelpers;
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

        WaitHelpers.waitForVisibility(driver,5,"//input[@name=\"firstname\"]");
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        inputUsername.sendKeys("Deepali");

        WaitHelpers.waitForVisibility(driver,5,"//input[@name=\"lastname\"]");
        WebElement inputLastName = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        inputLastName.sendKeys("Srivastava");

        WaitHelpers.waitForVisibility(driver,5,"//label[@class=\"radio\"]");
        WebElement radioBtn = driver.findElement(By.xpath("//label[@class=\"radio\"]"));
        radioBtn.click();

        if (radioBtn.isSelected()) {
            System.out.println("Radio button is selected");
        }

        WaitHelpers.waitForVisibility(driver,5,"//label[@class=\"radio\"]");
        WebElement checkBox = driver.findElement(By.xpath("//label[@class=\"radio\"]"));
        checkBox.click();

        if (checkBox.isSelected()) {
            System.out.println("Checkbox is selected");
        }

        driver.quit();

    }
}
