package JUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import java.util.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControllersTest {
    private static WebDriver driverCH;

    @BeforeClass
    public static void setUpDrivers() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
        driverCH = new ChromeDriver();
    }

    @Test
    public  void a_OpenGoogle() {
        driverCH.get("https://translate.google.com/");
        Select sHebrew = new Select(driverCH.findElement(By.id("gt-sl-gms")));
        sHebrew.selectByVisibleText("Hebrew");
        driverCH.findElement(By.id("source")).sendKeys("טקסט זה נועד לתרגום מעברית לאנגלית");
        driverCH.findElement(By.linkText("Translate")).click();
    }

    @Test
    public  void b_OpenYoutube() {
        driverCH.get("https://www.youtube.com/");
        driverCH.findElement(By.id("search")).sendKeys("Havana");
        driverCH.findElement(By.id("search-icon-legacy")).click();
    }

    @Test
    public  void c_OpenGithub() {
        driverCH.get("https://dgotlieb.github.io/Controllers/Controllers.html");
        driverCH.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/input[3]")).click();
        Select sel = new Select(driverCH.findElement(By.name("dropdownmenu")));
        sel.selectByVisibleText("Milk");
        List <WebElement> options = sel.getOptions();
        for(WebElement elem:options){
            System.out.println(elem.getText());
        }
    }

    @Test
    public  void d_OpenGoogleTranslate() {
        driverCH.get("https://translate.google.com/");
        WebElement elem;
        elem = driverCH.findElement(By.id("gt-submit"));
        System.out.println(elem);
        elem = driverCH.findElement(By.linkText("Translate"));
        System.out.println(elem);
        elem = driverCH.findElement(By.partialLinkText("Trans"));
        System.out.println(elem);
    }

    @Test
    public  void e_OpenFacebooke() {
        driverCH.get("https://www.facebook.com/");
        driverCH.findElement(By.id("email")).sendKeys("avivit100@yahoo.com");
        driverCH.findElement(By.id("pass")).sendKeys("vitvit100%");
        driverCH.findElement(By.id("u_0_a")).submit();
    }

    @Test
    public  void f_deleteCookies() {
        driverCH.get("https://www.ynet.co.il/");
        Set<Cookie> cookies = driverCH.manage().getCookies();
        for(Cookie cook:cookies){
            System.out.println(cook.getName());
            driverCH.manage().deleteCookie(cook);
        }
    }

    @Test
    public  void g_openMyEmail() {
        driverCH.get("http://gmail.com");
        driverCH.findElement(By.id("identifierId")).sendKeys("avivit.hubara");
        driverCH.findElement(By.linkText("NEXT")).click();
        driverCH.findElement(By.name("password")).sendKeys("aviv");
        driverCH.findElement(By.linkText("NEXT")).click();

        driverCH.findElement(By.linkText("COMPOSE")).click();
        driverCH.findElement(By.id(":oc")).sendKeys("avivit100@yahoo.com");
        driverCH.findElement(By.id(":nv")).sendKeys("My automatic email");
        driverCH.findElement(By.id(":ow")).sendKeys("This is an automatic text to be send");
        driverCH.findElement(By.id(":nl")).click();
    }

    @Test
    public  void h_openThemarker() {
        driverCH.get("https://www.themarker.com/");
        String strSource = driverCH.getPageSource();
        String[] strArr = strSource.split("news");
        System.out.println(strArr.length-1);
    }

    //
    @AfterClass
    public static void closeAll() {
        driverCH.close();
    }
}
