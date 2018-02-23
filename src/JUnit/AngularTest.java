package JUnit;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.*;


import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AngularTest {
    private static WebDriver driverCH;
    private static NgWebDriver ng;

    @BeforeClass
    public static void loadAngular(){
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
        driverCH = new ChromeDriver();

//        ng = new NgWebDriver((JavascriptExecutor) driverCH);
//        ng.waitForAngular2RequestsToFinish();
    }

    @Test
    public  void a_sleep() {
        driverCH.get("https://www.themarker.com/");
        //Thread.sleep(1000);

    }
//    @Test
//    public  void b_implicit() {
//        driverCH.get("https://www.themarker.com/");
//        driverCH.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//
//    }
    @Test
    public  void c_explicit() {
        driverCH.get("https://www.themarker.com/");
        WebDriverWait wait = new WebDriverWait(driverCH,1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mh__logo mh__logo--large")));

    }

//    @Test
//    public  void z_angular() {
//        driverCH.get("https://www.themarker.com/");
//        driverCH.findElement(ByAngular.exactRepeater("this is a reporter"));
//    }


    @AfterClass
    public static void closeAll() {
        driverCH.close();
    }
}
