package nz.co.trademe.pages;

import nz.co.trademe.pages.tabs.BaseTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    protected BaseTab baseTab;

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
