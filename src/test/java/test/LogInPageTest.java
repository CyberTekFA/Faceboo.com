package test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.FacebookLogIn;
import utilities.TestBase;

public class LogInPageTest extends TestBase {

    FacebookLogIn facebook = new FacebookLogIn();

    @Test
    public void  test(){
        testLogger = reports.createTest("LogIn test");
        facebook.userName.sendKeys("User");
        testLogger.pass("UserName Entered");
        facebook.password.sendKeys("password");
        testLogger.pass("Password Entered");
        Assert.assertEquals(5,6);
        testLogger.info("assertion added");
        facebook.logIn.click();
        testLogger.pass("lonIn button clicked");
        testLogger.assignAuthor("test Excuted By Faiz");
        testLogger.pass("passed");

    }
    @Test
    public void  test1() {
        testLogger = reports.createTest("LogIn test");
        facebook.userName.sendKeys("User");
        testLogger.pass("UserName Entered");
        facebook.password.sendKeys("password");
        testLogger.pass("Password Entered");
        facebook.logIn.click();
        testLogger.pass("lonIn button clicked");
        testLogger.assignAuthor("test Excuted By Faiz");
        testLogger.pass("passed");
    }
    @Test
    public void  test2() {
        testLogger = reports.createTest("LogIn test");
        facebook.userName.sendKeys("User");
        testLogger.pass("UserName Entered");
        facebook.password.sendKeys("password");
        testLogger.pass("Password Entered");
        facebook.logIn.click();
        testLogger.pass("lonIn button clicked");
        testLogger.assignAuthor("test Excuted By Faiz");
        testLogger.pass("passed");
        throw  new SkipException("test skiped");
    }
}
