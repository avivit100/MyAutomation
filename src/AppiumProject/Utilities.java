package AppiumProject;

import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

public class Utilities {
    //--CONSTANTS--//
    //Config file path:
    public static final String CONFIG_FILE = "D:\\Automation\\Projects\\AppiumProject\\configProject.XML";
    //String details:
    public static final String GET_NAME = "Andrew Treitel";
    public static final String MY_NAME = "Avivit Hubara";
    public static final String SEND_BLESS = "Happy Anniversary! Love and joy forever!";
    public static final String SEND_EMAIL = "avivit100@yahoo.com";
    //Registration page - Elements names:
    public static final By BTN_ENTER = MobileBy.id("il.co.mintapp.buyme:id/skipButton");
    public static final By BTN_GOOGLE = MobileBy.id("il.co.mintapp.buyme:id/googleButton");
    public static final By CHOSE_USER = By.id("com.google.android.gms:id/account_name");
    //Home page - Elements names:
    public static final By PICK_CATEGORY = MobileBy.id("il.co.mintapp.buyme:id/t_title");
    public static final By PICK_BUSINESS = MobileBy.id("il.co.mintapp.buyme:id/businessImage");
    public static final By TXT_BUDGET = MobileBy.id("il.co.mintapp.buyme:id/priceEditText");
    public static final By BTN_BUY = MobileBy.id("il.co.mintapp.buyme:id/purchaseButton");
    //Choose Gift page - Elements names:
    public static final By TXT_NAME_GET = MobileBy.id("il.co.mintapp.buyme:id/toEditText");
    public static final By TXT_BLESS = MobileBy.id("il.co.mintapp.buyme:id/blessEditText");
    public static final By TXT_NAME_SEND = MobileBy.id("il.co.mintapp.buyme:id/userFrom");
    public static final By BTN_CONTINUE = MobileBy.id("il.co.mintapp.buyme:id/goNextButton");
    //Sender & Receiver Information page - Elements names:
    public static final By CHECK_NOW = MobileBy.id("il.co.mintapp.buyme:id/nowRadioButton");
    public static final By CHECK_EMAIL = MobileBy.id("il.co.mintapp.buyme:id/optionCheckBox");
    public static final By TXT_EMAIL = MobileBy.id("il.co.mintapp.buyme:id/description");

    //--SWIPING--//
    public static void ScrollDownScreen(MobileDriver driver){
        try {
            //Scroll down (swiping):
            TouchAction action = new TouchAction(driver);
            java.time.Duration fourSec = java.time.Duration.ofSeconds(4);

            action.longPress(45, 1770, fourSec).moveTo(45, 500).release().perform();
        }
        catch(Exception ex){
            Report.write(Status.FAIL, "ERROR: in scrolling on the screen.\n" +ex.getMessage(), driver);
        }
    }
    public static void CloseKeybord(MobileDriver driver) {
        try {
            driver.hideKeyboard();
        }
        catch (Exception ex) {
        }
    }
}
