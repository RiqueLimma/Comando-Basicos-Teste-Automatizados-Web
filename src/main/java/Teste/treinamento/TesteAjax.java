package Teste.treinamento;

import core.DSL.AcoesElementos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.propriedadeSetup.DriverFactory.getDriver;
import static core.propriedadeSetup.DriverFactory.killDriver;

public class TesteAjax {

    private AcoesElementos acoesElementos;

    @Before
    public void inicializa() {
        getDriver();
        acoesElementos = new AcoesElementos();
    }

    @After
    public void finaliza() {
        killDriver();
    }

    @Test
    public void testAjax() {
        getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=3d3cc");
        acoesElementos.escrever(By.id("j_idt246:name"), "Teste");
        acoesElementos.clickBy(By.id("j_idt246:j_idt250"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.textToBe(By.id("j_idt246:display"), "Teste"));
    }
}
