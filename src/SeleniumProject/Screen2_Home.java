package SeleniumProject;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Screen2_Home {
    WebDriver driver;

    public Screen2_Home(WebDriver driver){ this.driver = driver; }

    public void EnterHomeScreen(){
        try {
            //Verify that the Home screen is loaded:
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Constants.DDOWN_PRICES));
            Log.write(Status.PASS, "Entered to Home screen successfully.", driver);
        }
        catch (NoSuchElementException ex){
            Log.write(Status.FAIL, "Failed to enter Home screen.\n" + ex.getMessage() , driver);
        }
    }

    public void SearchGift(){
        Select dropdown;

        try {
            Log.write(Status.INFO, "This automation searches for gifts.");

            //Select a price:
            driver.findElement(Constants.DDOWN_PRICES).click();
            List<WebElement> giftPrices = driver.findElements(Constants.ELEMS_SELECT);
            giftPrices.get(5).click();
            Log.write(Status.PASS, "Select a price range.");

            //Select an area
            driver.findElement(Constants.DDOWN_AREAS).click();
            List<WebElement> giftAreas = driver.findElements(Constants.ELEMS_SELECT);
            giftAreas.get(2).click();
            Log.write(Status.PASS, "Select an area.");

            //Select a category
            driver.findElement(Constants.DDOWN_CATEGORIES).click();
            List<WebElement> giftCategs = driver.findElements(Constants.ELEMS_SELECT);
            giftCategs.get(8).click();
            Log.write(Status.PASS, "Select a category of gifts.");

            //Click to search:
            driver.findElement(Constants.BTN_SEARCH).click();
            Log.write(Status.PASS, "Click to search for gifts.");
        }
        catch (NoSuchElementException ex) {
            Log.write(Status.FAIL,"ERROR: while searching a gift.\n" + ex.getMessage(), driver);
        }
        catch(UnexpectedTagNameException ex){
            Log.write(Status.FAIL,"ERROR: while searching a gift.\n" + ex.getMessage(), driver);
        }
        catch (Exception ex){
            Log.write(Status.FAIL,"ERROR: while searching a gift.\n" + ex.getMessage(), driver);
        }
    }

}
