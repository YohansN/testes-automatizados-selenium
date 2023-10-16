package login;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LoginTest {

    private WebDriver browser;
    private static final String LOGIN_URL = "http://localhost:8080/login";

    @BeforeAll
    public static void setUpConfig(){
        System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
    }

    @BeforeEach
    public void setUpLoginTest(){
        this.browser = new OperaDriver();
        browser.navigate().to(LOGIN_URL);
    }

    @AfterEach
    public void quitLoginTest(){
        this.browser.quit();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos(){
        //Action
        String username = "fulano";
        String password = "pass";
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
        browser.findElement(By.id("login-form")).submit();

        //Assert
        Assertions.assertNotEquals(browser.getCurrentUrl(), LOGIN_URL);
    }

    @Test
    public void naoDeveriaEfetuarLoginComDadosInvalidos(){
        //Action
        String username = "fulano";
        String wrongPassword = "1234";
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(wrongPassword);
        browser.findElement(By.id("login-form")).submit();

        //Assert
        Assertions.assertTrue(browser.getCurrentUrl().equals(LOGIN_URL+"?error"));
        String errorMessage = "Usuário e senha inválidos.";
        Assertions.assertTrue(browser.getPageSource().contains(errorMessage));
    }
}
