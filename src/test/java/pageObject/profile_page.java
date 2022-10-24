
package pageObject;

import base.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class profile_page extends Config {
    // constructor
    public profile_page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Config.driver = driver;
    }
    // locators
    @FindBy(how= How.XPATH, using = "//*[@id='profile_form']/legend")
    public WebElement welcomeProfileLoc;
    @FindBy(how= How.NAME, using = "email")
    public WebElement emailLocator;
// functions
   public void verifyEmailAddressIsCorrect(String expEmail) {
       String actEmail = emailLocator.getAttribute("value");
       System.out.println("My Email is:==>"+actEmail);
       Assert.assertEquals(actEmail, expEmail);
   }
   public void verifyWelcomeTitle(){
       String exp = "Welcome to TalentTek";
       String act = welcomeProfileLoc.getText();
       System.out.println("Actual Title is:==>"+act);
       Assert.assertEquals(act, exp);

   }
}