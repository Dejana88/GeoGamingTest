package pages;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Hooks {

    public static WebDriver driver;

    private By acceptCookies = By.className("consent-give");

    public WebElement getAcceptCookies() {
        return driver.findElement(acceptCookies);
    }

    @Before
    public void setupBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://en.sportingbull.com/sportsbook");
        getAcceptCookies().click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


