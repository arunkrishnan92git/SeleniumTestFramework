package nz.co.trademe.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    WebDriver driver;

    abstract void createDriver();

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
