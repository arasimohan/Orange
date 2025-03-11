package arasi.utils;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver(){

        if(driver==null){
            String browser = "chrome";
            switch (browser){
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "chrome":
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito");
                    driver = new ChromeDriver(chromeOptions);
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
       return driver;
    }

    public static void quitDriver()
    {
        if(driver != null)
            driver.quit();
        driver = null;
    }

}
