package Page;

import core.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

import static core.propriedadeSetup.DriverFactory.getDriver;


public class CampoTreinamentoPage extends BasePage {

    public CampoTreinamentoPage setEscrever(By by, String texto) {
        acoesElementos.escrever(by, texto);
        return this;
    }

    public void validacaoAssertObtendoTextoTela(String texto, By by) {
        Assert.assertEquals(texto, acoesElementos.obterValorCampo(by));
    }

    public CampoTreinamentoPage setClick(By by) {
        acoesElementos.clickBy(By.id("elementosForm:comidaFavorita:0"));
        return this;
    }

    public void verificarSelecao(String elemento) {
        Assert.assertTrue(acoesElementos.verificarMarcacaoId(elemento));
    }

    public CampoTreinamentoPage verificandoSelecaoCombo(String elemento, String valor) {
        acoesElementos.selecionarCombo(elemento, valor);
        return this;
    }

    public void setVerificarValoresCombo() {
        WebElement element = getDriver().findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();

        Assert.assertEquals(8, options.size());

        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals("Mestrado")) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);
    }

    public CampoTreinamentoPage setSelecionarCombo(String id, String valor) {
        acoesElementos.selecionarCombo(id, valor);
        acoesElementos.selecionarCombo(id, valor);
        acoesElementos.selecionarCombo(id, valor);
        return this;
    }

    public void setSelecionarComboEApagarItem(By by, int valor, By valorApagar, String linhaApagar, int idexApagar, String primeiroSelecionado, String segundoSelecionado) {
        //Selecionar opções do combo
        List<String> opcoesMarcadas = acoesElementos.obterValoresCombo(by);
        Assert.assertEquals(3, opcoesMarcadas.size());

        //Apagar um seleção do idex
        acoesElementos.deselecionarLinha(valorApagar, linhaApagar);
        Assert.assertEquals(idexApagar, opcoesMarcadas.size());
        Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList(primeiroSelecionado, segundoSelecionado)));
    }

    public CampoTreinamentoPage setClickComValorRetornadoTela(By by, By webElement, String texto, String atributoTela) {
        acoesElementos.clickBy(by);
        WebElement botao = getDriver().findElement(webElement);
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
        return this;
    }

    public CampoTreinamentoPage setInteracaoPorTagLinkClick(String link, String texto, By by) {
        acoesElementos.clicklinkText(link);
        Assert.assertEquals(texto, acoesElementos.obterTextoBy(by));
        return this;
    }

    public void setInteracaoPorTagClick(String tag, String texto, String resultadoTela) {
        getDriver().findElement(By.tagName(tag));
        Assert.assertEquals(texto, acoesElementos.obterTextoBy(By.className(resultadoTela)));
    }
}
