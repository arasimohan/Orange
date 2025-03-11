package arasi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public Properties prop;
    public String browser;
    public String testURL;
    public TestBase(){
        // Empty constructor
    }

    public void loadProperties(){

        String configFile = System.getProperty("user.dir")+"/Citrus/OrangeHrm/src/main/java/arasi/config/config.properties";
        //System.out.println("configFile is "+configFile);
        File file = new File(configFile);
        FileInputStream fileInp = null;
        try {
             fileInp = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found due to "+e.getMessage());
        }
        prop = new Properties();
        try {
            prop.load(fileInp);
        } catch (IOException e) {
            System.out.println("Unable to load Config file due to "+e.getMessage());
        }
        browser = prop.getProperty("browser").toLowerCase();
        testURL = prop.getProperty("demoURL");
        //System.out.println("Browser found is "+prop.getProperty("browser"));
        loadBrowser();
    }

    public void loadBrowser(){
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
        driver.get(testURL);
    }
}
