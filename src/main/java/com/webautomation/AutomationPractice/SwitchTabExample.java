package com.webautomation.AutomationPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchTabExample {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Menyimpan Window Handle (ID tab pertama)
        String originalWindow = driver.getWindowHandle();

        // Tombol untuk membuka tab baru
        driver.findElement(By.xpath("//a[@id='opentab']")).click();
        Thread.sleep(5000);

        // Mendapatkan semua window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Berpindah ke tab baru
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        Thread.sleep(2000);

        // Tutup tab baru
        driver.close();

        // Kembali ke tab awal
        driver.switchTo().window(originalWindow);
        Thread.sleep(2000);

        // Tutup browser
        driver.quit();
    }
}
