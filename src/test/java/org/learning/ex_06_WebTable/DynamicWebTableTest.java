package org.learning.ex_06_WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicWebTableTest {

    @Test
    public void testWebTable() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/webtables");

        // Add 5 employees
        addEmployee(driver, "A", "One", "a@test.com", "25", "10000", "HR");
        addEmployee(driver, "B", "Two", "b@test.com", "26", "20000", "IT");
        addEmployee(driver, "C", "Three", "c@test.com", "27", "30000", "Legal"); // 3rd = Legal
        addEmployee(driver, "D", "Four", "d@test.com", "28", "40000", "Finance");
        addEmployee(driver, "E", "Five", "e@test.com", "29", "50000", "Sales");

        Thread.sleep(2000);

        // Step 1: Get all column headers
        List<WebElement> headers = driver.findElements(By.xpath("//div[@class='rt-thead -header']//div[@class='rt-th']"));

        int deptColumnIndex = -1;

        // Step 2: Find index of "Department"
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equalsIgnoreCase("Department")) {
                deptColumnIndex = i;
                break;
            }
        }

        System.out.println("Department Column Index: " + deptColumnIndex);

        // Step 3: Get all rows
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));

        // Step 4: Loop through rows
        for (WebElement row : rows) {

            List<WebElement> cols = row.findElements(By.className("rt-td"));

            // Skip empty rows
            if (cols.size() == 0) continue;

            String dept = cols.get(deptColumnIndex).getText();

            if (dept.equalsIgnoreCase("Legal")) {

                row.findElement(By.xpath(".//span[@title='Delete']")).click();

                System.out.println("Deleted first Legal department row");
                break;
            }
        }

        Thread.sleep(2000);
        driver.quit();
    }

    public void
    addEmployee(WebDriver driver, String fn, String ln, String email,
                            String age, String salary, String dept) throws InterruptedException {

        driver.findElement(By.id("addNewRecordButton")).click();
        Thread.sleep(500);

        driver.findElement(By.id("firstName")).sendKeys(fn);
        driver.findElement(By.id("lastName")).sendKeys(ln);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(dept);

        driver.findElement(By.id("submit")).click();
    }
}
