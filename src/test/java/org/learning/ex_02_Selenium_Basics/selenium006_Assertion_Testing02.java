package org.learning.ex_02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class selenium006_Assertion_Testing02 {

    @Test
    public void test_selenium_01(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals(driver.getTitle(), "CURA Healthcare Service");

        driver.quit();
    }

    @Test
    public void test_selenium_02(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
        Assert.assertEquals(driver.getTitle(), "CURA Healthcare Service");

        driver.quit();

    }

    @Test
    public void test_selenium_03(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");


        //assertThat(driver.getTitle()).isEqualTo("CURA Healthcare Service");

        assertThat(driver.getTitle())
                .isNotBlank()
                .isNotEmpty()
                .isNotNull()
                .isEqualTo("CURA Healthcare Service");

        driver.quit();


    }

}
