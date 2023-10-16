package login;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LoginTest {
    @Test
    public void deveriaEfetuarLoginComDadosValidos(){
        //Set
        System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
        WebDriver browser = new OperaDriver();
        String baseUrl = "http://localhost:8080/login";
        browser.navigate().to(baseUrl);

        //Action
        String username = "fulano";
        String password = "pass";
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
        browser.findElement(By.id("login-form")).submit();

        //Assert
        Assert.assertNotEquals(browser.getCurrentUrl(), baseUrl);

        browser.quit();
    }
}
