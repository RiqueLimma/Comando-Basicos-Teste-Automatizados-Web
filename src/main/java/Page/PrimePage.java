package Page;

import core.base.BasePage;
import core.DSL.AcoesElementos;
import org.openqa.selenium.By;

public class PrimePage extends BasePage {

    public PrimePage() {
        acoesElementos = new AcoesElementos();
    }
    public void selecionarComboPrime(String radical, String valor) {
        acoesElementos.clickBy(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
        acoesElementos.clickBy(By.xpath("//*[@id='"+radical+"_items']//li[.='"+valor+"']"));
    }
}
