package org.learning.ex_06_WebTable;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium_WebTable1 {
    @Test
    @Description("Test case description")
    public void test_web_table_login() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

       //  //table[@summary="Sample Table"]/tbody/tr[1]/td[1]
        Thread.sleep(2000);

        WebElement table = driver.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));

        List<WebElement> rows_table = table.findElements(By.tagName("tr"));

        for (int i=0; i < rows_table.size(); i++  ){

            List<WebElement> column_table = table.findElements(By.tagName("td"));
            for(WebElement element : column_table){
                System.out.println(element.getText());

            }



        }

        driver.quit();
    }
}
