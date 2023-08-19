package nz.co.trademe.base;

import nz.co.trademe.driver.DriverManager;
import nz.co.trademe.driver.DriverManagerFactory;
import nz.co.trademe.driver.DriverType;
import nz.co.trademe.pages.LandingPage;
import nz.co.trademe.pages.tabs.motors.CarsTab;
import nz.co.trademe.pages.tabs.motors.MotorsTab;
import nz.co.trademe.utils.TestConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    public MotorsTab motorsTab;
    public CarsTab carSearchTab;
    DriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        createLocalDriver(TestConfig.getEnvProperty("browser"));
        driver.manage().window().maximize();
        driver.navigate().to(TestConfig.getEnvProperty("url"));
    }

    public WebDriver getDriver() {
        return driver;
    }

    //Used to get the browser type and create a local driver used for testing.
    public void createLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
            driver = driverManager.getDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
            driver = driverManager.getDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driverManager = DriverManagerFactory.getManager(DriverType.EDGE);
            driver = driverManager.getDriver();
        }
    }


    @AfterMethod
    public void tearDown() {
        driverManager.quitDriver();
    }

}