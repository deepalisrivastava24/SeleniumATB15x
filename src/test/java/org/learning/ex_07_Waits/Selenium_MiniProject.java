package org.learning.ex_07_Waits;


import io.qameta.allure.Description;
import org.learning.WaitHelpers.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.learning.WaitHelpers.WaitHelpers.waitJVM;

public class Selenium_MiniProject {

    @Description("Verify makemytrip opens with model")
    @Test
    public void testModelClose(){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.makemytrip.com/");
        System.out.println(driver.getTitle());

        WaitHelpers.waitForVisibility(driver, 5, "//span[@data-cy='closeModal']");
        WebElement closeModel = driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]"));
        closeModel.click();

        //waitJVM(5);

        driver.quit();


    }
}
