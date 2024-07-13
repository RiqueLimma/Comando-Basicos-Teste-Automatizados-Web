package Teste.treinamento;

import Page.AlertaPage;
import core.base.BaseTest;
import org.junit.Before;
import org.junit.Test;

import static core.propriedadeSetup.DriverFactory.componentesHTML;

public class TesteAlert extends BaseTest {

    AlertaPage page;

    @Before
    public void setup() {
        componentesHTML();
        page = new AlertaPage();
    }

    @Test
    public void deveInteragirAlert() {
        page.setAlertClick();
        page.aceitarAlertaObterTexto();
    }

    @Test
    public void deveInteragirAlertConfirm() {
        page.fluxoPositivoConfirm();
        page.fluxoNegativoConfirm();
    }

    @Test
    public void deveInteragirAlertPrompt() {
        page.clickValidacaoPrompt();
        page.escreverPrompt("12");
        page.aceitarAlerta();
        page.assertRetornandoTexto("Era 12?");
        page.aceitarAlerta();
        page.assertRetornandoTexto(":D");
    }
}
