package org.learning.WaitHelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLImageElement;

import java.sql.Driver;
import java.time.Duration;
import org.openqa.selenium.By;

public class WaitHelpers {

    public static void waitJVM(int time){

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitImplictWait(WebDriver driver, int time){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

    }

    public static void checkVisibility(WebDriver driver, By locator, int time){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static void checkVisibility(WebDriver driver, By locator){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static void checkVisibilityOfAndTextToBePresentInElement(WebDriver driver, WebElement element){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.textToBePresentInElement(element, element.getText()));

    }

    public static void waitForVisibility(WebDriver driver, int timeInSeconds, String Xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
    }




}
