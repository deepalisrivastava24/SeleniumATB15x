package org.learning.Selenium_VWO_Project;

import org.learning.CommonToAll;
import org.learning.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium_VWO_Login extends CommonToAll {

    @Test
    public void test_VWO_Login() {

        //Open Browser
        driver = new ChromeDriver();
        OpenBrowser(driver, "https://app.vwo.com/#/login");

        //Login in VWO.com
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("vqfgln3034@tempmail.rest");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("Xyz#12345");

        WaitHelper.waitForVisibilityAndClick(driver, 5, "//button[@id='js-login-btn']");

        //Click on Save btn.
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement btn_save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='boxasuraza']")));
//        btn_save.click();

        //Click on Start free trial on Set UP your Account Page

//        WaitHelper.waitForElementToBeClickable(driver,40,"//div[@class='Px(20px) Py(28px) ng-scope']//div[1]//div[1]//div[2]//div[3]//button[1]");

        //Click on Add Domain button

//        WaitHelper.waitForElementToBeClickable(driver,40,"//button[normalize-space()='Add domain']");

        //******Click on Connect Your First Website accordion --- ////h5[normalize-space()='Connect Your First Website']
        WaitHelper.waitJVM(5000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_UP).build().perform();
       WaitHelper.checkVisibility(driver,By.xpath("//h5[normalize-space()='Connect Your First Website']"),40);
        WebElement accordion = driver.findElement(By.xpath("//h5[normalize-space()='Connect Your First Website']"));
        action.moveToElement(accordion).click().build().perform();

        Assert.assertEquals(accordion.getText(),"Connect Your First Website");
        System.out.println(accordion.getText());

        //Click on Copy Button  //div[@data-qa="qunizequke"]//button[@data-qa="xugejexijo"]

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
        //action.sendKeys(Keys.PAGE_DOWN).build().perform();


        WebElement copyBtn = wait1.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@vwo-title='Copy']")));

        action.moveToElement(copyBtn)
                .pause(Duration.ofSeconds(10))   // optional stability
                .click()
                .build()
                .perform();

//        //*******Click on profile icon
//        WebElement btn_profile = driver.findElement(By.xpath("//button[@aria-label='Open user menu']"));
//        btn_profile.click();
//
//        WebElement btn_ViewProfile = driver.findElement(By.xpath("//span[normalize-space()='View Profile']"));
//        action.moveToElement(btn_ViewProfile).click().build().perform();
//
//        action.sendKeys(Keys.PAGE_DOWN).build().perform();










        //WebElement btn_expand = driver.findElement(By.xpath("//button[normalize-space()='Expand']"));
        //action.moveToElement(btn_expand).pause(Duration.ofSeconds(5)).click().build().perform();
    }
}