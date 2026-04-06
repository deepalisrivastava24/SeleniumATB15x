package org.learning.ex_08_SVG_Elements;

import io.qameta.allure.Description;
import org.learning.CommonToAll;
import org.learning.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;



public class SVG_Elements extends CommonToAll {

    @Description("To verrify svg element on Flipcart website")
    @Test
    public void flipKart_svg(){
        driver = new ChromeDriver();
        OpenBrowser(driver, "https://www.flipkart.com/search");

        WebElement search_input = driver.findElement(By.name("q"));
        search_input.sendKeys("macmini");

        List<WebElement> elements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        elements.get(0).click();

        WaitHelper.checkVisibility(driver, By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MP')]/div/a[2]"));

        List<WebElement> titleResult = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MP')]/div/a[2]"));
        for (WebElement title : titleResult) {
            System.out.println(title.getText());
        }

        WaitHelper.waitJVM(2);

        closeBrowser(driver);



    }
}
