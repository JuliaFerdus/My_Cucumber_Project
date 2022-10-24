package stepDef;

import base.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.util.Strings;

public class Hook extends Config {
    public static String url;
    public static String eMail;
    public static String password;
    public static String driverType = System.getProperty("browser");
    public static String envType = System.getProperty("env");

    @Before
    public void startTest(){
        if(Strings.isNullOrEmpty(driverType)){
            driverType="ch";
        }
        if(Strings.isNullOrEmpty(envType)) {
            envType = "stg";
        }
        // open browser - browser type
        // go to url - envType
        driver = setupBrowser (driverType);
        switch (envType){
            case "qa":
                url = "https://qa.taltektc.com";
                eMail = "testoctqaenv@gmail.com";
                password = "Test1234$";
                break;
            case "stg":
                url = "https://stage.taltektc.com";
                eMail = "stg1234@gmail.com";
                password = "Password1$";
                break;
        }
        driver.get(url);
    }
    @After
    public void endTest(Scenario scenario){
        // close driver, create report, if test fail, take screenshot
        try{
            if (scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        }finally {
            driver.quit();
        }

    }


}

