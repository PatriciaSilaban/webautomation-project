package com.webautomation.AutomationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDisplayedExample {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("hide-textbox")).click();

        if (driver.findElement(By.id("displayed-text")).isDisplayed()) {
            System.out.println("Element is displayed");
        } else {
            System.out.println("Element is not displayed");
        }
        Thread.sleep(3000);

        driver.findElement(By.id("show-textbox")).click();

        Thread.sleep(3000);

        driver.close();
    }
}