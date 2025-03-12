package com.webautomation.scenario;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
        /*
         * 1. Implement e2e test for checkout
         * 2. Wait != Thread
         * Stream
         */

        /*
         * Scenario Automation
         * 1. Buyer login
         * 2. Buyer checkout product
         * 3. Verifikasi thanks page
         */

        // Setup Driver
        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));

        // Scenario Login
        driver.findElement(By.id("userEmail")).sendKeys("patriciasilaban99@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Silaban99");

        driver.findElement(By.id("login")).click();

        Thread.sleep(5000);

        // List Product

        List<WebElement> listProduct = driver.findElements(By.cssSelector(".mb-3"));

        String productName = "ZARA COAT 3";

        WebElement product = listProduct.stream()
                .filter(prod -> prod.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
                .orElse(null);

        product.findElement(
                By.xpath("//div[@class='card-body']//child::button//child::i[@class='fa fa-shopping-cart']")).click();

        System.out.println("list product" + product);

        Thread.sleep(3000);

        // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//ngx-spinner[@class
        // = 'ng-star-inserted']"))));

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        Thread.sleep(4000);

        driver.findElement(By.cssSelector(".totalRow button"));

        // driver.findElement(By.cssSelector("[placeholder = 'Select
        // Country']")).sendKeys("Indonesia");

        // CARA LAIN UNTUK SELECT COUNTRY NYA

        Actions action = new Actions(driver);

        action.sendKeys(driver.findElement(By.cssSelector("[placeholder = 'Select Country']")), "ind").build()
                .perform();

        Thread.sleep(3000);

        String destination = "Indonesia";

        List<WebElement> country = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));

        // System.out.println(country.get(0).getText());

        // // MENGGUNAKAN LOOPING

        // for (WebElement cont : country) {
        // if (cont.getText().equalsIgnoreCase(destination)) {
        // cont.click();
        // break;
        // }
        // }

        // MENGGUNAKAN STREAM

        WebElement cont = country.stream().filter(cont2 -> cont2.getText().equalsIgnoreCase(destination)).findFirst()
                .orElse(null);
        cont.click();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".action__submit")).click();

        Thread.sleep(3000);

        String confirmationPage = driver.findElement(By.className("hero-primary")).getText();

        System.out.println("Buyer berhasil checkout " + confirmationPage);

        Thread.sleep(3000);

        driver.close();

    }
}