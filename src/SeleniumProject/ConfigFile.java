package SeleniumProject;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ConfigFile {
    private static String URL;
    private static String browser;
    private static String reportFile;
    private static String uploadFile;

    public static void ReadData(){

        try {
            //Open the config file:
            File fXmlFile = new File(Constants.CONFIG_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            //Read the parameters from the config file:
            URL = doc.getElementsByTagName("URL").item(0).getTextContent();
            browser = doc.getElementsByTagName("Browser").item(0).getTextContent();
            reportFile = doc.getElementsByTagName("Report").item(0).getTextContent();
            uploadFile = doc.getElementsByTagName("Upload").item(0).getTextContent();
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
    public static String getURL(){ return URL;}
    public static String getBrowser(){ return browser; }
    public static String getReportFile() { return reportFile; }
    public static String getUploadFile() { return uploadFile; }
}


