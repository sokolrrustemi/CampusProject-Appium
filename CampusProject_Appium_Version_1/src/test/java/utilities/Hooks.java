package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {
    public static AndroidDriver<AndroidElement> androidDriver;
    DesiredCapabilities capabilities = new DesiredCapabilities();


    @BeforeTest
    public void setUpApplication()  {
        try{
            capabilities.setCapability("deviceName", "Pixel 7 Pro API 33");// Sanal cihazimin ismi
            capabilities.setCapability("platformName", "Android"); // sistem platformunun ismi
            capabilities.setCapability("platformVersion", "13.0");
            capabilities.setCapability("automationName","UiAutomator2");
            capabilities.setCapability("app",System.getProperty("user.dir")+"/app/mersyscampus.apk");
            androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"),capabilities);
        }catch (MalformedURLException e){
            System.out.println("URL Exception: "+ e.getMessage());
        }
    }

}
