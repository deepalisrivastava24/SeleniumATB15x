package org.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium007_Navigation_Get_NavigationTo {

    @Test
    public void test_selenium03() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https:www.google.com");

        driver.navigate().to("https://www.google.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        Thread.sleep(10000);

        driver.quit();
    }
}
