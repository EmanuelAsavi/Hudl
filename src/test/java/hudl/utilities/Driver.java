package hudl.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    private Driver() {
    }


    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserType = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome" -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(options));
                }
                case "chrome-headless" -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    driverPool.set(new ChromeDriver(options));
                }
                case "firefox" -> {
                    FirefoxOptions options = new FirefoxOptions();
                    WebDriver firefoxDriver = new FirefoxDriver(options);
                    firefoxDriver.manage().window().fullscreen();
                    driverPool.set(firefoxDriver);
                }
                case "firefox-hadless" -> {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    driverPool.set(new FirefoxDriver(options));
                }

            }
        }
        return driverPool.get();

    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}
