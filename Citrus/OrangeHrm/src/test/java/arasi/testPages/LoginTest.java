package arasi.testPages;

import arasi.pages.LandingPage;
import arasi.pages.LoginPage;
import arasi.test.InitTest;
import arasi.utils.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends TestBase{

    public LoginTest()
    {
            System.out.println("CTR - LoginTest");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest - lOGINtEST");
        DriverManager.getDriver().get(InitTest.testURL);
    }

    @Test
    public void validLoginTest(){
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = (LandingPage) loginPage.LoginToHRM();
        Assert.assertEquals(landingPage.getLandingPageTitle(),"Dashboard");
    }



}
