package nz.co.trademe.pages.tabs.jobs;

import nz.co.trademe.pages.tabs.BaseTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobsTab extends BaseTab {

    @FindBy(xpath = "//select[@name='region']")
    public WebElement locations;
    @FindBy(css = "button[type='submit']")
    public WebElement searchJobsButton;
    private WebDriver driver;


    public JobsTab(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
