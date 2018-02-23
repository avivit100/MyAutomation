package JUnit;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.Assert.*;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocatorsTest {
    private static WebDriver driverCH;
    private static WebDriver driverFF;
    private static WebDriver driverEd;


    @BeforeClass
    public static void setUpDrivers(){
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
        driverCH =  new ChromeDriver();

        System.setProperty("webdriver.gecko.driver", "D:\\Automation\\Installs\\Selenium\\geckodriver.exe");
        driverFF =  new FirefoxDriver();

        System.setProperty("webdriver.edge.driver", "D:\\Automation\\Installs\\Selenium\\MicrosoftWebDriver.exe");
        driverEd = new EdgeDriver();
    }

    @Test
    public  void a_OpenTranslate() {
        driverCH.get("https://translate.google.com/");
        WebElement elem = driverCH.findElement(By.linkText("Translate"));
        System.out.println(elem);
    }

    @Test
    public  void b_OpenYoutube() {
        driverFF.get("https://www.youtube.com/");
        WebElement elem = driverFF.findElement(By.id("search-icon-legacy"));
        System.out.println(elem);
    }

    @Test
    public  void c_OpenSelenium() {
        driverEd.get("http://www.seleniumhq.org/");
        WebElement elem = driverEd.findElement(By.name("q"));
        System.out.println(elem);
    }

    @Test
    public  void d_OpenAmazon() {
        driverCH.get("https://www.amazon.com/");
        assertEquals(driverCH.getTitle(), "Amazon");
        driverCH.findElement(By.id("twotabsearchtextbox")).sendKeys("Leather shoes");
        driverCH.findElement(By.className("nav-input")).submit();
    }

    @Test
    public  void e_OpenGmail() {
        driverCH.get("http://gmail.com");
        driverCH.findElement(By.id("identifierId")).sendKeys("avivit.hubara");
        driverCH.findElement(By.linkText("NEXT")).click();
        driverCH.findElement(By.name("password")).sendKeys("aviv");
        driverCH.findElement(By.linkText("NEXT")).click();

        System.out.println(driverCH.findElement(By.linkText("COMPOSE")));
    }

    @Test
    public  void f_OpenGithub() {
        driverCH.get("https://github.com/");
        driverCH.findElement(By.name("q")).sendKeys("Selenium");
        driverCH.findElement(By.id("Value")).sendKeys(Keys.ENTER);
    }

    //
    @AfterClass
    public static void closeAll(){
        driverCH.close();
        driverFF.close();
        driverEd.close();
    }
}
