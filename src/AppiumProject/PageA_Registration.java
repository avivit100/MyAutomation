package AppiumProject;

import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageA_Registration {
    AndroidDriver<MobileElement> driver;

    public PageA_Registration(WebDriver driver) {
        this.driver = (AndroidDriver<MobileElement>) driver;
    }

    public void clickToEnter(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            //Click on Enter button:
            MobileElement btnEnter = driver.findElement(Utilities.BTN_ENTER);
            wait.until(ExpectedConditions.visibilityOf(btnEnter));
            btnEnter.click();
            Report.write(Status.PASS, "Clicked on Register button.");
        }
        catch(NoSuchElementException ex){
            Report.write(Status.INFO, "User is already loged on.");
        }
        catch(Exception ex){
            Report.write(Status.FAIL, "ERROR: on click Enter button.\n" + ex.getMessage(), driver);
        }
    }

    public void RegisterGoogle(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);

            //Registration page is displayed:
            Report.write(Status.INFO, "Registration page is displayed.", driver);

            //Click on the Google option:
            MobileElement btnGmail =  driver.findElement(Utilities.BTN_GOOGLE);
            wait.until(ExpectedConditions.visibilityOf(btnGmail));
            btnGmail.click();
            Report.write(Status.PASS, "Clicked on 'Enter with Gmail' button.");

           //Choose a user:
            driver.findElement(Utilities.CHOSE_USER).click();
            Report.write(Status.PASS, "Chose a google user.");
        }
        catch (NoSuchElementException ex){
            Report.write(Status.INFO, "User is already loged on.");
        }
        catch (Exception ex){
            Report.write(Status.FAIL, "ERROR: in registration with google.\n" + ex.getMessage(), driver);
        }
    }
}
