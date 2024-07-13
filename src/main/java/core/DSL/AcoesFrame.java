package core.DSL;

import org.openqa.selenium.WebDriver;

import static core.propriedadeSetup.DriverFactory.getDriver;

public class AcoesFrame {
    

    public void  passarFrame(String frame) {
        getDriver().switchTo().frame(frame);
    }

    public void  resetFrame() {
        getDriver().switchTo().defaultContent();
    }

    public void  popUpComTitulo(String popUp) {
        getDriver().switchTo().window(popUp);
    }

    public void  janelaVazia() {
        getDriver().switchTo().window("");;
    }

    public void  descobrirIdJanelaVazia() {
        //Decobrir o id sem titulo
        System.out.println(getDriver().getWindowHandle());
        System.out.println(getDriver().getWindowHandles());
    }

    public void  entrarJanelaVaziaPorIdex(int valor) {
        getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[valor]);
    }





}
