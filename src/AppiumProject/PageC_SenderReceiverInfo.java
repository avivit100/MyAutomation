package AppiumProject;

import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageC_SenderReceiverInfo {
    AndroidDriver<MobileElement> driver;

    public PageC_SenderReceiverInfo(WebDriver driver) {
        this.driver = (AndroidDriver<MobileElement>)driver;
    }

    public void FillInformation() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            MobileElement elemMobile;

            //Information page is displayed:
            Report.write(Status.INFO, "Information page is displayed.", driver);

            //Enter receiver name:
            elemMobile = driver.findElement(Utilities.TXT_NAME_GET);
            wait.until(ExpectedConditions.visibilityOf(elemMobile));

            elemMobile.sendKeys(Utilities.GET_NAME);
            Report.write(Status.PASS, "Typed the receiver name.");
            Utilities.CloseKeybord(driver);

            //Scroll dowm:
            Utilities.ScrollDownScreen(driver);

            // Enter a blessing:
            elemMobile = driver.findElement(Utilities.TXT_BLESS);

            elemMobile.sendKeys(Utilities.SEND_BLESS);
            Report.write(Status.PASS, "Typed the blessing.");
            Utilities.CloseKeybord(driver);

            //Enter sender name:
            elemMobile = driver.findElement(Utilities.TXT_NAME_SEND);
            elemMobile.clear();
            elemMobile.sendKeys(Utilities.MY_NAME);
            Report.write(Status.PASS, "Typed the sender name.");
            Utilities.CloseKeybord(driver);

            //Scroll dowm:
            Utilities.ScrollDownScreen(driver);

            //Press to continue:
            driver.findElement(Utilities.BTN_CONTINUE).click();
            Report.write(Status.PASS, "Clicked the continue button.");
        }
        catch(NoSuchElementException ex){
            Report.write(Status.FAIL, "ERROR: in information of sender snd receiver.\n" +ex.getMessage(), driver);
        }
        catch (Exception ex){
            Report.write(Status.FAIL, "ERROR: in information of sender snd receiver.\n" +ex.getMessage(), driver);

        }
    }


}
