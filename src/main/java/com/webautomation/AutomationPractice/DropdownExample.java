package com.webautomation.AutomationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownExample {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("dropdown-class-example")).click();

        driver.findElement(By.xpath("//option[@value='option1']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//option[@value='option2']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//option[@value='option3']")).click();
        driver.close();

    }
}