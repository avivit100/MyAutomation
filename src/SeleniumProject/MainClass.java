package SeleniumProject;

import com.aventstack.extentreports.Status;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainClass {
    private static WebDriver driver;

    //Screens of the BuyMe site
    static Screen1_Registration register;
    static Screen2_Home home;
    static Screen3_ChooseGift gift;
    static Screen4_SendReceiveInfo sendInfo;

    @BeforeClass
    public static void Initialize(){
        try {
            //Read data from configuration file:
            ConfigFile.ReadData();

            //Set the selenium driver
            if (ConfigFile.getBrowser().equals(Constants.DRIVER_CHROME)) {
                System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
            }
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            try{
                //Open the log file:
                Log.OpenLogFile();
            }
            catch(IllegalArgumentException ex){
                System.out.println("ERROR: in Log file.\n" + ex.getMessage());
            }
            catch(Exception ex){
                System.out.println("ERROR: in Log file.\n" + ex.getMessage());
            }

            //Initialize the screens of the BuyMe site:
            register = PageFactory.initElements(driver, Screen1_Registration.class);
            home = PageFactory.initElements(driver, Screen2_Home.class);
            gift = PageFactory.initElements(driver, Screen3_ChooseGift.class);
            sendInfo = PageFactory.initElements(driver, Screen4_SendReceiveInfo.class);
        }
        catch(NullPointerException ex){
            Log.write(Status.FAIL, "ERROR: in Initialize.\n" + ex.getMessage(), driver);
        }
        catch (Exception ex){
            Log.write(Status.FAIL, "ERROR: in Initialize.\n" + ex.getMessage(), driver);
        }
    }

    @Test
    public void A_Register(){
        register.OpenSite();
        register.EXTRA_AssertErrorMessage();
        register.SubscribeWindow();
    }

    @Test
    public void B_Home(){
        home.EnterHomeScreen();
        home.SearchGift();
    }

    @Test
    public void C_ChooseGift(){
        gift.EnterGiftScreen();
        gift.AssertURL();
        gift.EXTRA_PrintShotBottom();
        gift.PickBusiness();
    }

    @Test
    public void D_SendReceiveInfo(){
        sendInfo.EnterInformationScreen();
        sendInfo.TypePurchaseDetails();
        sendInfo.EXTRA_AssertTextColor();
        sendInfo.EXTRA_AssertDetails();
        sendInfo.ClickSubmit();
    }

    @AfterClass
    public static void CloseAll(){
        driver.quit();
        Log.CloseLog();
    }

}
