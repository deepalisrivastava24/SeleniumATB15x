package org.learning.ex_07_Waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class Implicit_waits {

    public static void main(String[] args){

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://app.vwo.com");

        //don't use this implicit wait

    }
}
