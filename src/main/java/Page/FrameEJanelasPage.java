package Page;

import core.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FrameEJanelasPage extends BasePage {


    public FrameEJanelasPage setPassandoFrame(String primeiroFrame){
        frame.passarFrame(primeiroFrame);

        return this;
    }

    public FrameEJanelasPage setClickFrame(String elemento){
        acoesElementos.clickBy(By.id(elemento));
        return this;
    }

    public FrameEJanelasPage setRetornandoTextoValidacao(String validacao){
        String msg = alertas.retornaTexto();
        Assert.assertEquals(validacao, msg);
        return this;
    }

    public FrameEJanelasPage setRetornandoTextoTelaCampoNome(){
        String msg = alertas.retornaTexto();
        alertas.aceitaAlerta();
        frame.resetFrame();
        acoesElementos.escrever(By.id("elementosForm:nome"), msg);
        Assert.assertTrue(msg.startsWith(msg));
        return this;
    }

    public FrameEJanelasPage setClick(By elemento){
        acoesElementos.clickBy(elemento);
        return this;
    }

    public FrameEJanelasPage popUpComTituloVisivel(String elemento){
        frame.popUpComTitulo(elemento);
        return this;
    }


    public FrameEJanelasPage escrever(By elemento, String texto){
        acoesElementos.escrever(elemento, texto);
        return this;
    }

    public FrameEJanelasPage fecharAJanela(){
        acoesElementos.fecharJanela();
        return this;
    }

    public FrameEJanelasPage janelaVazia(){
        frame.janelaVazia();
        return this;
    }

    public FrameEJanelasPage puxandoValorElementoEavandoPorIdex(){
        //Teste feito com janela que não tem elemento visivel na tela do F12 ou IDe Selenium
        //Foi Usada um metodos que retorna esse elemento invisivel frame.descobrirIdJanelaVazia();
        frame.descobrirIdJanelaVazia();
        frame.entrarJanelaVaziaPorIdex(1);
        acoesElementos.escrever(By.tagName("textarea"), "Deu certo!");
        frame.entrarJanelaVaziaPorIdex(0);
        acoesElementos.escrever(By.tagName("textarea"), "Pow foi !");
        return this;
    }





}
