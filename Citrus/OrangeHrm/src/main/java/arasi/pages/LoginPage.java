package arasi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import arasi.utils.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage  {
    WebDriver driver;
    WebDriverWait webDriverWait;
    private String username;
    private String password;

    private By usernameInfo = By.xpath("//div/p[@class='oxd-text oxd-text--p'][1]");
    private By passwordInfo = By.xpath("//div/p[@class='oxd-text oxd-text--p'][2]");
    private By usernameTxt = By.xpath("//input[@placeholder='Username']");
    private By passwordTxt = By.xpath("//input[@placeholder='Password']");
    private By loginBtn = By.cssSelector("button.orangehrm-login-button");

    public LoginPage(){
        System.out.println("CTR - LoginPage");
        this.driver = (WebDriver) DriverManager.getDriver();
        webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(usernameInfo));
    }

    private void retrieveLoginDetails(){

        String name = driver.findElement(usernameInfo).getText();
        String pwd = driver.findElement(passwordInfo).getText();
        username = name.split(":")[1].trim();
        password = pwd.split(":")[1].trim();
        //System.out.println("username - "+username+"....Pwd: "+password);
    }

    public Object LoginToHRM(){
        retrieveLoginDetails();
        driver.findElement(usernameTxt).sendKeys(username);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginBtn).click();
        return new LandingPage();
    }


}
