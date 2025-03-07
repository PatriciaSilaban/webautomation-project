package com.webautomation.locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumintroduction {

    public static void main(String[] args) throws InterruptedException {
        // loginScenario();
        // incorrectPasswordScenario();
        loginForgotPasswordScenario();
        // loginScenariowithCheckbox();
    }

    public static void loginScenario() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        // driver.findElement(By.id("inputUsername")).sendKeys("patricia");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("patricia");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(5000);

        String name = driver.findElement(By.xpath("//h2[normalize-space()='Hello patricia,']")).getText();
        System.out.println("Ini adalah nama user " + name);
    }

    public static void incorrectPasswordScenario() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("patricia");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("nyenyenyenye");
        driver.findElement(By.className("signInBtn")).click();

        // Negative scenario using xpath n cssSleector

        // String errorMessage =
        // driver.findElement(By.xpath("//p[@class='error']")).getText();
        String errorMessage = driver.findElement(By.cssSelector("p.error")).getText(); /* using cssSelector */
        System.out.println("Ini adalah error message " + errorMessage);
        Thread.sleep(5000);

        String username = driver.findElement(By.cssSelector("#inputUsername")).getText();
        String password = driver.findElement(By.xpath("//input[@placeholder='Password']")).getText();
        System.out.println("Username " + username + " Password " + password);

        if (username == "" || password == "") {
            System.out.println("credentials are empty");
        }
        driver.quit();
    }

    public static void loginForgotPasswordScenario() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(5000);

        // Mengisi data
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Patricia Silaban");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("patriciasilaban@gmail.com");

        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        Thread.sleep(5000);

        String password = driver.findElement(By.cssSelector("p.infoMsg")).getText();
        System.out.println(password);

        // Kalau ingin mendapatkan 'rahulshettyacademy' sebagai password ingin login
        // menggunakan split per space
        String[] splitPassword = password.split("'");
        String extractedPasswrod = splitPassword[1];
        System.out.println(extractedPasswrod);

        driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("patriciasilaban@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(extractedPasswrod);

        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();

        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(5000);
        driver.quit();
    }

    public static void loginScenariowithCheckbox() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        driver.findElement(By.id("inputUsername")).sendKeys("Patricia Silaban");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();

        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(5000);

        String name = driver.findElement(By.xpath("//h2[normalize-space()='Hello patricia,']")).getText();
        System.out.println("Ini adalah nama user " + name);

        Thread.sleep(5000);
        driver.quit();
    }
}