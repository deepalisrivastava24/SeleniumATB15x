package org.learning.ex_08_SVG_Elements;

import io.qameta.allure.Description;
import org.learning.CommonToAll;
import org.learning.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.List;

public class SVG_Project_FlipKart extends CommonToAll {

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

        List<WebElement> productTitle = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MP')]/div/a[2]"));
//        for (WebElement title : titleResult) {
//            System.out.println(title.getText());
//        }

        List<WebElement> productPrice = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MP')]/div/a[3]"));
//        for (WebElement price : elementPrice) {
//            System.out.println(price.getText());
//        }

        Long cheapestPrice = Long.MAX_VALUE;
        String cheapestProduct = "";
        String cheapestPriceString = "";


        for(int i = 0; i < Math.min(productTitle.size(),productPrice.size()); i++){

            String title = productTitle.get(i).getText();
            String price = productPrice.get(i).getText();

            if (price.isEmpty() || title.isEmpty()) continue;

            System.out.println("Product Title: " + title);
            System.out.println("Product Price: " + price);
            System.out.println("--------------------------------------------------------------");

            try {
                // regex [^\\d] removes everything except numbers
                String sanitizedPrice = price.replaceAll("[^\\d]", "");

                if (!sanitizedPrice.isEmpty()) {
                    long priceValue = Long.parseLong(sanitizedPrice);


                    if (priceValue < cheapestPrice) {
                        cheapestPrice = priceValue;
                        cheapestProduct = title;
                        cheapestPriceString = price;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Skipping item due to invalid price format.");
            }
        }
        System.out.println("*************************************************");
        System.out.println("Cheapest Product: " + cheapestProduct);
        System.out.println("Cheapest Price: ₹" + cheapestPriceString);

        WaitHelper.waitJVM(2);

        closeBrowser(driver);



    }
}
