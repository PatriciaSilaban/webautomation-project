package com.webautomation.locator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorPractice {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(5000);

        // SELECT CURRENCY FEATURE
        WebElement staticDropdown = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));

        Select dropdown = new Select(staticDropdown);
        System.out.println("All option " + dropdown.getAllSelectedOptions().size());
        System.out.println("First option: " + dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("AED");
        System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());

        // Thread.sleep(5000);

        dropdown.selectByValue("USD");

        dropdown.selectByIndex(1);

        // Thread.sleep(5000);

        /*
         * Handle dynamic dropdown PASSENGER Feauture
         */

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        /*
         * Menambahkan passenger (adult)
         */
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        /*
         * Menambahkan passenger (child)
         */
        for (int i = 1; i < 3; i++) {
            driver.findElement(By.id("hrefIncChd")).click();
        }
        /*
         * Menambahkan passenger (infant)
         */
        for (int i = 1; i < 2; i++) {
            driver.findElement(By.id("hrefIncInf")).click();
        }
        /*
         * Mengurangi passenger (adult)
         */
        for (int i = 1; i < 3; i++) {
            driver.findElement(By.id("hrefDecAdt")).click();
            Thread.sleep(4000);
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(4000);

        /*
         * Scenario select FROM
         * DELHI =
         * //div[@id="dropdownGroup1"]//child[@class="dropdownDiv"]//child::ul[1]//child
         * ::li//child::a[@value="DEL"]
         */
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        // // kurang efisien digunakan karena tidak dynamic (akan selalu mengganti
        // xpathnya)
        // driver.findElement(By.xpath(
        // "//div[@id='dropdownGroup1']//div[@class='dropdownDiv']//ul[1]//li//a[@value='DEL']")).click();

        // CARA LAIN UNTUK SCENARIO SELECT FROM
        List<WebElement> options = driver
                .findElements(By.xpath(
                        "//div[@id='dropdownGroup1']//child::div[@class='dropdownDiv']//child::ul[1]//child::li"));
        System.out.println("Ini adalah options" + options);

        for (WebElement element : options) {
            System.out.println("List country" + element.getText());
            if (element.getText().equals("Adampur (AIP)"))
                element.click();
            break;
        }
        Thread.sleep(4000);

        // // SCENARIO SELECT TO (KALAU MENGGUNAKAN XPATH)
        // driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        // driver.findElement(By.xpath(
        // "//div[@id='dropdownGroup1']//div[@class='dropdownDiv']//child::ul[1]//child::li//child::a[@value='MAA']"))
        // .click();
        // Thread.sleep(2000);

        // // CARA LAIN UNTUK SCENARIO SELECT TO
        List<WebElement> options1 = driver.findElements(
                By.xpath("//div[@id='dropdownGroup1']//div[@class='dropdownDiv']//child::ul[1]//child::li"));
        System.out.println("Ini adalah options" + options1);

        for (WebElement element : options1) {
            System.out.println("List country" + element.getText());
            if (element.getText().equals("Chennai (MAA)"))
                element.click();
            break;
        }

        // --------------------------***----------------------------//
        // ANW UNTUK SELECT TO MASIH ERROR SAAT DI RUN //

        // SCENARIO RADIO BUTTON
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        Thread.sleep(4000);
        driver.close();
    }
}
