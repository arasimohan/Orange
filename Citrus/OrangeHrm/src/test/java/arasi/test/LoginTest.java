package arasi.test;

import arasi.pages.LoginPage;
import arasi.utils.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends TestBase{


    @BeforeTest
    public void beforeTest(){
        DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void findLoginCreds(){
        LoginPage loginPage = new LoginPage();
        loginPage.retrieveLoginDetails();

    }
}
