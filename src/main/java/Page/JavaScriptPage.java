package Page;

import core.base.BasePage;
import org.openqa.selenium.By;

public class JavaScriptPage  extends BasePage {

    public void setExecuteJsComBordaMarcada() {
        js.executarJSComElementoEBorda("document.getElementById('elementosForm:nome').value = 'Escrito via js'",
                "document.getElementById('elementosForm:sobrenome').type = 'radio'",
                       By.id("elementosForm:nome"),
                "arguments[0].style.border = arguments[1]",
                "solid 4px red");
    }
}
