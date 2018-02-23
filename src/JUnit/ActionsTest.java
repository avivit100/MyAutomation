package JUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.*;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActionsTest {
    private static WebDriver driverCH;
    @BeforeClass
    public static void setUpDrivers() {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
        driverCH = new ChromeDriver();
    }

    @Test
    public void A_OpenSite(){
        driverCH.get("https://dgotlieb.github.io/Actions/");
    }

    @Test
    public void B_DragWheel(){
        try {
            WebElement elemStart = driverCH.findElement(By.id("drag1"));
            WebElement elemEnd = driverCH.findElement(By.id("div1"));

            Actions dragDrop = new Actions(driverCH);
            dragDrop.dragAndDrop(elemStart, elemEnd);
            dragDrop.build().perform();
        }
        catch (Exception ex){
            System.out.println("ERROR: Element drag and drop not found.");
        }
    }

    @Test
    public void C_DBclick(){
        try {
            WebElement elemDBclick = driverCH.findElement(By.xpath("/html[1]/body[1]/p[2]"));

            Actions dBclick = new Actions(driverCH);
            dBclick.doubleClick(elemDBclick);
            dBclick.build().perform();

            WebElement elemTxt = driverCH.findElement(By.id("demo"));
            if (elemTxt.isDisplayed()) {
                assertEquals(elemTxt.getText(), "You double clicked");
            } else {
                System.out.println("Error: The text after Double Click not Found!!");
            }
        }

        catch (Exception ex){
        System.out.println("ERROR: Element double-click not found.");
        }
    }

    @Test
    public void D_MouseOver(){
        try {
            WebElement elemX = driverCH.findElement(By.id("close"));

            Actions mouseO = new Actions(driverCH);
            mouseO.moveToElement(elemX);
            mouseO.build().perform();
        }
        catch (Exception ex) {
            System.out.println("ERROR: Element mouse-over not found.");
        }
    }

    @Test
    public void E_SelectFood(){
        try {
            List<WebElement> elementsList = driverCH.findElements(By.name("food"));

            Actions select = new Actions(driverCH);
            select.clickAndHold((WebElement) elementsList.get(0)).clickAndHold((WebElement) elementsList.get(2)).click();
            select.build().perform();
        }
        catch (Exception ex){
            System.out.println("ERROR: Element List not found.");
        }
    }

    @Test
    public void F_UploadFile(){
        driverCH.findElement(By.name("pic")).sendKeys("D:\\Automation\\Files\\CubaPic.jpg");
    }

    @Test
    public void G_Scroll(){
        WebElement elemBtn = driverCH.findElement(By.id("clickMe"));
        ((JavascriptExecutor) driverCH).executeScript("arguments[0].scrollIntoView(true);", elemBtn);
    }

    @AfterClass
    public static void CloseAll(){
        driverCH.close();
    }
}
