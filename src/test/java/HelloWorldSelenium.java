import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class HelloWorldSelenium {
    @Test
    public void hello(){
        System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
        WebDriver browser = new OperaDriver();
        String baseUrl = "http://localhost:8080";
        browser.navigate().to(baseUrl);
        browser.quit();
    }
}
