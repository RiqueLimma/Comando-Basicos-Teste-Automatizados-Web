package Teste.treinamento;

import core.DSL.AcoesElementos;
import core.base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static core.propriedadeSetup.DriverFactory.*;

public class TesteSincronismo extends BaseTest {

    private AcoesElementos acoesElementos;

    @Before
    public void setup() {
        componentesHTML();
        acoesElementos = new AcoesElementos();
    }

    @Test
    public void deveUtilizadaEsperaFixa() throws InterruptedException {
        acoesElementos.clickBy(By.id("buttonDelay"));
        Thread.sleep(5000);
        acoesElementos.escrever(By.id("novoCampo"), "Deu Certo?");
    }

    @Test
    public void deveUtilizarEsperaImplicita() {
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        acoesElementos.clickBy(By.id("buttonDelay"));
        acoesElementos.escrever(By.id("novoCampo"), "Deu Certo?");
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test
    public void deveUtilizadaEsperaExplicita(){
        acoesElementos.clickBy(By.id("buttonDelay"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
        acoesElementos.escrever(By.id("novoCampo"), "Deu Certo?");
    }
}
