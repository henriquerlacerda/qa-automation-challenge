package UITesting.config;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ChromeDriver {

    private static ChromeDriverService service;
    private static WebDriver driver;

    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/usr/local/bin/chromedriver"))
                .usingAnyFreePort()
                .build();
        service.start();

    }

    public static void stopService() {
        service.stop();
    }

    public static void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
        driver.manage().window().maximize();
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static WebDriver getChromeDriver(){
        return driver;
    }

    public static void accessWebPage(String url){
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void waitPageLoad(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
