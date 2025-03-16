package automation;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webautomation.pageobjects.CartPage;
import com.webautomation.pageobjects.ConfirmationPage;
import com.webautomation.pageobjects.LandingPage;
import com.webautomation.pageobjects.OrderPage;
import com.webautomation.pageobjects.ProductListPage;

public class StandAloneTesNGImpl2Test {
    /*
     * Annotasi
     * dataprovider
     * Running testng
     */

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup Driver
        System.setProperty("webdriver.chrome.driver", "C:/afterofficebootcamp/webautomationproject/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dataProvider = "dataTestMapping")
    public void createOrder(HashMap<String, String> input) throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("userEmail"), input.get("password"));

        String productName = "ZARA COAT 3";
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(productName);

        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.verifyCheckoutProduct(productName));
        cartPage.goToCheckoutPage();

        String destination = "Indonesia";

        OrderPage orderPage = new OrderPage(driver);
        orderPage.selectCountry(destination);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(1000);

        submitButton.click();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        String confirmationText = confirmationPage.getConfirmationPage();

        Assert.assertEquals(confirmationText, "THANKYOU FOR THE ORDER.");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @DataProvider
    public Object[][] dataTest() {
        return new Object[][] {
                { "patriciasilaban99@gmail.com", "Silaban99", "ZARA COAT 3" },
        };
    }

    // Mapping
    @DataProvider
    public Object[][] dataTestMapping() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("userEmail", "patriciasilaban99@gmail.com");
        map.put("password", "Silaban99");
        map.put("productName", "ZARA COAT 3");

        return new Object[][] { { map } };
    }
}