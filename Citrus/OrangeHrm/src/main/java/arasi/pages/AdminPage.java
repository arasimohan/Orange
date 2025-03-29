package arasi.pages;

import arasi.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private String colHeadingXpath = "//div[@role ='columnheader']";
    private String cellXpath = "//div[@role ='cell']";
    private String rowsXpath = "div.oxd-table-row--with-border";

    public AdminPage(){
        this.webDriver = DriverManager.getDriver();
        PageFactory.initElements(webDriver,this);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    public void displayTableContents(){
        System.out.println(" displayTableContents ");
        System.out.println(" Efficient way to store table data is in the form of a ***list of maps**** : Refer deep seek  ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List< WebElement> tempLst = webDriver.findElements(By.xpath(colHeadingXpath));
        List< WebElement> tempSubLst = new ArrayList<WebElement>(tempLst.subList(1,5));
        List<String> headerData = new ArrayList<>();
        for(WebElement header : tempSubLst){
            headerData.add(header.getText());
        }
        for(int i =0 ; i< headerData.size();i++)
            System.out.println(" headerData is "+ headerData.get(i));

        int numDataRows = webDriver.findElements(By.xpath(rowsXpath)).size();

        List<Map<String,String>> rowData = new ArrayList<>();

        for (int row = 0; row < numDataRows-1; row++)
        {
            Map<String,String> cellData = new HashMap<>();
            for(int cols = 0 ; cols < headerData.size(); cols++)
            {
                String cellValue = webDriver.findElements(By.xpath(cellXpath+"["+(cols+2)+"]")).get(row).getText();
                cellData.put(headerData.get(cols), cellValue);
            }
            rowData.add(cellData);
        }
        for (Map<String, String> rowItem : rowData) {
            System.out.printf("| %-10s | %-3s | %-15s |%n",
                    rowItem.getOrDefault("Username", ""),
                    rowItem.getOrDefault("User Role", ""),
                    rowItem.getOrDefault("Employee Name", ""),
                    rowItem.getOrDefault("Status", ""));
        }

        System.out.println("End of test ");
/*        approach of storing each column in separate lists is workable but may not be the most efficient or maintainable method.
        Hard to maintain relationships between row data
        Doesn't represent the logical structure of a "table" well. Hence use list of maps to represent table data

        List<WebElement> usernamesLst = webDriver.findElements(By.xpath(cellXpath+"[2]"));
        List<String> usernamesData = new ArrayList<>();
        for(WebElement username : usernamesLst){
            usernamesData.add(username.getText());
        }
        System.out.println("usernamesData is "+usernamesData);

        List<WebElement> userRolesLst = webDriver.findElements(By.xpath(cellXpath+"[3]"));
        List<String> userRolesData = new ArrayList<>();
        for(WebElement userRole : userRolesLst){
            userRolesData.add(userRole.getText());
        }
        System.out.println("userRolesData is "+userRolesData);*/
    }

    public void practiseStringReverse(){
        String org = "Arasi";
        StringBuilder rev = new StringBuilder("");
        for(int i = org.length()-1; i >=0; i--){
            rev.append(org.charAt(i));
        }
        System.out.println("Reversed str is "+rev);
    }

}
