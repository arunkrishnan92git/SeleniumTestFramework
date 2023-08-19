package nz.co.trademe.pages.tabs;

import io.qameta.allure.Step;
import nz.co.trademe.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BaseTab {

    @FindBy(css = "h3[class='tm-search-header-result-count__heading ng-star-inserted']")
    public WebElement searchResultCount;
    @FindBy(css = "button[type='submit']")
    public WebElement searchButton;
    private WebDriver driver;
    @FindAll({
            @FindBy(xpath = ("//div[@class='o-tabs__nav']/a"))
    })
    private List<WebElement> allTabs;


    public BaseTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click Tab")
    public void clickTab(List<WebElement> allTabs, String tabName) {
        int clicked = 0;
        WaitHelper.waitForPageToBeLoaded(driver);
        for (WebElement i : allTabs) {
            if (i.getText().equalsIgnoreCase(tabName)) {

                i.click();
                clicked = ++clicked;
                break;
            }
        }
        if (clicked == 0) {
            throw new RuntimeException(tabName + " could not be clicked ");
        }
    }

    @Step("Get Current Selected Tab")
    public String getCurrentSelectedTab() {
        WaitHelper.waitForPageToBeLoaded(driver);
        for (WebElement i : allTabs) {
            if (i.getAttribute("class").contains("selected")) {
                return i.getText();
            }
        }
        throw new RuntimeException("None of the tabs are selected");
    }

    @Step("Get all items in the dropdown list")
    public List<String> getAllItemsInDropDownList(WebElement allSelectItems) {
        WaitHelper.waitForPageToBeLoaded(driver);
        List allItemsInSelect = new ArrayList();
        Select s = new Select(allSelectItems);
        List<WebElement> allItems = s.getOptions();
        int size = allItems.size();
        for (int i = 0; i < size; i++) {
            String options = allItems.get(i).getText();
            allItemsInSelect.add(options);
        }
        return allItemsInSelect;
    }

    @Step("Select a dropdown item")
    public void selectDropDownItem(WebElement allDropDownItems, String item) {
        WaitHelper.waitForPageToBeLoaded(driver);
        Select s = new Select(allDropDownItems);
        List<WebElement> e = s.getOptions();
        int itemCount = e.size();
        for (int l = 0; l < itemCount; l++) {
            System.out.println(e.get(l).getText());
        }
        s.selectByVisibleText(item);
    }

    @Step("Get Search Result count")
    public String getSearchResultCount() {
        WaitHelper.waitForElementToBeVisible(driver, searchResultCount);
        return searchResultCount.getText();
    }


    @Step("Click Search")
    public void clickSearchButton() {
        WaitHelper.waitForElementToBeClickable(driver, searchButton);
        searchButton.click();
    }

}