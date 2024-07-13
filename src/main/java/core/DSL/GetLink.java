package core.DSL;

import org.openqa.selenium.WebDriver;

import static core.propriedadeSetup.DriverFactory.getDriver;

public class GetLink {

    private WebDriver driver;

    public GetLink(){ super(); this.driver = driver;}

    public void retornaLinkTeste(String link) {
       getDriver().get(link);
       return;
    }

}
