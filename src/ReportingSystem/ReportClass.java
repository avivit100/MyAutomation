package ReportingSystem;

import SeleniumProject.ConfigFile;
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

public class ReportClass {
    //Objects for the log file:
    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test;

    //Get current time for the log file name, and  the screen-shot file name:
    private static String timeStamp = new SimpleDateFormat("HHmmss_ddMMyyyy").format(Calendar.getInstance().getTime());

    private static String strPath = "c:\\Reporting\\";

    //Counter for the print-Shot file name:
    private static int iCount = 0;

    public static void OpenLogFile(){
        //the Log file name = Log path + the current date&time:
        String strLogFile = strPath + timeStamp + ".html";

        //Create the log file, and add definitions:
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(strLogFile);
        htmlReporter.setAppendExisting(true);
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester", "Avivit Hubara");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("Company", "eGov");
        test = extent.createTest("Test BuyMe site", "The results of the automation test of BuyMe web site");
        test.log(Status.INFO, "Starts to run automation!");
    }

    //write details to the log file::
    public static void write(Status status, String details){
        test.log(status, details);
    }


    public static void takeScreenShot(WebDriver driver) {
        //each screen-shot file name = Log path + current date&time + counter:
        iCount++;
        String strImgFile = strPath + "\\PrintShot\\" + timeStamp + "_" + iCount + ".png";

        //take the screen-shot:
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(strImgFile);

        try {
            //locate the shot file under it's path and show in the log file:
            FileUtils.copyFile(screenShotFile, destinationFile);
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath
                    (strImgFile).build());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Close and locate the log file under it's path:
    public static void CloseLog(){
        extent.flush();
    }
}
