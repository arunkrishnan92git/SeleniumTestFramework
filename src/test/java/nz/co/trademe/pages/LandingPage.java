package nz.co.trademe.pages;

import io.qameta.allure.Step;
import nz.co.trademe.pages.tabs.BaseTab;
import nz.co.trademe.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class LandingPage extends BasePage {

    @FindAll({
            @FindBy(xpath = ("//ul[@class='tm-homepage-search-header__vertical-links-list']/li"))
    })
    public List<WebElement> allSearchMenuTabs;
    @FindBy(linkText = " Log in ")
    public WebElement login;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @Step("Get All Main Menu Tabs")
    public List<WebElement> getAllSearchMenuTabs() {
        WaitHelper.waitForPageToBeLoaded(driver);
        return allSearchMenuTabs;
    }


    @Step("Click Search Menu")
    public void clickSearchMenu(String tabName) {
        baseTab = new BaseTab(driver);
        WaitHelper.waitForPageToBeLoaded(driver);
        baseTab.clickTab(allSearchMenuTabs, tabName);
    }
}