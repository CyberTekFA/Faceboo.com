package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BrowserUtils {

    public static String getScreenShot(String name){
        String time = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir")+"//test-output//screenshot"+name+time+".png";
        File fileDestination = new File(target);
        try{
            FileUtils.copyFile(source,fileDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }


}
