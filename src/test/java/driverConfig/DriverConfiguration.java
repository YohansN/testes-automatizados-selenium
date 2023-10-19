package driverConfig;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverConfiguration {
    protected static WebDriver browser;

    @BeforeAll
    public static void setUpDriver(){
        System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
        browser = new OperaDriver();
    }

    @AfterAll
    public static void tearDown(){
        browser.quit();
    }
}
