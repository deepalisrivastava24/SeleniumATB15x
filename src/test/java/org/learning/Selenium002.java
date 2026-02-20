package org.learning;

import org.openqa.selenium.edge.EdgeDriver;

public class Selenium002 {
    public static void main(String[] args) {

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }
}
