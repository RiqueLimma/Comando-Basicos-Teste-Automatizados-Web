package Teste.treinamento;

import Page.FrameEJanelasPage;
import core.base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static core.propriedadeSetup.DriverFactory.*;

public class TesteFrameEJanela extends BaseTest {

    private FrameEJanelasPage page;

    @Before
    public void setup() {
        componentesHTML();
        page = new FrameEJanelasPage();
    }


    @Test
    public void interagirFrame() {
        page.setPassandoFrame("frame1")
                .setClickFrame("frameButton")
                .setRetornandoTextoValidacao("Frame OK!")
                .setRetornandoTextoTelaCampoNome();
    }

    @Test
    public void interagirJanela() {
        page.setClick(By.id("buttonPopUpEasy"))
                .popUpComTituloVisivel("Popup")
                .escrever(By.tagName("textarea"), "Deu certo!")
                .fecharAJanela()
                .janelaVazia()
                .escrever(By.tagName("textarea"), "Deu certo!");
    }

    @Test
    public void interagirJanelaSemTitulo() {
        page.setClick(By.id("buttonPopUpHard"))
                .puxandoValorElementoEavandoPorIdex();
    }
}
