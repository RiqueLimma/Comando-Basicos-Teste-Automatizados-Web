package Page;

import core.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AlertaPage extends BasePage {

    public void setAlertClick(){
        acoesElementos.clickBy(By.xpath("//*[@id=\"alert\"]"));
    }

    public String aceitarAlertaObterTexto(){
        String texto = alertas.retornaTexto();
        alertas.aceitaAlerta();
        acoesElementos.escrever(By.id("elementosForm:nome"), texto);
        return texto;
    }
    public String validacaoAlerta(){
        String texto = alertas.retornaTexto();
        Assert.assertEquals("Alert Simples", texto);
        return texto;
    }

    public void fluxoPositivoConfirm(){
        acoesElementos.clickBy(By.id("confirm"));
        Assert.assertEquals("Confirm Simples", alertas.retornaTexto());
        alertas.aceitaAlerta();
        Assert.assertEquals("Confirmado", alertas.retornaTexto());
        alertas.aceitaAlerta();
    }
    public void fluxoNegativoConfirm(){
        acoesElementos.clickBy(By.id("confirm"));
        Assert.assertEquals("Confirm Simples", alertas.retornaTexto());
        alertas.cancelarAlerta();
        Assert.assertEquals("Negado", alertas.retornaTexto());
        alertas.cancelarAlerta();
    }

    public void clickValidacaoPrompt(){
        acoesElementos.clickBy(By.id("prompt"));
        Assert.assertEquals("Digite um numero", alertas.retornaTexto());
    }

    public void escreverPrompt(String valor){
        alertas.escreverAlerta(valor);
    }

    public void aceitarAlerta(){
        alertas.aceitaAlerta();
    }

    public void assertRetornandoTexto(String valor){
        Assert.assertEquals(valor, alertas.retornaTexto());
    }






}
