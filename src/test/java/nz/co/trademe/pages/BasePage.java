package nz.co.trademe.pages;

import nz.co.trademe.pages.tabs.BaseTab;
import org.openqa.selenium.WebDriver;


public class BasePage {
    public WebDriver driver;
    protected BaseTab baseTab;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
