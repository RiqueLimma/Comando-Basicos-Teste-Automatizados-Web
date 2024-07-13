package Page;

import core.base.BasePage;
import org.openqa.selenium.By;


public class CadastroPage extends BasePage {

    public void setNome(String nome){
        acoesElementos.escrever(By.id("elementosForm:nome"), nome);
    }

    public void setSobreNome(String sobreNome){
        acoesElementos.escrever(By.id("elementosForm:sobrenome"), sobreNome);
    }
    public void sexoMasculino(){
        acoesElementos.clickBy(By.id("elementosForm:sexo:0"));
    }

    public void setComidaPizza(){
        acoesElementos.clickBy(By.id("elementosForm:comidaFavorita:2"));
    }
    public void setComidaCarne(){
        acoesElementos.clickBy(By.id("elementosForm:comidaFavorita:0"));
    }
    public void setComidaVegetariana(){
        acoesElementos.clickBy(By.id("elementosForm:comidaFavorita:3"));
    }

    public void setEscolaridade(String valor){
        acoesElementos.selecionarCombo("elementosForm:escolaridade", valor);
    }

    public void setEsporte(String... valores) {
            for(String valor: valores)
                acoesElementos.selecionarCombo("elementosForm:esportes", valor);
    }

    public void setCadastrar(){
        acoesElementos.clickBy(By.id("elementosForm:cadastrar"));
    }

    public boolean setResultadoComecoTexto(){
        return acoesElementos.retornaComecoTexto(By.id("resultado"), "Cadastrado!");
    }

    public boolean setResultadoFinalTexto(){
        return acoesElementos.retornaFinalTexto(By.id("descNome"), "Luis");
    }
}

