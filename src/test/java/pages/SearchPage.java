package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class SearchPage {

    WebDriver driver = Hooks.driver;

    private By searchButton = By.className("search-button");
    private By searchField = By.id("search-input");
    private By resultsCount = By.className("search-results-count");
    private By tabResultsCount = By.xpath(
            "//div[contains(@id,'overlay')]//*[contains(@class,'sports-menu-items-e3__event-count--scrollable-tabs-wrapper')]//div");
    private By historyList = By.cssSelector(".search-history__item__text");
    private By clearHistoryBtn = By.cssSelector(".search-history__clear__button");
    private By searchMessage = By.xpath("//div[@class='search-no-results ng-star-inserted']");
    private By events = By.xpath(
            "//div[contains(@id,'overlay')]//*[contains(@class, 'spb-selectable-inplay')]");
    private By competitions = By.xpath(
            "//div[contains(@id,'overlay')]//*[@class= 'sports-search-competitions__item ng-star-inserted']");
    private By firstEventInSearchResults = By.xpath(
            "//div[contains(@id,'overlay')]//*[contains(@class, 'spb-selectable-inplay')]");
    private By firstEventParticipant = By.xpath(
            "(//div[contains(@id,'overlay')]//span[@data-test-locator='FIRST_EVENT_PARTICIPANT'])[1]");
    private By secondEventParticipant = By.xpath(
            "(//div[contains(@id,'overlay')]//span[@data-test-locator='SECOND_EVENT_PARTICIPANT'])[1]");
    private By eventNameOnThePage = By.xpath(
            "//*[contains(@class, 'breadcrumbs__head breadcrumbs__head--selected')]");
    private By xButton = By.xpath ("//span[contains(@class,'search-input__icon--clear')]");
    private By closeButton = By.xpath("//span[@class='search-input__close-btn ng-star-inserted']");


    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }

    public boolean checkSearchFieldIsNotDisplayed(){
        List<WebElement> elements = driver.findElements(searchField);
        return elements.isEmpty();
    }

    public void enterSearchText(String text){
        WebElement input = driver.findElement(searchField);
        input.sendKeys(text);
    }

    public String getSearchText(){
        return driver.findElement(searchField).getText();
    }

    public void clearSearchField(){
        WebElement input = driver.findElement(searchField);
        input.clear();
    }
    public List<String> getHistoryList() {
        return driver.findElements(historyList)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }
    public void clickClearHistoryBtn(){
        driver.findElement(clearHistoryBtn).click();
    }
    public String getSearchMessage() {
        return driver.findElement(searchMessage).getText();
    }

    public List<String> getEvents(){
        return driver.findElements(events)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getCompetitions(){
        return driver.findElements(competitions)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getEventNameOnThePage(){
        String eventNameOnPage = driver.findElement(eventNameOnThePage).getText();
        System.out.println("Event name on the page is: " + eventNameOnPage);
        return eventNameOnPage;
    }
    public String getFirstEventName(){
        String firstParticipant = driver.findElement(firstEventParticipant).getText();
        String secondParticipant = driver.findElement(secondEventParticipant).getText();
        String eventName = firstParticipant + " v " + secondParticipant;
        System.out.println("Event name is: " + eventName);
        return eventName;
    }

    public void clickFirstEventInSearchResults() {
        driver.findElement(firstEventInSearchResults).click();
    }

    public int getResultsCount() {
        String stringResult = driver.findElement(resultsCount).getText().substring(16,18);
        return parseInt(stringResult);
    }

    public int getTabResultsCount(){
        int countSum = 0;
        List<String> tabResults = driver.findElements(tabResultsCount)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (String e:tabResults){
            countSum = countSum + parseInt(e);
        }
        return countSum;
    }

    public void clickOnXButton(){
        driver.findElement(xButton).click();
    }

    public void clickOnCloseButton(){
        driver.findElement(closeButton).click();
    }

}
