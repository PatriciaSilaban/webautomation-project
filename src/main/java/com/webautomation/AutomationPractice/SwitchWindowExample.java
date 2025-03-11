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

        // Menyimpan window handle awal
        String originalWindow = driver.getWindowHandle();

        // Tombol untuk membuka window baru
        driver.findElement(By.id("openwindow")).click();

        // Mendapatkan semua window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Cetak semua window handles untuk debugging
        System.out.println("Window Handles: " + windowHandles);

        // Berpindah ke window baru (yang bukan original window)
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        Thread.sleep(5000);

        driver.close();

        driver.switchTo().window(originalWindow);
        Thread.sleep(4000);

        driver.quit();
    }
}