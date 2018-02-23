package SeleniumProject;

import com.aventstack.extentreports.Status;
import org.junit.ComparisonFailure;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Screen4_SendReceiveInfo {
    WebDriver driver;

    public Screen4_SendReceiveInfo(WebDriver driver){
        this.driver = driver;
    }

    public void EnterInformationScreen(){
        try {
            //Verify that the Sender & Receiver Information screen is loaded:
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Constants.CHECK_SOMEONE));
            Log.write(Status.PASS, "Entered to Send & Receive Information screen successfully.", driver);
        }
        catch (NoSuchElementException ex){
            Log.write(Status.FAIL, "Failed to enter Send & Receive Information screen.\n" + ex.getMessage() , driver);
        }

    }

    public void TypePurchaseDetails(){
        WebElement elem;
        try {
            Log.write(Status.INFO, "This automation types all the sender and receiver details.");

            //Chose for someone else:
            elem = driver.findElement(Constants.CHECK_SOMEONE);
            if (!elem.isSelected()) {
                elem.click();
            }
            Log.write(Status.PASS, "Select to send for someone else.");

            //Type the purchase details:
            List<WebElement> txtFields = driver.findElements(Constants.ELEMS_DETAILS);
            txtFields.get(0).clear();
            txtFields.get(0).sendKeys(Constants.SEND_NAME);
            Log.write(Status.PASS, "Type whom the gift for");
            txtFields.get(1).clear();
            txtFields.get(1).sendKeys(Constants.MY_NAME);
            Log.write(Status.PASS, "Type from whom the gift is.");
            txtFields.get(2).clear();
            txtFields.get(2).sendKeys(Constants.SEND_BLESS);
            Log.write(Status.PASS, "Type a bless.");

            //Upload a picture:
            driver.findElement(Constants.TXT_UP_FILE).sendKeys(ConfigFile.getUploadFile());
            Log.write(Status.PASS, "Upload a photo file.");

            //Chose to send right after the payment:
            elem = driver.findElement(Constants.CHECK_NOW);
            if (!elem.isSelected()) {
                elem.click();
            }
            Log.write(Status.PASS, "Select to send right after the payment.");

            //Select to send by Email:
            driver.findElement(Constants.ICON_ENV).click();
            driver.findElement(Constants.TXT_EMAIL).clear();
            driver.findElement(Constants.TXT_EMAIL).sendKeys(Constants.SEND_EMAIL);
            driver.findElement(Constants.BTN_SAVE).click();
            Log.write(Status.PASS, "Click on Email icon, type address to send and save.");
        }
        catch (NoSuchElementException ex) {
            Log.write(Status.FAIL,"ERROR: while typing purchase details.\n" + ex.getMessage(), driver);
        }
    }

    public void ClickSubmit(){
        try{
            //Click to submit the information:
            driver.findElements(Constants.BTN_SUBMIT).get(1).click();
            Log.write(Status.PASS, "Click on move to payment screen.");
        }
        catch (NoSuchElementException ex) {
            Log.write(Status.FAIL,"ERROR: while typing purchase details.\n" + ex.getMessage(), driver);
        }
        Log.write(Status.INFO, "End of automation test!");
    }

    public void EXTRA_AssertTextColor(){
        try {
            Log.write(Status.INFO, "This automation asserts the text color of the step name.");

            //Assert the text color of the step name = yellow:
            String strColor = driver.findElement(Constants.STEP_NAME).getCssValue("color");
            assertEquals(strColor, Constants.CLR_YELLOW);
            if (strColor.equals(Constants.CLR_YELLOW)){
                Log.write(Status.PASS, "The text color of the step, appears correctly.");
            }
            else {
                Log.write(Status.ERROR, "The text color of the step, is wrong.", driver);
            }
        }
        catch (NoSuchElementException ex) {
            Log.write(Status.FAIL,"ERROR: in assert text color.\n" + ex.getMessage(), driver);
        }
        catch(ComparisonFailure ex){
            Log.write(Status.FAIL,"ERROR: in assert text color.\n" + ex.getMessage(), driver);
        }
    }

    public void EXTRA_AssertDetails(){
        try{
            Log.write(Status.INFO, "This automation asserts the details of the sender & receiver.");
            List<WebElement> cardDetails = driver.findElements(Constants.ASRT_NAME);

            //Assert the sender name:
            assertEquals(cardDetails.get(0).getText(), Constants.SEND_NAME);
            if (cardDetails.get(0).getText().equals(Constants.SEND_NAME)){
                Log.write(Status.PASS, "The name of the sender, appears correctly.");
            }
            else{
                Log.write(Status.ERROR, "The name of the sender, is wrong.",driver);
            }

            //Assert the receiver name:
            assertEquals(cardDetails.get(1).getText(), Constants.MY_NAME);
            if (cardDetails.get(1).getText().equals(Constants.MY_NAME)){
                Log.write(Status.PASS, "The name of the receiver, appears correctly.");
            }
            else{
                Log.write(Status.ERROR, "The name of the receiver, is wrong.", driver);
            }

            //Assert the bless text:
            assertEquals(driver.findElement(Constants.ASRT_BLESS).getText(), Constants.SEND_BLESS);
            if (driver.findElement(Constants.ASRT_BLESS).getText().equals(Constants.SEND_BLESS)){
                Log.write(Status.PASS, "The bless, appears correctly.");
            }
            else{
                Log.write(Status.ERROR, "The bless, is wrong.", driver);
            }
        }
        catch (NoSuchElementException ex) {
            Log.write(Status.FAIL,"ERROR: in assert sender & receiver details.\n" + ex.getMessage(), driver);
        }
        catch(ComparisonFailure ex){
            Log.write(Status.FAIL,"ERROR: in assert sender & receiver details.\n" + ex.getMessage(), driver);
        }
    }
}

