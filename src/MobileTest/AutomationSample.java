package MobileTest;

import AppiumProject.Report;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AutomationSample {
    private static AndroidDriver<MobileElement> driver;

    @BeforeClass
    public static void setUp() throws IOException {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
            capabilities.setCapability("appPackage", "com.dgotlieb.automationsample");
            capabilities.setCapability("appActivity", "com.dgotlieb.automationsample.MainActivity");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        catch(WebDriverException ex){
            System.out.println("ERROR: in setting up the Appium.\n"+ ex.getMessage());
        }
        catch(Exception ex){
            System.out.println("ERROR: in setting up the Appium.\n"+ ex.getMessage());
        }


    }

    @Test
    public void A_LoginScreen(){
        try {
            MobileElement userName = driver.findElement(MobileBy.id("com.dgotlieb.automationsample:id/userName"));
            MobileElement password = driver.findElement(MobileBy.id("com.dgotlieb.automationsample:id/userPassword"));
            MobileElement loginBtn = driver.findElement(MobileBy.id("com.dgotlieb.automationsample:id/loginButton"));

            //Enter wrong parameters and assert result:
            userName.sendKeys("abc");
            password.sendKeys("def");
            loginBtn.click();
            String strError = driver.findElement(MobileBy.id("com.dgotlieb.automationsample:id/errorTV")).getText();
            assertEquals(strError, "Wrong username or password");

            //Login into App (user name & password are Admin):
            userName.clear();
            userName.sendKeys("Admin");
            password.clear();
            password.sendKeys("Admin");
            loginBtn.click();
        }
        catch(NoSuchElementException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Test
    public void B_MainScreen(){
        try{
            //Print all clickables elements locations:
            List<MobileElement> clicks = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
            System.out.println("The clickable elements on the page are located on:");
            for(int i=0; i<clicks.size(); i++) {
                System.out.println(clicks.get(i).getLocation().toString());
            }

            MobileElement elem;
            //Assert if check box is checked:
            elem = driver.findElement(MobileBy.id("com.dgotlieb.automationsample:id/checkBox"));
            assertTrue(elem.isSelected());

            //Long click ok button:
            TouchAction action = new TouchAction(driver);
            Duration fourSec = Duration.ofSeconds(4);
            elem = driver.findElement(MobileBy.id("com.dgotlieb.automationsample:id/long_click_button"));
            int btnX = elem.getLocation().x;
            int btnY = elem.getLocation().y;

            action.longPress(btnX, btnY, fourSec);
        }
        catch(NoSuchElementException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Test
    public void C_ListScreen(){
        List<MobileElement> listView = driver.findElements(MobileBy.id("android:id/text1"));

        //Press on the second element in listview:
        listView.get(2).click();

        //Assert text from the first element in the listview:
        assertEquals(listView.get(0).getText(), "Apple");

        //Press on the fourth element in listview:
        listView.get(3).click();
    }

    @Test
    public void D_SwipeScreen(){
        try {
            //Swipe left to check result:
            TouchAction action = new TouchAction(driver);
            java.time.Duration fourSec = java.time.Duration.ofSeconds(4);

            action.longPress(10, 500, fourSec).moveTo(70, 500).release().perform();

            //Press “back press”:
            driver.pressKeyCode(AndroidKeyCode.BACK);

            //Go back to “swipe screen” from “list screen”:
            List<MobileElement> listView = driver.findElements(MobileBy.id("android:id/text1"));
            listView.get(3).click();

            //Swipe right:
            action.longPress(70, 500, fourSec).moveTo(10, 500).release().perform();
        }
        catch(Exception ex){
            Report.write(Status.FAIL, "ERROR: in scrolling on the screen.\n" +ex.getMessage(), driver);
        }
    }

    @AfterClass
    public static void CloseAll(){
        driver.quit();
    }
}
