package JUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainClass {
    static CalculatorTest calc;
    private static WebDriver driverCH;

    @BeforeClass
    public static void Initialize(){
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
        driverCH = new ChromeDriver();

        calc = PageFactory.initElements(driverCH, CalculatorTest.class);
    }

    @Test
    public void CalcTest(){
        calc.OpenSite();
        calc.SevenDimensions();
        calc.SixDispaly();

        calc.CalculteMath();
        calc.AssertResult();
    }

    @AfterClass
    public static void CloseAll(){
        //driverCH.close();
    }

}
