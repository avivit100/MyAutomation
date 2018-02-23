package AppiumProject;

import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageB_Home {
    AndroidDriver<MobileElement> driver;

    public PageB_Home(WebDriver driver) {
        this.driver = (AndroidDriver<MobileElement>) driver;
    }

    public void ChooseGift() {
        try{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            MobileElement elemMobile;

            //Choose-Gift page is displayed:
            Report.write(Status.INFO, "Choose-Gift page is displayed.", driver);

            //Pick a category:
            List<MobileElement> category = driver.findElements(Utilities.PICK_CATEGORY);
            wait.until(ExpectedConditions.visibilityOf(category.get(2)));
            category.get(2).click();
            Report.write(Status.PASS, "Picked a category.");

            //Pick a business:
            List<MobileElement> business = driver.findElements(Utilities.PICK_BUSINESS);
            wait.until(ExpectedConditions.visibilityOf(business.get(1)));
            business.get(1).click();
            Report.write(Status.PASS, "Picked a business.");

            //Enter gift budget:
            elemMobile = driver.findElement(Utilities.TXT_BUDGET);
            wait.until((ExpectedConditions.visibilityOf(elemMobile)));
            elemMobile.sendKeys("555");
            Report.write(Status.PASS, "Entered a gift budget.");
            Utilities.CloseKeybord(driver);

            //Press button to buy:
            elemMobile = driver.findElement(Utilities.BTN_BUY);
            wait.until(ExpectedConditions.visibilityOf(elemMobile));
            elemMobile.click();
            Report.write(Status.PASS, "Clicked to buy.");
        }
        catch (NoSuchElementException ex){
            Report.write(Status.FAIL, "ERROR: in choosing a gift.\n" + ex.getMessage(), driver);
        }
        catch (ClassCastException ex){
            Report.write(Status.FAIL, "ERROR: in choosing a gift.\n" + ex.getMessage(), driver);
        }
        catch (Exception ex){
            Report.write(Status.FAIL, "ERROR: in choosing a gift.\n" + ex.getMessage(), driver);
        }

    }
}
