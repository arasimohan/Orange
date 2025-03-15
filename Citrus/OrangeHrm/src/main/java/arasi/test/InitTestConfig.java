package arasi.test;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class InitTestConfig {

    protected WebDriver driver;
    public static Properties prop;
    public static String testBrowser;
    public static String testURL;

    public InitTestConfig()
    {
        System.out.println("CTR - InitTestConfig");
        loadProperties();
    }

    public void loadProperties(){

        String configFile = System.getProperty("user.dir")+"/src/main/java/arasi/config/config.properties";
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
        testBrowser = prop.getProperty("browser").toLowerCase();
        testURL = prop.getProperty("demoURL");
        //System.out.println("Browser found is "+prop.getProperty("browser"));
    }
}
