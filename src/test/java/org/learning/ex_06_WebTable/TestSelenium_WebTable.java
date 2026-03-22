package org.learning.ex_06_WebTable;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium_WebTable {

    @Test
    @Description("Test case description")
    public void test_web_table_login() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        //  //table[@id="customers"]/tbody/tr[5]/td[2]

        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        Integer row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        System.out.println(row.toString());
        Integer column = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();
        System.out.println(column.toString());

        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= column; j++) {

                String dynamic_Xpath = first_part + i + second_part + j + third_part;
                System.out.println(dynamic_Xpath);
                Thread.sleep(2000);

                String data = driver.findElement(By.xpath(dynamic_Xpath)).getText();
                System.out.println(data);

                if (data.contains("Helen Bennett")) {
                    String Country_Path = dynamic_Xpath + "//following-sibling::td";
                    String Country_Path_text = driver.findElement(By.xpath(Country_Path)).getText();

                    String Company_Path = dynamic_Xpath + "//preceding-sibling::td";
                    String Company_Path_text = driver.findElement(By.xpath(Company_Path)).getText();

                    System.out.println("-------");
                    System.out.println("Helen Bennett is from" + Country_Path_text + "works in company" + Company_Path_text);
                }


            }


        }
        driver.quit();
    }
}
