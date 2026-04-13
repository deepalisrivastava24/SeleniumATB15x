package org.learning.ex_11_Input_Select_Alerts;

import io.qameta.allure.Description;
import org.learning.CommonToAll;
import org.learning.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dropdown_Static extends CommonToAll {

    @Description("Verify the input select fields")
    @Test
    public void test_select(){

        driver = new ChromeDriver();

        OpenBrowser(driver,"https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        //select.selectByVisibleText("Option 2");
        select.selectByIndex(1);
        WaitHelper.waitJVM(1000);

        closeBrowser(driver);

    }
}
