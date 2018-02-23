package AppiumProject;

import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class PageD_HowToSend {
    AndroidDriver<MobileElement> driver;

    public PageD_HowToSend(WebDriver driver) {
        this.driver = (AndroidDriver<MobileElement>)driver;
    }

    public void SendGift() {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            MobileElement elemMobile;

            //How-To-Send page is displayed:
            Report.write(Status.INFO, "How-To-Send page is displayed.", driver);

            //Click the option: right after the pay:
            elemMobile = driver.findElement(Utilities.CHECK_NOW);
            wait.until(ExpectedConditions.visibilityOf(elemMobile));
            elemMobile.click();
            Report.write(Status.PASS, "Clicked the checkbox: right after the pay.");

            //Pick the Email option:
            List<MobileElement> optSend = driver.findElements(Utilities.CHECK_EMAIL);
            optSend.get(1).click();
            Report.write(Status.PASS, "Picked the Email option.");

            //Enter Email address:
            elemMobile = driver.findElement(Utilities.TXT_EMAIL);
            elemMobile.clear();
            elemMobile.sendKeys(Utilities.SEND_EMAIL);
            Report.write(Status.PASS, "Typed the Email address");
            Utilities.CloseKeybord(driver);

            //Scroll dowm:
            Utilities.ScrollDownScreen(driver);

            //Press to continue:
            driver.findElement(Utilities.BTN_CONTINUE).click();
            Report.write(Status.PASS, "Click the continue button.");
        }
        catch (NoSuchElementException ex){
            Report.write(Status.FAIL, "ERROR: in sending the gift.\n" + ex.getMessage(), driver);
        }
        catch (Exception ex){
            Report.write(Status.FAIL, "ERROR: in sending the gift.\n" + ex.getMessage(), driver);
        }
    }
}
