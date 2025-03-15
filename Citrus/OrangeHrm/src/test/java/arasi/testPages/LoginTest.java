package arasi.testPages;

import arasi.pages.LandingPage;
import arasi.pages.LoginPage;
import arasi.test.InitTestConfig;
import arasi.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    public LoginTest()
    {
            System.out.println("CTR - LoginTest");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest - lOGINtEST");
        DriverManager.getDriver().get(InitTestConfig.testURL);
    }

    @Test
    public void validLoginTest(){
        LoginPage loginPage = new LoginPage();
        LandingPage landingPage = (LandingPage) loginPage.LoginToHRM();
        Assert.assertEquals(landingPage.getLandingPageTitle(),"Dashboard");
        landingPage.gotoMenu("Admin");
        landingPage.gotoMenu("PIM");
    }



}
