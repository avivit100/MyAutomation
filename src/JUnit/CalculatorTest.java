package JUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

class Constants{
    public static final String ONE = "one";
    public static final String FIVE = "five";
    public static final String SEVEN = "seven";
    public static final String SIX  = "six";
    public static final String CLEAR  = "clear";
    public static final String MULT  = "multiply";
    public static final String EQUAL  = "equal";
    public static final int RESULT = 55;
}

public class CalculatorTest {
    WebDriver driverCH;

    public CalculatorTest(WebDriver driver){
        driverCH = driver;
    }

    public void OpenSite() {
        driverCH.get("https://dgotlieb.github.io/WebCalculator/");
    }

    public void SevenDimensions() {
        System.out.println("Dimensions of button " + Constants.SEVEN + ":" +
                driverCH.findElement(By.id(Constants.SEVEN)).getSize());
    }

    public void SixDispaly(){
        if (driverCH.findElement(By.id(Constants.SIX)).isDisplayed()){
            System.out.println(Constants.SIX + " button is displayed");
        }
    }

    public void CalculteMath(){
        driverCH.findElement(By.id(Constants.CLEAR)).click();
        driverCH.findElement(By.id(Constants.ONE)).click();
        driverCH.findElement(By.id(Constants.ONE)).click();
        driverCH.findElement(By.id(Constants.MULT)).click();
        driverCH.findElement(By.id(Constants.FIVE)).click();
        driverCH.findElement(By.id(Constants.EQUAL)).click();
    }

    //////////////////
    //  Main Class  //
    //////////////////
    public void AssertResult(){
        assertEquals (driverCH.findElement(By.id("screen")), Constants.RESULT);
    }
}
