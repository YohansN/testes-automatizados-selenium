package login;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LoginPage {
    public WebDriver browser;
    public static final String LOGIN_PAGE_URL = "http://localhost:8080/login";
    public static final String LOGIN_PAGE_ERROR_URL = "http://localhost:8080/login?error";
    private static final String USERNAME_VALID = "fulano";
    private static final String PASSWORD_VALID = "pass";
    private static final String USERNAME_INVALID = "pass";
    private static final String PASSWORD_INVALID = "123";

    public LoginPage(WebDriver browser){
        this.browser = browser;
    }

    public void navegarParaPaginaLogin(){
        browser.navigate().to(LOGIN_PAGE_URL);
    }

    public void fecharPagina(){
        browser.quit();
    }

    public void preencheFormularioValido(){
        browser.findElement(By.id("username")).sendKeys(USERNAME_VALID);
        browser.findElement(By.id("password")).sendKeys(PASSWORD_VALID);

    }

    public void preencheFormularioInvalido(){
        browser.findElement(By.id("username")).sendKeys(USERNAME_VALID);
        browser.findElement(By.id("password")).sendKeys(PASSWORD_INVALID);
    }

    public void submeteFormulario(){
        browser.findElement(By.id("login-form")).submit();
    }

    public boolean isLoginPage(){
        return browser.getCurrentUrl().equals(LOGIN_PAGE_URL);
    }

    public boolean isLoginErrorPage(){
        return browser.getCurrentUrl().equals(LOGIN_PAGE_ERROR_URL);
    }

    public boolean contemMensagemDeErro(){
        String errorMessage = "Usuário e senha inválidos.";
        return browser.getPageSource().contains(errorMessage);
    }

    public void navegaParaPaginaDeLances(){
        browser.navigate().to("http://localhost:8080/leiloes/2");
    }
}
