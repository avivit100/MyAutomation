package JUnit;

import org.junit.*;

import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.By;

public class HomeWork {


//    @BeforeClass
//    public static void first(){
//        System.out.println("Before Class");
//    }
//
//    @Before
//    public void secound(){
//        System.out.println("Before");
//    }
//
//    @Test
//    public void third(){
//        System.out.println("Test");
//    }
//
//    @After
//    public void fourth(){
//        System.out.println("After");
//    }
//
//    @AfterClass
//    public static void fifth(){
//        System.out.println("After Class");
//    }

    private static WebDriver driverCH;
    private static WebDriver driverFF;
    private static WebDriver driverEd;

    @BeforeClass
    public static void beforeTesing(){
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
        driverCH =  new ChromeDriver();

        System.setProperty("webdriver.gecko.driver", "D:\\Automation\\Installs\\Selenium\\geckodriver.exe");
        driverFF = new FirefoxDriver();
//
//        System.setProperty("webdriver.edge.driver", "D:\Automation\Installs\Selenium\\MicrosoftWebDriver.exe");
//        driverEd = new InternetExplorerDriver();
    }



    @Test
    public  void runUrl() {
        driverCH.get("https://translate.google.co.il/");
        driverFF.get("https://www.youtube.com/");
//        driverEd.get("http://www.nrg.co.il/");

        driverCH.findElement(By.id("source")).sendKeys("please translate this text");
        driverCH.findElement(By.id("gt-submit")).click();

        driverFF.findElement(By.id("search")).sendKeys("Havana");
        driverFF.findElement(By.id("search-icon-legacy")).click();
    }
//
//    @Test
//    public void siteName(){
//        String strName = driverCH.getTitle();
//        driverCH.navigate().refresh();
//        assertEquals(strName, driverCH.getTitle());
//    }
    @Test
    public void siteDetails(){
//        String webTitle = "https://www.facebook.com/";
//        String webUrl = "Facebook";

//        assertEquals(webTitle, driverCH.getTitle());
//        assertEquals(webUrl, driverCH.getCurrentUrl());
    }

    @AfterClass
    public static void closeAll(){
//        driverCH.close();
//        driverFF.close();
//    driverIE.close();
    }
}
