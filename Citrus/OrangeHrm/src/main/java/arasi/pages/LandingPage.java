package arasi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import arasi.utils.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private By landingPgTitle = By.xpath("//span/*[contains(@class,'oxd-topbar-header-breadcrumb-module')]");

    public LandingPage(){
        this.webDriver = (WebDriver) DriverManager.getDriver();
        PageFactory.initElements(webDriver,this);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(landingPgTitle));
    }

    public String getLandingPageTitle(){
        return webDriver.findElement(landingPgTitle).getText();
    }


}
