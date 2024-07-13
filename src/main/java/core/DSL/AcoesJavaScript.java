package core.DSL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static core.propriedadeSetup.DriverFactory.getDriver;

public class AcoesJavaScript {

    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    public void executarJSComElementoEBorda(String cmd, String cmd2, By by, String cmd3, String cmd4,Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		js.executeScript("alert('Testando js via selenium')");
        js.executeScript(cmd);
        js.executeScript(cmd2);
        WebElement element = getDriver().findElement(by);
        js.executeScript(cmd3,element,cmd4);
        return;
    }
}
