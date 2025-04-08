package hudl.step_definitions;

import hudl.utilities.BrowserUtils;
import hudl.utilities.ConfigurationReader;
import hudl.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {


    @Before ()
    public void login_hudl_scenario_before(){
        Driver.getDriver().get(ConfigurationReader.getProperty("baseURL"));
    }



    @After
    public void teardownMethod(Scenario scenario){

        BrowserUtils.sleep(2);
        byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

        Driver.closeDriver();

    }


}