package MobileTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LocationElementExercise {
    private static AndroidDriver<MobileElement> driver;
    private static MobileElement mobileElem;

    @BeforeClass
    public static void setUp() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.google.com");

    }

    @Test
    public void A_PageSource() {
        //Print page source:
        String strSource = driver.getPageSource();
        System.out.println("The source of the page is:" + strSource);

        //Print all clickable elements locations:
        List <MobileElement> clickableElems = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
        System.out.println("The clickable elements on the page are located on:");
        for(int i=0; i<clickableElems.size(); i++) {
            System.out.println(clickableElems.get(i).getLocation().toString());
        }

        //Find the URL text field, by class name and print it's text:
        MobileElement mobileElem = driver.findElement(MobileBy.className("android.widget.EditText"));
        System.out.println("The text of the element: " + mobileElem.getText());
    }

    @Test
    public void B_ElementLocation(){
        //Find the GOOGLE logo, element and print it's size:
        mobileElem = driver.findElement(MobileBy.id("hplogo"));
        System.out.println("The size of the element: " + mobileElem.getSize());

        //Find the "a" sign on top right, and print it's X Y locations:
        mobileElem = driver.findElement(MobileBy.className("android.widget.Button"));
        System.out.println("The X of the element: " + mobileElem.getLocation().getX());
        System.out.println("The Y of the element: " + mobileElem.getLocation().getY());
    }

    @Test
    public void C_CHALLENGE(){
        //Type “banana” in search text field:
        mobileElem = driver.findElement(MobileBy.id("lst-ib"));
        mobileElem.sendKeys("banana");

        //Press search:
        mobileElem = driver.findElement(MobileBy.id("tsbb"));
        mobileElem.click();
    }

    @AfterClass
    public static void tearDown() throws IOException, InterruptedException {
        driver.quit();
    }
}
