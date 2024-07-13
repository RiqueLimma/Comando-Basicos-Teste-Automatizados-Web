package core.propriedadeSetup;

import org.junit.After;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

  private DriverFactory(){}

    public static void setPropertyChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\CursoSelenium\\curso-teste\\src\\main\\java\\driver\\chromedriver.exe");
    }

    public static void setPropertyFirefox(){
        System.setProperty("webdriver.gecko.driver", "C:\\CursoSelenium\\curso-teste\\src\\main\\java\\driver\\geckodriver.exe");
    }

    public static WebDriver getDriver(){
      if(driver == null) {
          switch (Propriedades.browsers){
              case FIREFOX:
                  setPropertyFirefox();
                  driver = new FirefoxDriver(); break;
              case CHROME:
//                  setPropertyChrome();
                  driver = new ChromeDriver(); break;
          }
          getDriver().manage().window().setSize(new Dimension(1200, 765));
      }
        return driver;
    }

    public static void componentesHTML() {
            getDriver();
            getDriver().get("C:\\CursoSelenium\\curso-teste\\src\\main\\resources\\componentes.html");
    }



    public static void killDriver() {
      if(driver != null) {
          getDriver().quit();
          driver = null;
      }
    }
}
