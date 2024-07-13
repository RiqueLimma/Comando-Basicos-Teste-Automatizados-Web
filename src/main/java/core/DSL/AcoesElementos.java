package core.DSL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static core.propriedadeSetup.DriverFactory.getDriver;

public class AcoesElementos {

    public void escrever(By campo, String texto){
        getDriver().findElement(campo).sendKeys(texto);
    }

    public String obterValorCampo(By campo){
        return getDriver().findElement(campo).getAttribute("value");
    }
    public String obterTextoBy(By by){
        return getDriver().findElement(by).getText();
    }

    public void clickBy(By elemento) {
        getDriver().findElement(elemento).click();
    }

    public void clicklinkText(String linkText) {
        getDriver().findElement(By.linkText(linkText)).click();
    }

    public boolean verificarMarcacaoId(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void selecionarCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public boolean retornaComecoTexto(By by, String texto) {
        return getDriver().findElement(by).getText().startsWith(texto);
    }

    public boolean retornaFinalTexto(By by, String texto) {
        return getDriver().findElement(by).getText().endsWith(texto);
    }

    public void definirBrowser(int largura, int altura) {
        getDriver().manage().window().setSize(new Dimension(largura, altura));
    }

    public String retornaTitulo() {
        return getDriver().getTitle();
    }
    public void fecharJanela() {
        getDriver().close();
    }

    public void deselecionarLinha(By by, String linha) {
        WebElement element = getDriver().findElement(by);
        Select combo = new Select(element);
        combo.deselectByVisibleText(linha);
    }

    public List<String> obterValoresCombo(By id) {
        WebElement element = getDriver().findElement(id);
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for(WebElement opcao: allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }
}
