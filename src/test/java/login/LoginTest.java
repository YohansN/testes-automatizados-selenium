package login;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeEach
    public void beforeEach(){
        loginPage = new LoginPage();
        loginPage.navegarParaPaginaLogin();
    }

    @AfterEach
    public void quitLoginTest(){
        loginPage.fecharPagina();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos(){
        //Action
        loginPage.preencheFormularioValido();
        loginPage.submeteFormulario();

        //Assert
        Assertions.assertFalse(loginPage.isLoginPage());
    }

    @Test
    public void naoDeveriaEfetuarLoginComDadosInvalidos(){
        //Action
        loginPage.preencheFormularioInvalido();
        loginPage.submeteFormulario();

        //Assert
        Assertions.assertFalse(loginPage.isLoginPage());
        Assertions.assertTrue(loginPage.isLoginErrorPage());
        Assertions.assertTrue(loginPage.contemMensagemDeErro());
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaDeslogado(){
        //Action
        loginPage.navegaParaPaginaDeLances();

        //Assert
        Assertions.assertTrue(loginPage.isLoginPage());
    }
}
