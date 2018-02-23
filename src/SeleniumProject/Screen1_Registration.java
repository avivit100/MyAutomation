package SeleniumProject;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Screen1_Registration {
    WebDriver driver;

    public Screen1_Registration(WebDriver driver){
        this.driver = driver;
    }

    public void OpenSite() {
        //Get the site url from the config file:
        String strSiteURL = ConfigFile.getURL();

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);

            //Open the web site and verify that it's loaded:
            driver.get(strSiteURL);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Constants.BTN_ENTER));
            Log.write(Status.PASS, "Successfully entered the site: " + strSiteURL + ".", driver);
        }
        catch (WebDriverException ex) {
            Log.write(Status.FAIL,"ERROR: " + ex.getMessage(), driver);
        }
        catch(NullPointerException ex){
            Log.write(Status.FAIL, "ERROR: " + ex.getMessage(),driver);
        }
        catch(Exception ex){
            Log.write(Status.FAIL, "Failed to enter the site: " + strSiteURL + ". \n"
                    + ex.getMessage(),driver);
        }
    }

    public void SubscribeWindow() {
        WebElement elem;

        try {
            Log.write(Status.INFO, "This automation subscribes the site, with the user details.");

            //Click on Enter button:
            driver.findElement(Constants.BTN_ENTER).click();
            Log.write(Status.PASS, "Click on Enter button.");

            //Click on the link to Subscribe:
            elem = driver.findElement(Constants.LINK_SUBSCRIBE);
            if (elem.isDisplayed()) {
                elem.click();
            }
            Log.write(Status.PASS, "Entered to subscription window ", driver);

            //Type the user details:
            List<WebElement> txtFields = driver.findElements(Constants.ELEMS_DETAILS);
            txtFields.get(0).sendKeys(Constants.MY_NAME);
            Log.write(Status.PASS, "Type user name");
            txtFields.get(1).sendKeys(Constants.MY_EMAIL);
            Log.write(Status.PASS, "Type Email.");
            txtFields.get(2).sendKeys(Constants.MY_PASSWORD);
            txtFields.get(3).sendKeys(Constants.MY_PASSWORD);
            Log.write(Status.PASS, "Type Password.");

            //Click to Register:
            elem = driver.findElement(Constants.CHECK_REGISTER);
            if (!elem.isSelected()) { elem.click(); }
            Log.write(Status.PASS, "Click: I agree the site...");

            //Click not to get updates:
            elem = driver.findElement(Constants.CHECK_UPDATES);
            if (elem.isSelected()){ elem.click(); }

            //Click to submit the user details:
            driver.findElement(Constants.BTN_SUBMIT).submit();
            Log.write(Status.PASS, "Click to submit the details.");
        }
        catch (NoSuchElementException ex) {
            Log.write(Status.FAIL,"ERROR: while subscribing the site.\n" + ex.getMessage(), driver);
        }
        catch (Exception ex){
            Log.write(Status.FAIL,"ERROR: while subscribing the site.\n" + ex.getMessage(), driver);
        }

        //Check if the user is exist, then enter as a user:
        try {
            if (driver.findElement(Constants.MSG_ERROR).isDisplayed()) {
                Log.write(Status.INFO, "User already exists.");
                EnterAsUser();
            }
        }
        catch(Exception ex){}
    }

    private void EnterAsUser(){
        WebElement elem;
        WebDriverWait wait = new WebDriverWait(driver, 5);

        try {
            //Click to enter with exist user:
            elem = driver.findElement(Constants.LINK_USER);
            if (elem.isDisplayed()) {
                elem.click();
                Log.write(Status.PASS, "Click to get the entrance window, with exist user.");
            }

            //Type the private details:
            List<WebElement> txtFields = driver.findElements(Constants.ELEMS_DETAILS);
            txtFields.get(0).sendKeys(Constants.MY_EMAIL);
            Log.write(Status.PASS, "Type Email");
            txtFields.get(1).sendKeys(Constants.MY_PASSWORD);
            Log.write(Status.PASS, "Type Password.");

            //Click to submit the user details:
            driver.findElement(Constants.BTN_SUBMIT).submit();
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(Constants.BTN_SUBMIT)));
            Log.write(Status.PASS, "Click to enter as user.");
        }
        catch (NoSuchElementException ex) {
            Log.write(Status.FAIL,"ERROR: while entering as a user.\n" + ex.getMessage(), driver);
        }

    }

    public void EXTRA_AssertErrorMessage(){
        try {
            Log.write(Status.INFO, "This automation assert the error messages on the entrance window.");

            //Click to Enter
            driver.findElement(Constants.BTN_ENTER).click();
            Log.write(Status.PASS, "Click to enter the site.");

            //Click on submit without typing the user details:
            driver.findElement(Constants.BTN_SUBMIT).click();
            Log.write(Status.PASS, "Click on submit without typing the user details.");
            List<WebElement> errMesgs = driver.findElements(Constants.ERR_MSG);

            //Assert error message of the Email
            assertEquals(errMesgs.get(0).getText(), Constants.ASRT_ERR);
            if(errMesgs.get(0).isDisplayed() && errMesgs.get(0).getText().equals(Constants.ASRT_ERR)){
                Log.write(Status.PASS, "The Email error message in the entrance window, appears correctly.");
            }
            else {
                Log.write(Status.ERROR, "The Email error message of the entrance window, doesn't appear.", driver);
            }

            //Assert error message of the Password:
            assertEquals(errMesgs.get(1).getText(), Constants.ASRT_ERR);
            if(errMesgs.get(1).isDisplayed() && errMesgs.get(1).getText().equals(Constants.ASRT_ERR)){
                Log.write(Status.PASS, "The Password error message in the entrance window, appears correctly.");
            }
            else {
                Log.write(Status.ERROR, "The Password error message of the entrance window, doesn't appear.", driver);
            }

            //Close the entrance window
            driver.findElement(Constants.BTN_CLOSE).click();
            Log.write(Status.PASS, "Close entrance window.");
        }
        catch (NoSuchElementException ex) {
            Log.write(Status.FAIL,"ERROR: in entrance window.\n" + ex.getMessage(), driver);
        }
    }
}
