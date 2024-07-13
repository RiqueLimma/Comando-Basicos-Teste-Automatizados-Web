package core.base;

import Page.JavaScriptPage;
import core.DSL.*;

public class BasePage extends BaseTest{

    protected AcoesElementos acoesElementos;
    protected AcoesAlertas alertas;
    protected AcoesFrame frame;

    protected JavaScriptPage page;

    protected AcoesJavaScript js;

    public BasePage() {
        acoesElementos = new AcoesElementos();
        alertas = new AcoesAlertas();
        frame = new AcoesFrame();
        js = new AcoesJavaScript();
    }



}
