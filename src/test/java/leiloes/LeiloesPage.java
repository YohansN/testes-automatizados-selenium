package leiloes;

import driverConfig.DriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LeiloesPage {
    private WebDriver browser;
    private static final String CADASTRO_LEILAO_PAGE_URL = "http://localhost:8080/leiloes/new";
    //Massa de Dados
    private static final String NOME_VALIDO = "Fernando Pessoa";
    private static final Double VALORI_INICIAL_VALIDO = 100.0;
    private static final String DATA_ABERTURA_VALIDA = "01/10/2023";

    public LeiloesPage(WebDriver browser){
        this.browser = browser;
    }
    public void navegarParaPaginaCadastroLeiloes(){
        browser.navigate().to(CADASTRO_LEILAO_PAGE_URL);
    }

    public void fecharPagina(){
        browser.quit();
    }

    public void preencheFormularioValido(){
        browser.findElement(By.id("nome")).sendKeys(NOME_VALIDO);
        browser.findElement(By.id("valorInicial")).sendKeys(VALORI_INICIAL_VALIDO.toString());
        browser.findElement(By.id("dataAbertura")).sendKeys(DATA_ABERTURA_VALIDA);
    }

    public void preencheFormularioInvalido(){

    }

    public void submeteFormulario(){
        browser.findElement(By.tagName("form")).submit();
    }

    //public boolean isLeiloesPage(){
        //return browser.getCurrentUrl().equals();
    //}
}
