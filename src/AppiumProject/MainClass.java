package AppiumProject;

import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.lang.RuntimeException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MainClass {
    private static AndroidDriver<MobileElement> driver;

    //Screens of the test:
    static PageA_Registration registration;
    static PageB_Home home;
    static PageC_SenderReceiverInfo ssInfo;
    static PageD_HowToSend send;


    @BeforeClass
    public static void setUp() throws IOException {
        try {
            //Read data from configuration file:
            ConfigFile.ReadData();
            Report.OpenReportFile();
        }
        catch(Exception ex){
            System.out.println("ERROR: " +ex.getMessage());
        }

        try {
            //Set the appium capabilities:
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
            capabilities.setCapability("appPackage", ConfigFile.getAppPackage());
            capabilities.setCapability("appActivity", ConfigFile.getAppActivity());
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        catch(WebDriverException ex){
            Report.write(Status.FAIL,"ERROR: in setting up the Appium.\n"+ ex.getMessage(), driver);
        }
        catch(Exception ex){
            Report.write(Status.FAIL, "ERROR: in setup.\n"+ ex.getMessage(), driver);
        }
        try {
            //Initialize the screens:
            registration = PageFactory.initElements(driver, PageA_Registration.class);
            home = PageFactory.initElements(driver, PageB_Home.class);
            ssInfo = PageFactory.initElements(driver, PageC_SenderReceiverInfo.class);
            send = PageFactory.initElements(driver, PageD_HowToSend.class);
        }
        catch(RuntimeException ex){
            Report.write(Status.FAIL, "ERROR: in setting Page Factory.\n" + ex.getMessage());
        }
        catch (Exception ex){
            Report.write(Status.FAIL, "ERROR: in setting Page Factory.\n" + ex.getMessage());
        }
    }

    @Test
    public void A_Registration(){
        registration.clickToEnter();
        registration.RegisterGoogle();
    }

    @Test
    public void B_Home(){
        home.ChooseGift();
    }

    @Test
    public void C_Info(){
        ssInfo.FillInformation();
    }

    @Test
    public void D_Send(){
        send.SendGift();
    }

    @AfterClass
    public static void CloseAll(){
        Report.write(Status.INFO,"End of Automation test with Appium.");
        driver.quit();
        Report.CloseReport();
    }
}
