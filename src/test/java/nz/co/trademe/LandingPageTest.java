package nz.co.trademe;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import nz.co.trademe.base.BaseTest;
import nz.co.trademe.pages.LandingPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LandingPageTest extends BaseTest {
    @Epic("Landing Page Menu Tabs")
    @Story("Verification of Landing Page Menu Tabs")
    @Description("This test verifies the count and the names of main menu tabs present in the landing page. ")
    @Test
    public void verifyLandingPageMenuTabs() {
        landingPage = new LandingPage(driver);
        List<WebElement> tabs = landingPage.getAllSearchMenuTabs();
        //Verify the number of Menu Tabs
        Assert.assertEquals(tabs.size(), 6, "Menu Tabs not matching");
        List<String> expectedMenuTabs = Arrays.asList("Marketplace", "Jobs", "Motors", "Property", "Services", "");
        List<String> actualMenuTabs = new ArrayList<String>();
        for (WebElement tab : tabs) {
            actualMenuTabs.add(tab.getText());
        }
        Assert.assertEquals(actualMenuTabs, expectedMenuTabs, "Actual Menu Tabs does not match with the Expected Menu Tabs");
    }
}

