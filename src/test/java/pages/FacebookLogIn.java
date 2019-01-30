package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.awt.windows.WEmbeddedFrame;
import utilities.Driver;

public class FacebookLogIn {
    public FacebookLogIn() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement userName;
    @FindBy(id = "pass")
    public WebElement password;

    @FindBy(linkText = "Log In")
    public WebElement logIn;
}
