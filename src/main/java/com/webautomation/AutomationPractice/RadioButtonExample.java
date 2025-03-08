package com.webautomation.AutomationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonExample {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        /*
         * RADIO BUTTON EXAMPLE
         */

        driver.findElement(By.xpath("(//input[@value='radio1'])[1]")).click();

        driver.findElement(By.xpath("(//input[@value='radio2'])[1]")).click();

        driver.findElement(By.xpath("(//input[@value='radio3'])[1]")).click();

        driver.close();
    }
}
