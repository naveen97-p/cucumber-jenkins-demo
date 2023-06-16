package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CaptureScreen extends BrowserInstance{
    public byte[] takeScreenShot(){
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }
}
