package nz.co.trademe.pages.tabs.jobs;

import io.qameta.allure.Step;
import nz.co.trademe.pages.tabs.BaseTab;
import nz.co.trademe.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class JobsTab extends BaseTab {

    private WebDriver driver;
    private  BaseTab baseTab;

    public JobsTab(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@name='region']")
    public WebElement locations;


    @FindBy(css = "button[type='submit']")
    public WebElement searchJobsButton;


}
