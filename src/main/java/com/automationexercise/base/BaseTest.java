package com.automationexercise.base;

import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.framework.utils.ConfigReader;
import com.framework.utils.LogHelper;

public class BaseTest {

    protected static WebDriver driver;
    protected static Logger log = LogHelper.getLogger(BaseTest.class);

    public void setupBrowser() {
        String browser = ConfigReader.getProperty("browser");
        log.info("Initializing browser: " + browser);

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("chromeDriverPath"));
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", ConfigReader.getProperty("firefoxDriverPath"));
                driver = new FirefoxDriver();
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", ConfigReader.getProperty("edgeDriverPath"));
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        log.info("Browser setup complete");
    }

    public void teardownBrowser() {
        if (driver != null) {
            log.info("Closing browser");
            driver.quit();
        }
    }

    public void setupAPI() {
        RestAssured.baseURI = ConfigReader.getProperty("baseURI");
        RestAssured.requestSpecification = RestAssured.given()
                .contentType(ConfigReader.getProperty("contentType"));
        log.info("API setup complete: " + RestAssured.baseURI);
    }

    public void teardownAPI() {
        log.info("API teardown (if required, can be implemented)");
    }
}
