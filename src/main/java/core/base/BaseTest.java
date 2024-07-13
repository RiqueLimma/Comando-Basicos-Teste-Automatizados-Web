package core.base;

import core.DSL.AcoesElementos;
import core.propriedadeSetup.Propriedades;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static core.propriedadeSetup.DriverFactory.getDriver;
import static core.propriedadeSetup.DriverFactory.killDriver;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    public void screenshot() throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File arquivo = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshort"
                + File.separator + testName.getMethodName() + ".jpg"));
    }

    @After
    public void driverQuit() throws IOException {
        screenshot();
        if(Propriedades.FECHAR_BROWSER){
            killDriver();
        }
    }

    public void tratamentoIOException(){


    }
}
