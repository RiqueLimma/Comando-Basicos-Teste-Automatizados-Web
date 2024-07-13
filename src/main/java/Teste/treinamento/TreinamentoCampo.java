package Teste.treinamento;

import Page.CampoTreinamentoPage;
import core.base.BaseTest;
import core.DSL.AcoesElementos;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static core.propriedadeSetup.DriverFactory.componentesHTML;
import static core.propriedadeSetup.DriverFactory.getDriver;

public class TreinamentoCampo extends BaseTest {

    private AcoesElementos acoesElementos;

    private CampoTreinamentoPage page;

    @Before
    public void setup() {
        componentesHTML();
        acoesElementos = new AcoesElementos();
        page = new CampoTreinamentoPage();
    }

    @Test
    public void testeTextField() {
        page.setEscrever(By.id("elementosForm:nome"), "Teste de escrita")
                .validacaoAssertObtendoTextoTela("Teste de escrita", By.id("elementosForm:nome"));
    }

    @Test
    public void deveInterirComTextArea() {
        page.setEscrever(By.id("elementosForm:sugestoes"), "teste\n\naasldjdlks\nUltima linha")
                .validacaoAssertObtendoTextoTela("teste\n\naasldjdlks\nUltima linha", By.id("elementosForm:sugestoes"));
    }

    @Test
    public void deveInterirComRadioButton() {
        acoesElementos.clickBy(By.id("elementosForm:sexo:0"));
        Assert.assertTrue(acoesElementos.verificarMarcacaoId("elementosForm:sexo:0"));
    }

    @Test
    public void deveInterirComCheck() {
        page.setClick(By.id("elementosForm:comidaFavorita:0"))
                .verificarSelecao("elementosForm:comidaFavorita:0");
    }

    @Test
    public void deveInterirComCombo() {
        page.verificandoSelecaoCombo("elementosForm:escolaridade", "Superior")
                .validacaoAssertObtendoTextoTela("superior", By.id("elementosForm:escolaridade"));
    }

    @Test
    public void deveVerificarValoresCombo() {
        page.setVerificarValoresCombo();
    }

    @Test
    public void deveVerificarValoresComboMultiplo() {
        page.setSelecionarCombo("elementosForm:esportes", "Natacao")
                .setSelecionarCombo("elementosForm:esportes", "Karate")
                .setSelecionarCombo("elementosForm:esportes", "Corrida")
                .setSelecionarComboEApagarItem(By.id("elementosForm:esportes"), 3,
                        By.id("elementosForm:esportes"), "Corrida",
                        3, "Natacao", "Karate");
    }

    @Test
    public void deveInterirComBotoes() {
        page.setClickComValorRetornadoTela(By.id("buttonSimple"), By.id("buttonSimple"),
                "Obrigado!", "value");
    }

    @Test
    public void deveInterirComLinks() {
        page.setInteracaoPorTagLinkClick("Voltar", "Voltou!", By.id("resultado"));
    }

    @Test
    public void deveBuscaTextoNaPagina() {
        page.setInteracaoPorTagClick("body", "Cuidado onde clica, muitas armadilhas...", "facilAchar");
    }

    @Test
    public void testJavaScript() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        //     js.executeScript("alert('Testando mudar elemento')");
        js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via java script'");
        js.executeScript("document.getElementById('elementosForm:sobrenome').value = 'Escrito via java script'");

        WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
        js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
    }
}