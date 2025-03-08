package com.webautomation.AutomationPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindowExample {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("openwindow")).click();

        Set<String> windows = driver.getWindowHandles();

        System.out.println("Ini adalah windows" + windows);

        driver.switchTo().window("DF220471DCB65795E3EF30531088DA00");

        Thread.sleep(3000);
        driver.close();

        /*-------------MASIH ERROR------------- */
    }
}