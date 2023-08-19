package nz.co.trademe.pages.tabs.motors;

import nz.co.trademe.pages.tabs.BaseTab;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarsTab extends BaseTab {

    @FindBy(xpath = "//select[@name='selectedMake']")
    public WebElement carMakeDropDownList;
    private WebDriver driver;

    public CarsTab(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
