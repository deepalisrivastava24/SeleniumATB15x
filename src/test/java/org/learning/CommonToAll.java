package org.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonToAll {

    public ChromeDriver driver;

    public void OpenBrowser(WebDriver driver, String URL){
        driver.get(URL);
        driver.manage().window().maximize();
    }
    public void closeBrowser(WebDriver driver){
        driver.quit();
    }

    public void waitForVisibility(WebDriver driver, int timeInSeconds,String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public void clickFoundElement (String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }
}
