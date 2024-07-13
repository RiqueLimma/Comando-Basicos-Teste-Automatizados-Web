package Teste.treinamento;

import Page.CadastroPage;
import core.base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static core.propriedadeSetup.DriverFactory.componentesHTML;


public class desafioFormulario extends BaseTest {

    CadastroPage page;
    @Before
    public void setup() {
        componentesHTML();
        page = new CadastroPage();
    }

    @Test
    public void cadastroFormulario() {
        page.setNome("Luis");
        page.setSobreNome("Henrique");
        page.sexoMasculino();
        page.setComidaPizza();
        page.setEscolaridade("Mestrado");
        page.setEsporte("Natacao");
        page.setCadastrar();
        Assert.assertTrue(page.setResultadoComecoTexto());
        Assert.assertTrue(page.setResultadoFinalTexto());
    }
}
