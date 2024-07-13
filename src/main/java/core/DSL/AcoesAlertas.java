package core.DSL;

import org.openqa.selenium.Alert;

import static core.propriedadeSetup.DriverFactory.getDriver;

public class AcoesAlertas {
    
    
    public void aceitaAlerta(){
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public String alertaObterTextoEAceita(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;
    }

    public void cancelarAlerta(){
        Alert alert = getDriver().switchTo().alert();
        alert.dismiss();
    }

    public void escreverAlerta(String valor){
        Alert alert = getDriver().switchTo().alert();
       alert.sendKeys(valor);
    }

    public String retornaTexto(){
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }
}
