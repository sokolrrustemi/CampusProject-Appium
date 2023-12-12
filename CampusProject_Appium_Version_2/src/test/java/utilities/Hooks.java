package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    public static AndroidDriver<AndroidElement> androidDriver;
    static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static WebDriverWait wait;

    public void setUp() {
        try {
            capabilities.setCapability("deviceName", ConfigReader.getProperty("deviceName"));
            capabilities.setCapability("platformName", ConfigReader.getProperty("platformName"));
            capabilities.setCapability("platformVersion", ConfigReader.getProperty("platformVersion"));
            capabilities.setCapability("automationName", ConfigReader.getProperty("automationName"));
            capabilities.setCapability("app", System.getProperty("user.dir") + ConfigReader.getProperty("app"));
            capabilities.setCapability("noReset", true);
            androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"), capabilities);
            wait = new WebDriverWait(androidDriver, 10);
        } catch (MalformedURLException e) {
            System.out.println("Malformed Url Exception:" + e.getMessage());
        }
    }

    public void tearDown() {
        if (androidDriver != null) {
            androidDriver.quit();
            androidDriver.closeApp();
            androidDriver = null;
        }
    }
}
