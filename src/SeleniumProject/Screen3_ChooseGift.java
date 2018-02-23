package SeleniumProject;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertNotEquals;

public class Screen3_ChooseGift {
    WebDriver driver;

    public Screen3_ChooseGift(WebDriver driver){
        this.driver = driver;
    }

    public void EnterGiftScreen(){
        try {
            //Verify that the Chose-Gift screen is loaded:
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Constants.PIC_PROMO));
            Log.write(Status.PASS, "Entered to Choose-Gift screen successfully.", driver);
        }
        catch (NoSuchElementException ex){
            Log.write(Status.FAIL, "Failed to enter Choose Gift screen.\n" + ex.getMessage() , driver);
        }
    }

    public void AssertURL(){
        try {
            //Assert the URL of the screen:
            String strNewURL = driver.getCurrentUrl();
            assertNotEquals(strNewURL, ConfigFile.getURL());
            if (!strNewURL.equals(ConfigFile.getURL())) {
                Log.write(Status.PASS, "The URL of Choose-Gift screen, is changed.");
            } else {
                Log.write(Status.ERROR, "The URL of Choose-Gift screen, is not changed.");
            }
        }
        catch(Exception ex){
            Log.write(Status.FAIL, "ERROR: while assert the URL of Choose-Gift screen.\n"
                    + ex.getMessage() , driver);
        }
    }

    public void PickBusiness(){
        try {
            Log.write(Status.INFO, "This automation selects one of the chosen gifts");

            //Click the first option of the results:
            driver.findElement(Constants.PIC_PROMO).click();
            Log.write(Status.PASS, "Picke first promo picture.");

            try {
                //Check if need to specify the price:
                if (driver.findElement(Constants.TXT_PRICE).isDisplayed()) {
                    driver.findElement(Constants.TXT_PRICE).sendKeys("555");
                    Log.write(Status.PASS, "Set price to 555.");
                }
            } catch (Exception ex) {}

            //Click the first option to buy:
            driver.findElements(Constants.BTN_SUBMIT).get(1).click();
            Log.write(Status.PASS, "Click to purchase.");
        }
        catch (NoSuchElementException ex) {
            Log.write(Status.FAIL,"ERROR: while picking a business picture.\n" + ex.getMessage(), driver);
        }
        catch (Exception ex) {
            Log.write(Status.FAIL,"ERROR: while picking a business picture.\n" + ex.getMessage(), driver);
        }
    }

    public void EXTRA_PrintShotBottom(){
        try {
            WebElement elemLogo;
            //Scroll to the bottom of the screen (by the logo) and print shot:
            elemLogo = driver.findElement(Constants.DOWN_LOGO);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemLogo);
            Log.write(Status.PASS, "The print shot of the bottom of Choose Gift page is:", driver);

            //Scroll back up (by the top logo):
            elemLogo = driver.findElement(Constants.UP_LOGO);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemLogo);
        }
        catch (NoSuchElementException ex) {
            Log.write(Status.FAIL,"ERROR: while print shot thr bottom of the Choose-Gift screen.\n"
                    + ex.getMessage(), driver);
        }
    }
}

