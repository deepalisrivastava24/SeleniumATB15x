package org.learning.Selenium_VWO_Project;

import io.qameta.allure.Description;
import org.learning.CommonToAll;
import org.learning.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Selenium_VWO_Project extends CommonToAll {

    @Description("Verify full flow of VWO")
    @Test
    public void test_VWO_Project() {

        //*********** OPEN BROWSER ***********//

        driver = new ChromeDriver();
        OpenBrowser(driver, "https://app.vwo.com/#/login");

        WaitHelper.checkVisibility(driver, By.xpath("//span[text()='Start a FREE TRIAL']"), 5);

        clickFoundElement("//span[text()='Start a FREE TRIAL']");
        //WebElement btn_FreeTrail =  driver.findElement(By.xpath("//span[text()='Start a FREE TRIAL']"));
        //btn_FreeTrail.click();

        //*********** WINDOW SWITCH ***********//

        String Parent_id = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window_name : allWindows) {
            driver.switchTo().window(window_name);
        }

        //***********  CREATE FREE TRIAL ACCOUNT PAGE  ***********//

        Actions actions = new Actions(driver);
        WebElement txt_BusinessEmail = driver.findElement(By.id("page-v1-step1-email"));
        actions.moveToElement(txt_BusinessEmail)
                .click()
                .sendKeys("abc@gmail.com")
                .build()
                .perform();

        waitForVisibility(driver, 5, "//*[contains(text(),'business domain')]");
        WebElement validation = driver.findElement(By.xpath("//*[contains(text(),'business domain')]"));
        String validation_text = validation.getText().trim();
        Assert.assertTrue(validation_text.contains("business domain"));

        WaitHelper.waitJVM(5000);

        //actions.moveToElement(txt_BusinessEmail).build().perform();
        txt_BusinessEmail.clear();
        txt_BusinessEmail.sendKeys("Teep02@abc.com");


        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();

        WebElement btn_TrailAccount = driver.findElement(By.xpath("//button[@data-qa='page-su-submit']"));
        btn_TrailAccount.click();



        WaitHelper.waitJVM(5000);

        //***********CLOSE COOKIES BANNER ***********//
        WaitHelper.waitForVisibilityAndClick(driver,3,"//button[@aria-label='Close']");

        //***********SIGN UP PAGE ***********//
        WebElement txt_FirstName = driver.findElement(By.xpath("//input[@data-qa='page-su-v1-fname']"));
        txt_FirstName.sendKeys("Teepu");

        WebElement txt_LastName = driver.findElement(By.xpath("//input[@data-qa='page-su-v1-lname']"));
        txt_LastName.sendKeys("xyz");

        WebElement txt_PhoneNo = driver.findElement(By.xpath("//input[@data-qa='page-su-v1-pnumber']"));
        txt_PhoneNo.clear();
        txt_PhoneNo.sendKeys("9600164955");

        WaitHelper.checkVisibility(driver,By.xpath("//button[contains(text(),'Create Account')]"),5);
        WebElement btn_CreateAccount = driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));

//        actions.moveToElement(btn_CreateAccount)
//                .click()
//                .build()
//                .perform();
        btn_CreateAccount.click();

        //***********CLICK ON SKIP BUTTON ***********//
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-step='free-trial-thankyou']"))).click();



        //***********SET-UP YOUR ACCOUNT PAGE ***********//

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='boxasuraza']"))).click();

        //***********CLICK ON START A FREE TRAIL ***********//

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@data-qa='cunoxonoxe'])[2]"))).click();

//        WaitHelper.waitForVisibilityAndClick(driver,5000,"(//button[@data-qa='cunoxonoxe'])[2]");

//        //***********CLICK ON ADD DOMAIN BTN ***********//
//        WaitHelper.waitJVM(5000);
//        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//        WaitHelper.waitForVisibilityAndClick(driver, 5000,"//button[contains(text(),'Add domain')]");

    }
}


