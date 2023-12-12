package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;

import static io.appium.java_client.touch.offset.PointOption.point;

public class Methods extends Hooks{

    public void wait(int sec) {

        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
