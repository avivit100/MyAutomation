package AppiumProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Report {
    //Objects for the report file:
    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test;

    //Get current time for the report file name, and  the screen-shot file name:
    private static String timeStamp = new SimpleDateFormat("HHmmss_ddMMyyyy").format(Calendar.getInstance().getTime());

    //Get the report file path from the config file:
    private static String strPath = ConfigFile.getReportPath();

    //Counter for the print-Shot file name:
    private static int iCount = 0;

    public static void OpenReportFile(){
        //the report file name = report path + the current date&time:
        String strReportFile = strPath + "\\" + timeStamp + ".html";

        //Create the report file, and add definitions:
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(strReportFile);
        htmlReporter.setAppendExisting(true);
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester", "Avivit Hubara");
        extent.setSystemInfo("Mobile", "Android");
        extent.setSystemInfo("Test type", "Sanity");
        extent.setSystemInfo("Environment", "Test");
        test = extent.createTest("Test BuyMe mobile application", "The results of the automation test of BuyMe mobile application");
        test.log(Status.INFO, "Starts to run automation over BuyMe mobile application!");
    }

    //write details to the report file::
    public static void write(Status status, String details){
        test.log(status, details);
    }

    //write details with screen-shot to the report file:
    public static void write(Status status, String details, WebDriver webPrintScreen){
        test.log(status, details);
        try {
            //screen-shot of the screen and add it to the report file:
            test.pass("Print screen:", MediaEntityBuilder.createScreenCaptureFromPath
                    (takeScreenShot(webPrintScreen)).build());
        }
        catch(IOException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    private static String takeScreenShot(WebDriver driver) {
        //each screen-shot file name = report path + current date&time + counter:
        iCount++;
        String strImgFile = strPath + "\\PrintShot\\" + timeStamp + "_" + iCount;

        //take the screen-shot:
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(strImgFile+".png");

        try {
            //locate the shot file under it's path and show in the report file:
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return strImgFile + ".png";
    }

    //Close and locate the report file under it's path:
    public static void CloseReport(){
        extent.flush();
    }
}

