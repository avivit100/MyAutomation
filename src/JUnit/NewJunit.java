package JUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NewJunit {
    private static WebDriver driverCH;
    private static WebDriver driverFF;
    private static WebDriver driverEd;

    @BeforeClass
    public static void setUpJunit(){
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
        driverCH =  new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", "D:\Automation\Installs\Selenum\\geckodriver.exe");
//        driverFF =  new FirefoxDriver();
//
//        System.setProperty("webdriver.edge.driver", "D:\Automation\Installs\Selenum\\MicrosoftWebDriver.exe");
//        driverEd = new InternetExplorerDriver();
    }

    @Test
    public  void a_OpenGoogle() {
        driverCH.get("https://translate.google.com/");
        System.out.println(driverCH.findElement(By.linkText("Translate")));
    }

//    @Test
//    public  void b_OpenYoutube() {
//        driverFF.get("https://www.youtube.com/");
//        System.out.println(driverFF.findElement(By.id("search-icon-legacy")));
//    }

//    @Test
//    public  void c_OpenSelenium() {
//        driverEd.get("http://www.seleniumhq.org/");
//        System.out.println(driverEd.findElement(By.name("q")));
//    }

    @Test
    public  void d_OpenAmazon() {
        driverCH.get("https://www.amazon.com/");
        //assert Equals(driverCH.getTitle(), "Amazon");
        driverCH.findElement(By.id("twotabsearchtextbox")).sendKeys("Leather shoes");
    }

    @Test
    public  void e_OpenGmail() {
        driverCH.get("http://gmail.com");
        driverCH.findElement(By.id("identifierId")).sendKeys("avivit.hubara");
        driverCH.findElement(By.linkText("NEXT")).click();
        driverCH.findElement(By.name("password")).sendKeys("vitvit100");
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
