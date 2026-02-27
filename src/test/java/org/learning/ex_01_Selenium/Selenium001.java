package org.learning.ex_01_Selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium001 {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

    }
}
