package org.learning.ex_09_Action_Class;

import io.qameta.allure.Description;
import org.learning.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Lab_ActionClass {

    @Description("Verify the action classes")
    @Test
    public void test_Actions(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();

        WebElement firstName= driver.findElement(By.name("firstname"));


        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(firstName,"deepali")
                .keyUp(Keys.SHIFT).build().perform();

        WebElement lastName= driver.findElement(By.name("lastname"));

        actions.moveToElement(lastName).click().build().perform();

        actions.keyDown(Keys.SHIFT).sendKeys(lastName,"srivastava")
                .keyUp(Keys.SHIFT).build().perform();

        WaitHelper.explicitWait(driver, 10);

        driver.quit();


    }
}
