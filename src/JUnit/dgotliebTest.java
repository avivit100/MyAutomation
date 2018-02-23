package JUnit;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class dgotliebTest {
    private static WebDriver driverCH;

    @BeforeClass
    public static void setUpDrivers() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
        driverCH = new ChromeDriver();
    }

    @Test
    public void A_OpenCalcutator() {
        //1
        driverCH.get ("https://dgotlieb.github.io/WebCalculator/");
        //2
        WebElement elem = driverCH.findElement(By.id("seven"));
        System.out.println("Height of seven: " + elem.getSize().height);
        System.out.println("Width of seven: " + elem.getSize().width);
        //3
        if (driverCH.findElement(By.id("six")).isDisplayed() == true){
            System.out.println("Six is dispalyed");
        }
        else{
            System.out.println("Six is not dispalyed");
        }
        //4
        int iResult = 99;
        //5
        driverCH.findElement(By.id("one")).click();
        driverCH.findElement(By.id("one")).click();
        driverCH.findElement(By.id("multiply")).click();
        driverCH.findElement(By.id("nine")).click();
        driverCH.findElement(By.id("equal")).click();
        assertEquals(driverCH.findElement(By.id("screen")).getText(), iResult);
    }

    @Test
    public void B_Calcutator() {
        driverCH.get ("https://dgotlieb.github.io/WebCalculator/");
        System.out.println("Height of two: " + driverCH.findElement(By.id("two")).getSize().height);
        System.out.println("Width of six: " + driverCH.findElement(By.id("six")).getSize().width);
        WebElement elem = driverCH.findElement(By.id("nine"));
        int iX = 521;
        int iY = 167;
        assertEquals(elem.getLocation().x, iX);
        assertEquals(elem.getLocation().y, iY);
    }

    @Test
    public void C_openSynchronize() {
        driverCH.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driverCH.get("https://dgotlieb.github.io/Selenium/synchronization.html");

        driverCH.findElement(By.id("btn")).click();
        if (driverCH.findElement(By.id("message")).isDisplayed()) {
            System.out.println("After click 'Remove checkbox' new element is found");
        }
        else{
            System.out.println("After click 'Remove checkbox' new element is not found");
        }

        driverCH.findElement(By.id("hidden")).click();
        try {
            Thread.sleep(7000);
        }
        catch(InterruptedException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        if (driverCH.findElement(By.id("finish1")).isDisplayed()){
            System.out.println("After click 'Show hidden' new element is found");
        }
        else{
            System.out.println("After click 'Show hidden' new element is not found");
        }

        WebDriverWait wait = new WebDriverWait(driverCH, 5);
        driverCH.findElement(By.id("rendered")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
        if (driverCH.findElement(By.id("finish2")).isDisplayed()){
            System.out.println("After click 'Render' new element is found");
        }
        else{
            System.out.println("After click 'Render' new element is not found");
        }
    }

    @Test
    public void D_openAngularJS() {
        NgWebDriver angular = new NgWebDriver((JavascriptExecutor)driverCH);
        driverCH.get("https://dgotlieb.github.io/AngularJS/main.html");
        angular.waitForAngular2RequestsToFinish();

        WebElement elemName = driverCH.findElement(ByAngular.model("firstName"));
        driverCH.findElement(ByAngular.model("firstName")).clear();

        String myName = "Avivit";
        elemName.sendKeys(myName);

        assertEquals(elemName.getText(), myName);
    }

    @Test
    public void E_withoutAngularJS() {
        driverCH.get("https://dgotlieb.github.io/AngularJS/main.html");
        WebElement elemName = driverCH.findElement(By.className("ng-dirty"));
        elemName.clear();
        String myName = "Andrew";
        elemName.sendKeys(myName);

        assertEquals(driverCH.findElement(By.linkText(myName)).getText(), myName);
    }

    @AfterClass
    public static void closeAll() {
        driverCH.close();
    }
}
