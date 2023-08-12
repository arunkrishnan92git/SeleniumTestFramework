package nz.co.trademe.driver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends DriverManager{


    void createDriver() {

        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")
                + "/src/test/resources/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);


    }
}
