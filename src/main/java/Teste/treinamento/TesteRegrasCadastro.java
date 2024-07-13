package Teste.treinamento;

import Page.CadastroPage;
import core.base.BaseTest;
import core.DSL.AcoesAlertas;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static core.propriedadeSetup.DriverFactory.*;


@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest {
    private AcoesAlertas alertas;
    private CadastroPage page;

    @Parameter
    public String nome;
    @Parameter(value = 1)
    public String sobrenome;
    @Parameter(value = 2)
    public String sexo;
    @Parameter(value = 3)
    public List<String> comidas;
    @Parameter(value = 4)
    public String[] esporte;
    @Parameter(value = 5)
    public String msg;


    @Before
    public void setup() {
        componentesHTML();
        alertas = new AcoesAlertas();
        page = new CadastroPage();
    }

    @NotNull
    @Parameters
    public static Collection<Object[]> getCollection() {
        return Arrays.asList(new Object[][]{
                {"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
                {"Wagner", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
                {"Wagner", "Costa", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
                {"Wagner", "Costa", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
                {"Wagner", "Costa", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
        });
    }

    @Test
    public void deveValidarRegras() {
        page.setNome(nome);
        page.setSobreNome(sobrenome);
        if (sexo.equals("Masculino")) {
            page.sexoMasculino();
        }
        if (comidas.contains("Carne")) page.setComidaCarne();
        if (comidas.contains("Pizza")) page.setComidaPizza();
        if (comidas.contains("Vegetariano")) page.setComidaVegetariana();
        page.setEsporte(esporte);
        page.setCadastrar();
        System.out.println(msg);
        Assert.assertEquals(msg, alertas.alertaObterTextoEAceita());
    }
}
