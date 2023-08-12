package nz.co.trademe.pages.tabs.motors;

import io.qameta.allure.Step;
import nz.co.trademe.pages.tabs.BaseTab;
import nz.co.trademe.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MotorsTab extends BaseTab {
    private WebDriver driver;
    private BaseTab baseTab;


    public MotorsTab(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @Step("Get Title")
    public String getTitle(){
        return this.getTitle();
    }

}