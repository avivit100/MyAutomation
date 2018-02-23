package JUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import java.util.*;
import org.openqa.selenium.Keys;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NavigationTest {
    private static WebDriver driverCH;

    @BeforeClass
    public static void setUpDrivers() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
        driverCH = new ChromeDriver();
    }

    @Test
    public  void a_OpenNavigation() {
        //1
        driverCH.get("https://dgotlieb.github.io/Navigation/Navigation.html");
        //2
        driverCH.findElement(By.id("MyAlert")).click();
        System.out.println(driverCH.switchTo().alert().getText());
        driverCH.switchTo().alert().accept();
        //3
        String myName = "Avivit Huabara";
        driverCH.findElement(By.id("MyPrompt")).click();
        driverCH.switchTo().alert().sendKeys(myName);
        driverCH.switchTo().alert().accept();
        assertEquals(driverCH.findElement(By.id("output")).getText(), myName);
        //4
        driverCH.findElement(By.id("MyConfirm")).click();
        driverCH.switchTo().alert().dismiss();
        assertEquals(driverCH.findElement(By.id("output")).getText(), "canceled");
        //5
        System.out.println(driverCH.findElement(By.id("iframe_container")).getText());
        //6
        String oldTab = driverCH.getWindowHandle();
        String newTab = Keys.chord(Keys.CONTROL,"t");
        driverCH.findElement(By.linkText("http://ynet.co.il")).sendKeys(newTab);
        driverCH.switchTo().window(oldTab);
        //7
       String oldWin = driverCH.getWindowHandle();
       driverCH = new ChromeDriver();
       driverCH.navigate().to("http://walls.co.il");
       driverCH.switchTo().window(oldWin);
    }

    @Test
    public  void b_OpenNewTabs() {
        String newTab = Keys.chord(Keys.CONTROL,"t");
        driverCH.get("http://www.google.com");

        driverCH.findElement(By.linkText("http://www.youtube.com")).sendKeys(newTab);
        driverCH.findElement(By.linkText("https://translate.google.com")).sendKeys(newTab);

        ArrayList<String> allTabs = new ArrayList<String> (driverCH.getWindowHandles());
        System.out.println("From Translate go to Google");
        driverCH.switchTo().window(allTabs.get(0));
        System.out.println("From Google go to Youtubr");
        driverCH.switchTo().window(allTabs.get(1));

        for (int i=0; i<allTabs.size(); i++){
            driverCH.switchTo().window(allTabs.get(i));
            driverCH.close();
        }
    }

    @Test
    public  void c_OpenNewWindows() {
        driverCH.get("https://www.youtube.com/");
        String oldWin = driverCH.getWindowHandle();
        driverCH = new ChromeDriver();
        driverCH.navigate().to("https://www.youtube.com/watch?v=OcgIBUllRm4");
        driverCH.switchTo().window(oldWin);
        driverCH.close();
    }

    @AfterClass
    public static void closeAll(){
        driverCH.close();
    }
}
