package org.learning.ex_10_File_Upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab_FileUpload {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/selenium/upload.html");
        driver.manage().window().maximize();

        WebElement upload_file = driver.findElement(By.name("fileToUpload"));
        String user_dir_path = System.getProperty("user.dir");
        System.out.println("user_dir_path = " + user_dir_path);
        upload_file.sendKeys(user_dir_path+"\\src\\test\\java\\org\\learning\\File_Upload\\data.json");
        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();


    }
}
