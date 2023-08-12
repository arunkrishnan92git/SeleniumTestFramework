package nz.co.trademe;

import io.qameta.allure.Step;
import nz.co.trademe.base.BaseTest;
import nz.co.trademe.pages.LandingPage;
import nz.co.trademe.pages.tabs.motors.CarsTab;
import nz.co.trademe.pages.tabs.motors.MotorsTab;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CarSearchTest extends BaseTest {
    @Step("Selecting Motors tab in Landing Page")
    @BeforeMethod
    public void carSetUp() {
        landingPage = new LandingPage(driver);
        landingPage.clickSearchMenu("Motors");
        motorsTab = new MotorsTab(driver);
    }

    @Test
    public void verifyDefaultSelectedTab() {
        //Verify if the Cars Tab is automatically selected
        Assert.assertEquals(motorsTab.getCurrentSelectedTab(), "Cars", "Cars Tab is not selected");
    }

    @Test
    public void verifyNumberOfCarMakesAvailable() {
        carSearchTab = new CarsTab(driver);
        //Verify the number of car makes available in the car drop down
        Assert.assertEquals(carSearchTab.getAllItemsInDropDownList(carSearchTab.carMakeDropDownList).size(), 79, "Number of Car Makes available in the Make drop down is not Matching ");
    }

    @DataProvider(name = "provideCarMakeAndSearchResult")
    public Object[][] carMakeSearchData() {
        Object[][] data = new Object[4][2];
        data[0][0] = "Alfa Romeo";
        data[0][1] = "Showing 131 results";
        data[1][0] = "Aston Martin";
        data[1][1] = "Showing 65 results";
        data[2][0] = "Audi";
        data[2][1] = "Showing 2,139 results";
        data[3][0] = "Austin";
        data[3][1] = "Showing 32 results";
        return data;
    }

    @Test(dataProvider = "provideCarMakeAndSearchResult")
    public void verifyCarSearchResults(String carMake, String result) {
        carSearchTab = new CarsTab(driver);
        carSearchTab.selectDropDownItem(carSearchTab.carMakeDropDownList, carMake);
        carSearchTab.clickSearchButton();
        //Verify the car search  results
        Assert.assertEquals(carSearchTab.getSearchResultCount(), result, "CarSearchByMake results does not match ");
    }
}