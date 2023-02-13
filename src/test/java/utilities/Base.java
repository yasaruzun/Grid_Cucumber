package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    DesiredCapabilities cap=new DesiredCapabilities();
    static String hubUrl="http://192.168.1.4:4444";
    public WebDriver setDriver(WebDriver driver,String browser){

        if(browser=="chrome") {

            cap.setBrowserName("chrome");
            cap.setVersion("110.0.5481.78");
            cap.setPlatform(Platform.ANY);

            ChromeOptions options = new ChromeOptions();

            options.merge(cap);//merge methodunu kullanarak cap objemizi bir options haline getirdik
        }

        if (browser=="edge") {

            cap.setBrowserName("edge");
            //cap.setVersion();
            cap.setPlatform(Platform.ANY);

            EdgeOptions options=new EdgeOptions();
            options.merge(cap);

        }

            try {
                driver=new RemoteWebDriver(new URL(hubUrl),cap);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();




        return driver;
    }


}
