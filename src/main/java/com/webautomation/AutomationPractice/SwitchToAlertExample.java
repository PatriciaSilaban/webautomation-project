package com.webautomation.AutomationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToAlertExample {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("name")).sendKeys("PATRICIA");

        driver.findElement(By.id("alertbtn")).click();

        driver.switchTo().alert().getText();

        Thread.sleep(4000);

        driver.findElement(By.id("confirmbtn")).click();

        Thread.sleep(4000);

        driver.close();
    }
}
