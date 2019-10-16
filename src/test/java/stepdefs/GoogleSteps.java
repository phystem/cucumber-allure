package stepdefs;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java8.En;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import pages.GooglePage;
import pages.GoogleSearchResultsPage;

public class GoogleSteps implements En {

    GooglePage googlePage;

    GoogleSearchResultsPage googleSearchResultsPage;

    public GoogleSteps() {

        Before((scenario) -> {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
            googlePage = new GooglePage();
        });

        Given("I visit google", () -> {
            googlePage.openApp();
        });

        And("I search for {string}", (String searchString) -> {
            googleSearchResultsPage = googlePage.search(searchString);
        });

        Then("I should see search results", () -> {
            String expTitle = googleSearchResultsPage.getSearchString() + " - Google Search";
            Assertions.assertEquals(expTitle, googleSearchResultsPage.getTitle(), "Search Title should match");
            Allure.addAttachment("Result Count", googleSearchResultsPage.getResultCount());
        });

    }
}
