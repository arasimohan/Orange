package arasi.test;

import arasi.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
            driver = DriverManager.getDriver();
    }

    //@AfterClass
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
