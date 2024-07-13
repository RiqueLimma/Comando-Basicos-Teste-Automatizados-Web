package Teste.treinamento;

import core.base.BaseTest;
import core.DSL.AcoesElementos;
import core.DSL.GetLink;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static core.propriedadeSetup.DriverFactory.getDriver;

public class TesteGoogle extends BaseTest {

    private AcoesElementos acoesElementos;

    private GetLink getLink;

    @Before
    public void setup() {
        getDriver().get("https://www.google.com/");
        acoesElementos = new AcoesElementos();
        getLink = new GetLink();
    }

    @Test
    public void teste() {
        getLink.retornaLinkTeste("https://www.google.com/");
        acoesElementos.definirBrowser(1200, 765);
        Assert.assertEquals("Google", acoesElementos.retornaTitulo());
    }

}
