package com.webautomation.AutomationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxExample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("checkBoxOption1")).click();
        Thread.sleep(4000);

        driver.findElement(By.id("checkBoxOption2")).click();
        Thread.sleep(4000);

        driver.findElement(By.id("checkBoxOption3")).click();
        Thread.sleep(4000);

        driver.close();
    }
}
