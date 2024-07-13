package Teste.treinamento;

import Page.JavaScriptPage;
import core.base.BaseTest;
import core.DSL.AcoesAlertas;
import core.DSL.AcoesElementos;
import core.DSL.AcoesFrame;
import core.DSL.AcoesJavaScript;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.propriedadeSetup.DriverFactory.*;

public class TesteJavaScript extends BaseTest {

    private AcoesElementos acoesElementos;

    private AcoesFrame acoesFrame;

    private AcoesAlertas alertas;

    private AcoesJavaScript javaScript;

    private JavaScriptPage page;

    @Before
    public void setup() {
        componentesHTML();
        page = new JavaScriptPage();
        acoesElementos = new AcoesElementos();
        acoesFrame = new AcoesFrame();
        alertas = new AcoesAlertas();
        javaScript = new AcoesJavaScript();
    }
    @Test
    public void testJavascript() {
        page.setExecuteJsComBordaMarcada();
    }

    @Test
    public void testInteracaoFrameEscondido() {
        WebElement frame = getDriver().findElement(By.id("frame2"));
        //scroll ate op elemento via java script
        javaScript.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
        acoesFrame.passarFrame("frame2");
        acoesElementos.clickBy(By.id("frameButton"));


        String msg = alertas.alertaObterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);


    }
}