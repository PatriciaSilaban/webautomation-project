package com.webautomation.AutomationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableFIxedHeader {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Mengambil teks dari baris kedua, kolom pertama dari tabel "Web Table Fixed
        // header"
        String data = driver.findElement(By.xpath("//div[@class='tableFixHead']/table/tbody/tr[2]/td[1]")).getText();
        System.out.println("Ini adalah data nya " + data);
        Thread.sleep(4000);
        driver.close();
    }
}
