package nz.co.trademe.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {

    public static void waitForPageToBeLoaded(WebDriver driver){
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

    }
    public static void waitForElementToBeClickable(WebDriver driver,WebElement element){
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(element));

    }
    public static void waitForElementToBeVisible(WebDriver driver,WebElement element){
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));

    }

}