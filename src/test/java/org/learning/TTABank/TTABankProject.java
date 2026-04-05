package org.learning.TTABank;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TTABankProject {


    @Owner("Deepali")
    @Severity(SeverityLevel.CRITICAL)
    @Description("To transfer fund")
    @Test
    public void TransferFund() throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

//        WebElement email = driver.findElement(By.xpath("//input[@type=\"email\"]"));
//        WebElement password = driver.findElement(By.xpath("//input[@type=\"password\"]"));
//        WebElement button = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
//
//        email.sendKeys(Keys.CONTROL + "a");
//        email.sendKeys(Keys.DELETE);
//        email.sendKeys("deepali.srivastava24@gmail.com");
//        password.sendKeys("12345678");
//        button.click();

        WebElement SignUpButton = driver.findElement(By.xpath("//button[text()=\"Sign Up\"]"));
        SignUpButton.click();

        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//h1[text()=\"TTA Bank\"]"));
        Assert.assertEquals(header.getText(),"TTA Bank");

        WebElement fullName = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        WebElement email = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        WebElement password = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        WebElement CreateAccountButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

        fullName.sendKeys("XYZ");
        email.sendKeys("XYZ@gmail.com");
        password.sendKeys("12345678");
        CreateAccountButton.click();

        Thread.sleep(2000);

        WebElement transferFundButton = driver.findElement(By.xpath("//button[text()=\"Transfer Funds\"]"));
        transferFundButton.click();

        WebElement InputAmount = driver.findElement(By.xpath("//input[@type=\"number\"]"));
        WebElement InputNote= driver.findElement(By.xpath("//input[@type=\"text\"]"));
        WebElement ButtonContinue = driver.findElement(By.xpath("//button[text()=\"Continue\"]"));

        InputAmount.sendKeys("5000");
        InputNote.sendKeys("rent");
        ButtonContinue.click();

        WebElement ButtonDashboard = driver.findElement(By.xpath("//button[text()=\"Dashboard\"]"));
        ButtonDashboard.click();

        WebElement title = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(title.getText(),"Dashboard");

        Thread.sleep(2000);

        driver.quit();



    }
}
