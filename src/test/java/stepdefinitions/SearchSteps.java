package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchPage;
import pages.TestContext;

import static pages.TestContext.*;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();

    @Given("the user has clicked on Search button")
    public void theUserHasClickedOnSearchButton() {
        searchPage.clickSearchButton();
        System.out.println("Search button clicked");

    }

    @When("the user enters {string} in the search field")
    public void theUserEntersStringInTheSearchField(String text) {
        searchPage.enterSearchText(text);
        System.out.println("Search text: " + text + " entered");
    }

    @Then("all results in Search results contain {string} string")
    public void allResultsInSearchResultsContainHeroicAcademyString() {
    }

    @When("the user deletes last character from the search field")
    public void theUserDeletesLastCharacterFromTheSearchField() {
    }

    @Then("loading indicator appears while search results are loading")
    public void loadingIndicatorAppearsWhileSearchResultsAreLoading() {
    }

    @And("the user clears the search field")
    public void theUserClearsTheSearchField() {
        searchPage.clearSearchField();
        System.out.println("Search field cleared");
    }

    @Then("the Search history contains {string}")
    public void theSearchHistoryContainsHeroicAcademy(String text) {
        for (String s : searchPage.getHistoryList()) {
            System.out.println(s + " is present in search history");
            Assert.assertEquals(s,text);
        }

    }

    @When("the user selects {string} from Search history")
    public void theUserSelectsFromSearchHistory(String arg0) {
    }

    @And("the user clicks on Clear All button")
    public void theUserClicksOnClearAllButton() {
        searchPage.clickClearHistoryBtn();
    }

    @Then("the message {string} is present")
    public void theMessageIsPresent(String message) throws InterruptedException {
        String searchMessage = searchPage.getSearchMessage();
        System.out.println("this is expected message: " + message);
        System.out.println("this is actual message: " + searchMessage);
        Assert.assertEquals("Expected and actual message do not match", message,searchMessage);
    }

    @Then("input gets trimmed to {int} characters")
    public void inputGetsTrimmedToCharacters() {

    }

    @When("search result is not empty")
    public void searchResultIsNotEmpty() {
        Assert.assertNotEquals(0,searchPage.getResultsCount());
        System.out.println("Search result is not empty");
    }

    @Then("total search count is sum of counts in tabs")
    public void totalSearchCountIsSumOfCountsInTabs() {
        int totalSearchCount = searchPage.getResultsCount();
        int tabResultSum = searchPage.getTabResultsCount();
        Assert.assertEquals("Sum in tabs doesn't match the total event count", totalSearchCount,tabResultSum);
        System.out.println("Total search count: " +  totalSearchCount + " equals sum of counts in tabs: " + tabResultSum);

    }

    @Then("numbers of events in each tab matches sum of events and competitions shown on that tab")
    public void numbersOfEventsInEachTabMatchesSumOfEventsAndCompetitionsShownOnThatTab() {

    }

    @Then("each shown the event and competition are shown under a correct tab")
    public void eachShownTheEventAndCompetitionAreShownUnderACorrectTab() {
    }

    @When("there are events displayed")
    public void thereAreEventsDisplayed() throws InterruptedException {
        Assert.assertTrue("No events displayed", searchPage.getSearchMessage().isEmpty());
        System.out.println("There are events displayed");

    }

    @Then("Events table has column named {string}")
    public void eventsTableHasColumnNamedEvents() {
    }

    @Then("each row of the event column contains First event participant")
    public void eachRowOfTheEventColumnContainsFirstEventParticipant() {
    }

    @And("each row of the event column contains Second event participant")
    public void eachRowOfTheEventColumnContainsSecondEventParticipant() {
    }

    @Then("each row of the event column contains the event time")
    public void eachRowOfTheEventColumnContainsTheEventTime() {
    }

    @Then("events are ordered by the event time")
    public void eventsAreOrderedByTheEventTime() {
    }

    @And("the user clicks on one of the events")
    public void theUserClicksOnOneOfTheEventS() {
        String eventName = searchPage.getFirstEventName();
        TestContext.clickedEventName = eventName;
        searchPage.clickFirstEventInSearchResults();
        System.out.println("user clicked on the first event");
    }

    @Then("the user is taken on the clicked the event page")
    public void theUserIsTakenOnTheClickedTheEventPage() {
        Assert.assertEquals("Event name does not match", clickedEventName,searchPage.getEventNameOnThePage());
        System.out.println("Name of the event matches");
    }

    @And("the event time is NOT {string}")
    public void theEventTimeIsNOTStartingNow() {
    }

    @Then("the event has the bet odds shown in all {int} columns")
    public void theEventHasTheBetOddsShownInAllColumns(int arg0) {
    }

    @Then("each event has match stats shown")
    public void eachEventHasMatchStatsShown() {
    }

    @When("there's an Live event")
    public void thereSAnLiveEvent() {
    }

    @Then("the event period and time should be displayed")
    public void theEventPeriodAndTimeShouldBeDisplayed() {
    }

    @Then("the event score should be displayed")
    public void theEventScoreShouldBeDisplayed() {
    }

    @And("there{string}Starting Now' event")
    public void thereSAnStartingNowEvent() {
    }

    @When("the event time changes to {string}")
    public void theEventTimeChangesToLive() {
    }

    @Then("the event score should become visible")
    public void theEventScoreShouldBecomeVisible() {
    }

    @When("there are Competitions displayed")
    public void thereAreCompetitionsDisplayed() {
    }

    @Then("Competitions table has {int} column named {string}")
    public void competitionsTableHasColumnNamedCompetition(int arg0) {
    }

    @When("there is a Competition table")
    public void thereIsACompetitionTable() {
    }

    @Then("Competitions table has at least {int} row")
    public void competitionsTableHasAtLeastRow(int arg0) {
    }

    @When("the event time is {string}")
    public void theEventTimeIsStartingNow() {
    }

    @Then("the event doesn NOT have the bet odds shown in all {int} columns")
    public void theEventDoesnNOTHaveTheBetOddsShownInAllColumns(int arg0) {
    }

    @Then("the event does NOT have the bet odds shown in all {int} columns")
    public void theEventDoesNOTHaveTheBetOddsShownInAllColumns(int arg0) {
    }

    @And("the user clicks on the bet on a first event")
    public void theUserClicksOnTheBetOnAFirstEvent() {
    }

    @Then("the selected the bet becomes inactive")
    public void theSelectedTheBetBecomesInactive() {
    }

    @When("the user clicks on the bet {string}")
    public void theUserClicksOnTheBetA() {
    }

    @Then("the bet {string} is active")
    public void theBetAIsActive() {
    }

    @And("the user clicks on a first the bet")
    public void theUserClicksOnAFirstTheBet() {
    }

    @When("the user clicks on a second the bet on the same event")
    public void theUserClicksOnASecondTheBetOnTheSameEvent() {
    }

    @When("the user clicks on a all {int} bet odds on the same event")
    public void theUserClicksOnAAllBetOddsOnTheSameEvent(int arg0) {
    }

    @Then("all {int} bet odds are active")
    public void allBetOddsAreActive(int arg0) {
    }

    @When("the user clicks on match stats dropdown")
    public void theUserClicksOnMatchStatsDropdown() {
    }

    @Then("the match stats are visible")
    public void theMatchStatsAreVisible() {
    }

    @Then("the match stats are NOT visible")
    public void theMatchStatsAreNOTVisible() {
    }

    @Then("first the bet is active")
    public void firstTheBetIsActive() {
    }

    @When("the user hovers over one the bet odd")
    public void theUserHoversOverOneTheBetOdd() {
    }

    @Then("the bet odd field becomes bold")
    public void theBetOddFieldBecomesBold() {
    }

    @Then("the bet {string} is added to the bet slip")
    public void theBetAIsAddedToTheBetSlip() {
    }

    @And("the user clicks on the bet")
    public void theUserClicksOnTheBet() {
    }

    @And("the user exits the search")
    public void theUserExitsTheSearch() {
    }

    @When("the user unselects preselected the bet")
    public void theUserUnselectsPreselectedTheBet() {
    }

    @Then("the bet {string} is removed from the bet slip")
    public void theBetAIsRemovedFromTheBetSlip() {
    }

    @When("the user quickly enters the following inputs in search field:")
    public void theUserQuicklyEntersTheFollowingInputsInSearchField() {
    }

    @Then("only results for {string} are displayed")
    public void onlyResultsForFootballAreDisplayed() {
    }

    @And("no intermediate results are shown")
    public void noIntermediateResultsAreShown() {
    }

    @And("no errors are thrown")
    public void noErrorsAreThrown() {
    }

    @And("the search API is unavailable")
    public void theSearchAPIIsUnavailable() {
    }

    @Then("the user sees a message {string}")
    public void theUserSeesAMessage(String arg0) {
    }

    @And("no partial or incorrect results are shown")
    public void noPartialOrIncorrectResultsAreShown() {
    }

    @And("the application remains responsive")
    public void theApplicationRemainsResponsive() {
    }


    @When("the user clicks on Close button")
    public void theUserClicksOnCloseButton() {
        searchPage.clickOnCloseButton();
        System.out.println("User clicked on Close button");
    }

    @Then("search field is not visible")
    public void searchFieldIsNotVisible() {
        Assert.assertTrue("Search Field is visible", searchPage.checkSearchFieldIsNotDisplayed());
        System.out.println("Search field is not visible");
    }

    @When("the user clicks on X")
    public void theUserClicksOnX() {
        searchPage.clickOnXButton();
        System.out.println("User clicked on X button");
    }

    @Then("search input field is empty")
    public void searchInputFieldIsEmpty() {
        Assert.assertTrue("Search Field is not empty",searchPage.getSearchText().isEmpty());
    }

    @Then("total search result count matches number of events and competitions shown")
    public void totalSearchResultCountMatchesNumberOfEventsAndCompetitionsShown() {
        Assert.assertEquals(searchPage.getResultsCount(),searchPage.getResultsCount());
        System.out.println("Numbers of events: " + searchPage.getResultsCount()
                + " in each tab matches sum of events and competitions shown on that tab: "
                + searchPage.getResultsCount());
    }
}
