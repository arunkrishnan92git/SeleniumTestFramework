package nz.co.trademe.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    void createDriver() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "/src/test/resources/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

    }
}
