package nz.co.trademe.pages.tabs.motors;

import io.qameta.allure.Step;
import nz.co.trademe.pages.tabs.BaseTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MotorsTab extends BaseTab {
    private WebDriver driver;


    public MotorsTab(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("Get Title")
    public String getTitle() {
        return this.getTitle();
    }

}