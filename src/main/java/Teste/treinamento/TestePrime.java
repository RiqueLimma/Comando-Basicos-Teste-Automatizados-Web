package Teste.treinamento;

import Page.PrimePage;
import core.base.BaseTest;
import core.DSL.AcoesElementos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static core.propriedadeSetup.DriverFactory.getDriver;

public class TestePrime extends BaseTest {
    private AcoesElementos acoesElementos;
    private PrimePage page;


    @Before
    public void inicializa() {
        acoesElementos = new AcoesElementos();
        page = new PrimePage();
    }

    @Test
    public void deveInteragirComRadioPrime() {
        getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
        acoesElementos.clickBy(By.xpath("//*[@id=\"j_idt247:line\"]/div[1]/div/div[2]/span"));
        Assert.assertTrue(acoesElementos.verificarMarcacaoId("j_idt247:line:0"));
        acoesElementos.clickBy(By.xpath("//*[@id=\"j_idt247:city2\"]/div[1]/div[1]/div/div[2]/span"));
        Assert.assertTrue(acoesElementos.verificarMarcacaoId("j_idt247:city2:0"));
    }

    @Test
    public void deveInteragirComSelectPrime() {
        getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=4f93f");
        page.selecionarComboPrime("j_idt247:city", "Miami");
        Assert.assertEquals("Xbox One", acoesElementos.obterTextoBy(By.id("j_idt247:city:0")));
    }
}
