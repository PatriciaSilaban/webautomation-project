package automation;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StandAloneTestNGImplTest {
        /*
         * Annotation
         * dataprovider
         * Running testng
         */

        public WebDriver driver;

        @BeforeMethod
        public void setUp() {
                // Setup Driver
                System.setProperty("webdriver.chrome.driver",
                                "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

                driver = new ChromeDriver();
                driver.get("https://rahulshettyacademy.com/client");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }

        @Test(dataProvider = "dataTestMapping")
        // public void createOrder(String email, String password, String productName)
        // throws InterruptedException {

        // CARA MANGGIL KALAU PAKAI MAPPING

        public void createOrder(HashMap<String, String> input) throws InterruptedException {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));

                // Scenario Login
                // driver.findElement(By.id("userEmail")).sendKeys(email);
                // driver.findElement(By.id("userPassword")).sendKeys(password);

                // UNTUK MAPPING
                driver.findElement(By.id("userEmail")).sendKeys(input.get("email"));
                driver.findElement(By.id("userPassword")).sendKeys(input.get("password"));

                driver.findElement(By.id("login")).click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

                // List Product

                List<WebElement> listProduct = driver.findElements(By.cssSelector(".mb-3"));

                // WebElement product = listProduct.stream()
                // .filter(prod ->
                // prod.findElement(By.cssSelector("b")).getText().equals(productName))
                // .findFirst()
                // .orElse(null);
                System.out.println("hasil" + input.get("productName"));

                // UNTUK MAPPING
                WebElement product = listProduct.stream()
                                .filter(prod -> prod.findElement(By.cssSelector("b")).getText()
                                                .equals(input.get("productName")))
                                .findFirst()
                                .orElse(null);

                product.findElement(By.xpath(
                                "//div[@class='card-body']//child::button//child::i[@class='fa fa-shopping-cart']"))
                                .click();

                System.out.println("list product" + product);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

                // wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//ngx-spinner[@class
                // = 'ng-star-inserted']"))));
                Thread.sleep(3000);

                driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));

                driver.findElement(By.cssSelector(".totalRow button")).click();

                // driver.findElement(By.cssSelector("[placeholder = 'Select
                // Country']")).sendKeys("Indonesia");

                wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.cssSelector("[placeholder = 'Select Country']")));

                // CARA LAIN UNTUK SELECT COUNTRY NYA

                Actions action = new Actions(driver);

                action.sendKeys(driver.findElement(By.cssSelector("[placeholder = 'Select Country']")), "ind").build()
                                .perform();

                wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.xpath("//span[@class='ng-star-inserted']")));

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

                WebElement cont = country.stream().filter(cont2 -> cont2.getText().equalsIgnoreCase(destination))
                                .findFirst().orElse(null);

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cont);
                Thread.sleep(500);

                cont.click();

                driver.findElement(By.cssSelector(".action__submit")).click();

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hero-primary")));

                String confirmationPage = driver.findElement(By.className("hero-primary")).getText();

                System.out.println("Buyer berhasil checkout " + confirmationPage);

                Thread.sleep(3000);

                driver.close();

        }

        @AfterMethod
        public void tearDown() {
                if (driver != null) {
                        driver.quit();
                }
        }

        @DataProvider
        public Object[][] dataTest() {
                return new Object[][] { { "patriciasilaban99@gmail.com", "Silaban99", "ZARA COAT 3" } };
        }

        // CARA 2 dengan membuuat Mapping
        @DataProvider
        public Object[][] dataTestMapping() {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("email", "patriciasilaban99@gmail.com");
                map.put("password", "Silaban99");
                map.put("productName", "ZARA COAT 3");
                return new Object[][] { { map } };
        }
}
