package arasi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import arasi.utils.DriverManager;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage  {
    WebDriver driver;
    WebDriverWait webDriverWait;

    private By usernameTxt = By.xpath("//div/p[@class='oxd-text oxd-text--p'][1]");
    private By passwordTxt = By.xpath("//div/p[@class='oxd-text oxd-text--p'][2]");

    public LoginPage(){
        this.driver = (WebDriver) DriverManager.getDriver();
        webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(usernameTxt));
    }

    public void retrieveLoginDetails(){

        String name = driver.findElement(usernameTxt).getText();
        String pwd = driver.findElement(passwordTxt).getText();
        String username = name.split(":")[1].trim();
        String password = pwd.split(":")[1].trim();
        System.out.println("username - "+username+"....Pwd: "+password);
    }
}
