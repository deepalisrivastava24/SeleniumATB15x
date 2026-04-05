package org.learning.OrangeHRM;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class orangeHRMProject {

    @Test
    @Description("verify")
    public void test_OrangeHRM_Project() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement input_username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement input_password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement button = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();


        // rows=> //div[@role="table"]/div[@class="oxd-table-body"]/div[@class="oxd-table-card"]
        // or rows=> //div[@class="oxd-table-card"]

        //All the columns of a row => //div[@class="oxd-table-card"][1]/div/div[@role="cell"][1]

        String first_part = "//div[@class=\"oxd-table-card\"][";
        String second_part = "]/div/div[@role=\"cell\"][";
        String third_part = "]";

        Thread.sleep(2000);

        int row = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"]")).size();
        System.out.println(row);

        int column = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"][1]/div/div[@role=\"cell\"]")).size();
        System.out.println(column);

        for(int i = 1; i <= row; i++){

            Thread.sleep(2000);
            String Status_Xpath = first_part + i + second_part + "6]";
            String Status_Xpath_Text = driver.findElement(By.xpath(Status_Xpath)).getText();

            if (Status_Xpath_Text.equalsIgnoreCase("Terminated")){

                System.out.println("First Terminated employee found at row: " + i);

                String deleteBtnXpath = first_part + i + "]"+ "//button[.//i[@class=\"oxd-icon bi-trash\"]]";
                driver.findElement(By.xpath(deleteBtnXpath)).click();

                String popup_Text = driver.findElement(By.xpath("//div[@class=\"orangehrm-modal-header\"]")).getText();

                Assert.assertEquals(popup_Text, "Are you Sure?");

                break;
            }
        }
        driver.quit();

    }
}
