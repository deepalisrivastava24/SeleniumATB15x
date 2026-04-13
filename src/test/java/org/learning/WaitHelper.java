package org.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class WaitHelper {

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

    public static void explicitWait(WebDriver driver, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
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

    public static void waitForVisibilityAndClick(WebDriver driver, int timeInSeconds, String Xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
        WebElement element = driver.findElement(By.xpath(Xpath));
        element.click();
    }
}
