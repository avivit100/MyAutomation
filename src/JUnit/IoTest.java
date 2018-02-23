package JUnit;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IoTest {
    private static String strFileName, strUrl;

    @BeforeClass
    public static void setUpDrivers() {
        strFileName = "D:\\Automation\\Files\\MyWebSite.xml";
        strUrl = "";
    }

    @Test
    public void A_ReadURL () {
        try {
            File fXmlFile = new File(strFileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            strUrl = doc.getElementsByTagName("URL").item(0).getTextContent();
        }
        catch (ParserConfigurationException pEx){
            System.out.println("ERROR: " + pEx.getMessage());
        }
        catch(IOException ioEx){
            System.out.println("ERROR: " + ioEx.getMessage());
        }
        catch(SAXException sEx){
            System.out.println("ERROR: " + sEx.getMessage());
        }

    }

    @Test
    public void B_OpenURL () {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Installs\\Selenium\\chromedriver.exe");
        WebDriver driverCH = new ChromeDriver();

        if (strUrl != "") {
            driverCH.get(strUrl);
        }
        else System.out.println("No url was found in file: " + strFileName);
        driverCH.close();
    }
}
