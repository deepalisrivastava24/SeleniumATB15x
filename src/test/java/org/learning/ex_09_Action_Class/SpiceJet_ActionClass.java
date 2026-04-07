package org.learning.ex_09_Action_Class;


import io.qameta.allure.Description;
import org.learning.CommonToAll;
import org.learning.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SpiceJet_ActionClass extends CommonToAll {


    @Description("To verify action classes")
    @Test
    public void test_spiceJet_ActionClass(){

        driver = new ChromeDriver();
        OpenBrowser(driver,"https://www.spicejet.com");

        //WaitHelper.explicitWait(driver,10);

        WebElement origin = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));
        WebElement destination = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div/div/input"));

        Actions actions = new Actions(driver);

        actions.moveToElement(origin).click().sendKeys("BLR")
                .moveToElement(destination).click().sendKeys("DEL").build().perform();




        closeBrowser(driver);




    }

}
