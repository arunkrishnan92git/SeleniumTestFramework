package nz.co.trademe;
import io.qameta.allure.Step;
import nz.co.trademe.base.BaseTest;
import nz.co.trademe.pages.LandingPage;
import nz.co.trademe.pages.tabs.jobs.JobsTab;
import nz.co.trademe.pages.tabs.motors.MotorsTab;
import org.testng.Assert;
import org.testng.annotations.*;


public class JobSearchTest extends BaseTest {

    public JobsTab jobSearchTab;
    @Step("Select Jobs tab in Landing Page")
    @BeforeMethod
    public void jobsSetUp() {
        landingPage = new LandingPage(driver);
        landingPage.clickSearchMenu("Jobs");
        jobSearchTab = new JobsTab(driver);
    }
        @Test
    public void verifyNumberOfLocationsAvailable(){

        //Verify the number of locations available in the locations drop down
        Assert.assertEquals(jobSearchTab.getAllItemsInDropDownList(jobSearchTab.locations).size(),16,"Number of locations available in the Locations drop down is not Matching ");

    }

    @DataProvider(name = "locationsANDSearchResults")
    public Object [] [] locationsSearchData ()
    {
        Object [] [] data = new Object [2] [2];
        data [0] [0] = "Wellington";    data [0] [1] = "Showing 2,089 results";
        data [1] [0] = "Waikato";       data [1] [1] = "Showing 1,446 results";
        return data;
    }

    @Test(dataProvider = "locationsANDSearchResults")
    public void verifyJobSearchResults(String location,String result){

        jobSearchTab.selectDropDownItem(jobSearchTab.locations,location);
        jobSearchTab.clickSearchButton();
        //Verify the job search  results
        Assert.assertEquals(jobSearchTab.getSearchResultCount(),result,"jobSearchResults does not match ");

    }

}