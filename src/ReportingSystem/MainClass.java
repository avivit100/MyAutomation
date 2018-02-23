package ReportingSystem;

import com.aventstack.extentreports.Status;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainClass {
    private static WebDriver driver;

    @BeforeClass
    public static void Setup(){
        try {
            //Open the Reporting file:
            ReportClass.OpenLogFile();
            ReportClass.write(Status.PASS, "Log file is opened correctly. The company name is in the system info");

            //Set the selenium driver:
            System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
            ReportClass.write(Status.PASS, "Chrome driver is opened.");
        }
        catch(NullPointerException ex){
            ReportClass.write(Status.FAIL, "ERROR: setup.\n" + ex.getMessage());
        }
        catch (Exception ex){
            ReportClass.write(Status.FAIL, "ERROR: setup.\n" + ex.getMessage());
        }
    }

    @Test
    public void A_GoogleTranslate(){
        try {
            driver.get("https://translate.google.com/");
            ReportClass.write(Status.PASS, "Enterd to Google Translate site.");
        }
        catch(Exception ex){
            ReportClass.write(Status.PASS, "ErrorWhile entering to Google Translate site.\n" + ex.getMessage());
        }
    }

    @Test
    public void B_ScreenShot(){
        try {
            ReportClass.write(Status.INFO, "Currant screen shot:");
            ReportClass.takeScreenShot(driver);
        }
        catch(Exception ex){
            ReportClass.write(Status.FAIL, "ERROR: in screen shot.\n" + ex.getMessage());
        }
    }

    @Test
    public void C_TranslateButton(){
        try {
            driver.findElement(By.id("gt-submit")).click();
            ReportClass.write(Status.PASS, "Button Translate was clicked.");
        }
        catch(NoSuchElementException ex){
            ReportClass.write(Status.FAIL, "ERROR: in Clicking on Translate button.\n" + ex.getMessage());
        }
    }

    @AfterClass
    public static void CloseAll(){
        ReportClass.write(Status.INFO, "Closing chrome driver.");
        driver.quit();
        ReportClass.CloseLog();
    }

}
