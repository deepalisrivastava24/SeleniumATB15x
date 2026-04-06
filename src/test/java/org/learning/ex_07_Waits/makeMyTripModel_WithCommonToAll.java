package org.learning.ex_07_Waits;

import io.qameta.allure.Description;
import org.learning.CommonToAll;
import org.learning.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class makeMyTripModel_WithCommonToAll extends CommonToAll {

    @Description("Verify makemytrip opens with model")
    @Test
    public void testModelClose(){

        driver = new ChromeDriver();
        OpenBrowser(driver, "https://www.makemytrip.com/");
        waitForVisibility(driver,3,"//span[@data-cy=\"closeModal\"]");
        WaitHelper.checkVisibility(driver, By.xpath("//span[@data-cy=\"closeModal\"]"),3);
        clickFoundElement("//span[@data-cy=\"closeModal\"]");
        WaitHelper.waitJVM(10000);
        closeBrowser(driver);

    }
}
