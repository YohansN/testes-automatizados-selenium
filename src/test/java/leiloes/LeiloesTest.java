package leiloes;

import driverConfig.DriverConfiguration;
import login.LoginPage;
import org.junit.jupiter.api.*;

public class LeiloesTest extends DriverConfiguration {
    private LeiloesPage paginaDeLeiloes;

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
        //setup
        String nome = "produto 2";
        Double valor = 200.00;
        String data = "22/10/2023";

        //Action
        this.paginaDeLeiloes.cadastrarLeilao(nome, valor, data);

        //Assert
        Assertions.assertTrue(this.paginaDeLeiloes.isLeiloesPage());
        Assertions.assertFalse(!this.paginaDeLeiloes.isLeiloesPage());
        Assertions.assertTrue(this.paginaDeLeiloes.isNewLeilao(nome, valor, data));
    }

    @Test
    public void naoDeveriaCadastrarLeilaoVazio(){
        //setup
        String nome = "";
        Double valor = 1.0;
        String data = "";

        //Action
        this.paginaDeLeiloes.cadastrarLeilao(nome, valor, data);

        //Assert
        Assertions.assertTrue(this.paginaDeLeiloes.isLeiloesPage());
        Assertions.assertTrue(this.paginaDeLeiloes.isNomeWarningsOnPage());
        Assertions.assertTrue(this.paginaDeLeiloes.isDataWarningOnPage());
    }

    @Test
    public void naoDeveriaCadastrarLeilaoEmBranco(){
        //setup
        String nome = " ";
        Double valor = 0.1;
        String data = " ";

        //Action
        this.paginaDeLeiloes.cadastrarLeilao(nome, valor, data);

        //Assert
        Assertions.assertTrue(this.paginaDeLeiloes.isLeiloesPage());
        Assertions.assertTrue(this.paginaDeLeiloes.isNomeWarningsOnPage());
        Assertions.assertTrue(this.paginaDeLeiloes.isDataWarningOnPage());
    }

    @Test
    public void naoDeveriaCadastrarLeilaoComNomeMenorQueOMinimo(){
        //setup
        String nome = "OI";
        Double valor = 10.50;
        String data = "10/10/2023";

        //Action
        this.paginaDeLeiloes.cadastrarLeilao(nome, valor, data);

        //Assert
        Assertions.assertTrue(this.paginaDeLeiloes.isLeiloesPage());
        Assertions.assertTrue(this.paginaDeLeiloes.isNomeWarningsOnPage());
    }

    @Test
    public void naoDeveriaCadastrarLeilaoComValorNegativo(){
        //setup
        String nome = "Teste 3";
        Double valor = -3.0;
        String data = "10/10/2023";

        //Action
        this.paginaDeLeiloes.cadastrarLeilao(nome, valor, data);

        //Assert
        Assertions.assertTrue(this.paginaDeLeiloes.isLeiloesPage());
        Assertions.assertTrue(this.paginaDeLeiloes.isValorWarningOnPage());
    }

    @Test
    public void naoDeveriaCadastrarLeilaoDataNaoFormatada(){
        //setup
        String nome = "Produto 2";
        Double valor = 12.0;
        String data = "10102023";

        //Action
        this.paginaDeLeiloes.cadastrarLeilao(nome, valor, data);

        //Assert
        Assertions.assertTrue(this.paginaDeLeiloes.isLeiloesPage());
        Assertions.assertTrue(this.paginaDeLeiloes.isDataWarningOnPage());
    }

    @Test
    public void naoDeveriaCadastrarLeilaoDataImpossivel(){
        //setup
        String nome = "Produto 2";
        Double valor = 12.0;
        String data = "43/89/2003";

        //Action
        this.paginaDeLeiloes.cadastrarLeilao(nome, valor, data);

        //Assert
        Assertions.assertTrue(this.paginaDeLeiloes.isLeiloesPage());
        Assertions.assertTrue(this.paginaDeLeiloes.isDataWarningOnPage());
    }

}
