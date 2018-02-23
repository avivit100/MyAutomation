import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;

public class MainSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking"); //("-incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.co.il/maps?source=tldso");

        System.out.println("My URL: " + driver.getCurrentUrl());
        System.out.println("My Title: " + driver.getTitle());
        System.out.println("My source: " + driver.getPageSource());
        System.out.println("My handle: " + driver.getWindowHandle());
        System.out.println("My manage: " + driver.manage());
    }
}
