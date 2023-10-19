package leiloes;

import driverConfig.DriverConfiguration;
import login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeiloesTest extends DriverConfiguration {
    private LeiloesPage paginaDeLeiloes;

    @AfterEach
    public void afterEach(){
        this.paginaDeLeiloes.fecharPagina();
    }

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage(browser);
        paginaDeLogin.navegarParaPaginaLogin();
        paginaDeLogin.preencheFormularioValido();
        paginaDeLogin.submeteFormulario();

        this.paginaDeLeiloes = new LeiloesPage(browser);
        this.paginaDeLeiloes.navegarParaPaginaCadastroLeiloes();
    }

    @Test
    public void deveriaCadastrarLeilao(){
        this.paginaDeLeiloes.preencheFormularioValido();
        this.paginaDeLeiloes.submeteFormulario();
    }


}
