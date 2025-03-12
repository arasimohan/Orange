package arasi.testPages;

import arasi.test.InitTest;
import arasi.utils.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase extends InitTest {

    public TestBase(){
        System.out.println("CTR - TestBase");
    }

    @BeforeClass
    public void setup(){
        System.out.println("BeforeClass - setup - TestBase");
    }

    @AfterClass
    public void tearDown(){
        DriverManager.quitDriver();
        System.out.println("AfterClass - tearDown  - TestBase");
    }
}
