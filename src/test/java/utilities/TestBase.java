package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected SoftAssert softAssert;

    protected static ExtentReports reports;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest testLogger;

    @BeforeTest
    public void setReports(){
        reports = new ExtentReports();
        String filePath = System.getProperty("user.dir")+"//test-output//report.html";
        htmlReporter = new ExtentHtmlReporter(filePath);
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("Environment","Staging");
        reports.setSystemInfo("OS",System.getProperty("os.name"));
        reports.setSystemInfo("QA Engineer","Faiz Amiree");
        htmlReporter.config().setDocumentTitle("Facebook LogIn Page");
        htmlReporter.config().setReportName("Facebook LogIn Page Automation");
    }

    @BeforeMethod
    public void setDriver(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @AfterMethod
    public void generatReport(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            testLogger.fail(result.getName());
            testLogger.addScreenCaptureFromPath(BrowserUtils.getScreenShot(result.getName()));
            testLogger.fail(result.getThrowable());
        }else if(result.getStatus() == ITestResult.SUCCESS){
            testLogger.pass(result.getName());
        }else if(result.getStatus() == ITestResult.SKIP){
            testLogger.skip("Test case been Skiped"+result.getName());
            testLogger.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void tearReport(){
        reports.flush();
    }
}
