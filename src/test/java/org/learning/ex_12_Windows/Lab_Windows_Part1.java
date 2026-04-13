package org.learning.ex_12_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;

public class Lab_Windows_Part1 {

    @Test
    public void test_Windows(){

        WebDriver driver =new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        String parent_id =  driver.getWindowHandle();
        System.out.println("parent_id = " + parent_id);

        WebElement link_parent = driver.findElement(By.xpath("//a[text()='Click Here']"));
        link_parent.click();

        Set<String> all_windows = driver.getWindowHandles();
        for (String window_name : all_windows) {
            System.out.println("window_name = " + window_name);
            driver.switchTo().window(window_name);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Passed");
            }
        }
        driver.switchTo().window(parent_id);
    }
}
