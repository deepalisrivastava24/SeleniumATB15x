package org.learning.ex_11_Input_Select_Alerts;

import org.learning.CommonToAll;
import org.learning.WaitHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JS_Alerts extends CommonToAll {

    @Test
    public void JS_Alerts(){

        driver = new ChromeDriver();
        OpenBrowser(driver,"https://the-internet.herokuapp.com/javascript_alerts");

//        WebElement jsAlertElement = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
//        jsAlertElement.click();
//        WaitHelper.explicitWait(driver, 5);
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        WebElement Result = driver.findElement(By.id("result"));
//        Assert.assertEquals(Result.getText(),"You successfully clicked an alert");


//        WebElement jsConfirmElement = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
//        jsConfirmElement.click();
//        WaitHelper.explicitWait(driver, 5);
//        Alert alert = driver.switchTo().alert();
////        alert.accept();
//        alert.dismiss();
//        WebElement Result = driver.findElement(By.id("result"));
////        Assert.assertEquals(Result.getText(),"You clicked: Ok");
//        Assert.assertEquals(Result.getText(),"You clicked: Cancel");


        WebElement jsPromptElement = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromptElement.click();
        WaitHelper.explicitWait(driver, 5);
        Alert alert2 = driver.switchTo().alert();

//        alert2.sendKeys("Hello");
//        alert2.accept();
//        WebElement Result1 = driver.findElement(By.id("result"));
//        Assert.assertEquals(Result1.getText(),"You entered: Hello");

        alert2.dismiss();
        WebElement Result2 = driver.findElement(By.id("result"));
        Assert.assertEquals(Result2.getText(),"You entered: null");

        closeBrowser(driver);


    }


}
