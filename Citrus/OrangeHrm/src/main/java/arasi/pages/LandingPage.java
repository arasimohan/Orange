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

    private String menuNameXpathPre = "//span[contains(@class,'oxd-main-menu-item--name') and text()='";
    private String menuNameXpathPost = "']";
    public LandingPage(){
        this.webDriver = DriverManager.getDriver();
        PageFactory.initElements(webDriver,this);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(landingPgTitle));
    }

    public String getLandingPageTitle(){
        return webDriver.findElement(landingPgTitle).getText();
    }

    public Object gotoMenu(String menuName){
        webDriver.findElement(By.xpath(menuNameXpathPre+menuName+menuNameXpathPost)).click();
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(landingPgTitle,menuName));
        switch(menuName){
            case "Admin":
                return new AdminPage();
            case "PIM":
            default:
                return new PIMpage();
        }
    }
}
