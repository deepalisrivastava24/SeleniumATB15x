package org.learning.ex_09_Action_Class.Booking;

import org.learning.CommonToAll;
import org.learning.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;

public class Booking_Project extends CommonToAll {

    @Test
    public void tes_Booking_Project() {

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");

        driver = new ChromeDriver();
        OpenBrowser(driver, "https://www.booking.com/");

        WaitHelper.checkVisibility(driver, By.xpath("//button[@aria-label='Dismiss sign in information.']"), 3);
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='Dismiss sign in information.']"));
        element.click();

        WebElement fligts = driver.findElement(By.xpath("//a[@id='flights']"));
        fligts.click();

        WebElement destination = driver.findElement(By.xpath("//button[@data-ui-name='input_location_to_segment_0']"));
        //destination.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(destination).sendKeys(destination,"DELHI")
                .keyDown(Keys.TAB).keyDown(Keys.ENTER).build().perform();

        WaitHelper.waitJVM(10000);

        WebElement search = driver.findElement(By.xpath("//button[@data-ui-name='button_search_submit']"));
        search.click();
    }
}