package arasi.test;

import arasi.pages.LandingPage;
import arasi.pages.LoginPage;
import arasi.utils.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends TestBase{


    @BeforeTest
    public void beforeTest(){
        DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void validLoginTest(){
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = (LandingPage) loginPage.LoginToHRM();
        Assert.assertEquals(landingPage.getLandingPageTitle(),"Dashboard");
    }


}
