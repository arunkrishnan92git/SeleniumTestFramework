package nz.co.trademe.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{

    void createDriver() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
                + "/src/test/resources/driver/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }
}
