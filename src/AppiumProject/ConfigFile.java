package AppiumProject;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ConfigFile {
    private static String appPackage;
    private static String appActivity;
    private  static String reportFilePath;

    public static void ReadData(){

        try {
            //Open the config file:
            File fXmlFile = new File(Utilities.CONFIG_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            //Read the parameters from the config file:
            appPackage = doc.getElementsByTagName("appPackage").item(0).getTextContent();
            appActivity = doc.getElementsByTagName("appActivity").item(0).getTextContent();
            reportFilePath = doc.getElementsByTagName("Report").item(0).getTextContent();
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
        catch (Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    //GET functions for the parameters:
    public static String getAppPackage(){ return appPackage; }
    public static String getAppActivity(){ return appActivity; }
    public static String getReportPath(){return reportFilePath;}
}



