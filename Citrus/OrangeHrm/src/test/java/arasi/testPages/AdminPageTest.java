package arasi.testPages;

import arasi.pages.AdminPage;
import arasi.pages.LandingPage;
import arasi.pages.LoginPage;
import arasi.test.InitTestConfig;
import arasi.utils.DriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminPageTest extends TestBase {

    private LandingPage landingPage;
    public AdminPageTest(){
        System.out.println("CTR - AdminPageTest");
    }

    @BeforeTest
    public void setup(){
        DriverManager.getDriver().get(InitTestConfig.testURL);
        LoginPage loginPage = new LoginPage();
        landingPage = loginPage.LoginToHRM();
    }
    @Test
    public void readWebTableTest(){
        AdminPage adminPage = (AdminPage) landingPage.gotoMenu("Admin");
        adminPage.displayTableContents();
        //adminPage.practiseStringReverse();
    }
}
