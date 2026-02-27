package org.learning.ex_02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium004_Maximize_Minimize {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        driver.manage().window().maximize();

        driver.quit();


    }
}
