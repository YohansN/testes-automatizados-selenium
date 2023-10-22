package leiloes;

import driverConfig.DriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LeiloesPage {
    private WebDriver browser;
    private static final String CADASTRO_LEILAO_PAGE_URL = "http://localhost:8080/leiloes/new";

    public LeiloesPage(WebDriver browser){
        this.browser = browser;
    }
    public void navegarParaPaginaCadastroLeiloes(){
        browser.navigate().to(CADASTRO_LEILAO_PAGE_URL);
    }

    public void fecharPagina(){
        browser.quit();
    }

    public void cadastrarLeilao(String nome, Double valor, String data){
        browser.findElement(By.id("nome")).sendKeys(nome);
        browser.findElement(By.id("valorInicial")).sendKeys(valor.toString());
        browser.findElement(By.id("dataAbertura")).sendKeys(data);
        browser.findElement(By.className("card-body")).submit();
    }

    public boolean isLeiloesPage(){
        return browser.getCurrentUrl().equals("http://localhost:8080/leiloes");
    }

    public boolean isNewLeilao(String nome, Double valor, String data){
        String svalor = valor.toString();
        return browser.getPageSource().contains(nome) && browser.getPageSource().contains(svalor) && browser.getPageSource().contains(data);
    }

    public boolean isNomeWarningsOnPage(){
        String nomeWarning1 = "minimo 3 caracteres";
        String nomeWarning2 = "não deve estar em branco";
        return browser.getPageSource().contains(nomeWarning1) || browser.getPageSource().contains(nomeWarning2);
    }

    public boolean isValorWarningOnPage(){
        String valorWarning = "deve ser um valor maior de 0.1";
        return browser.getPageSource().contains(valorWarning);
    }

    public boolean isDataWarningOnPage(){
        String dataWarning = "deve ser uma data no formato dd/MM/yyyy";
        return browser.getPageSource().contains(dataWarning);
    }
}
