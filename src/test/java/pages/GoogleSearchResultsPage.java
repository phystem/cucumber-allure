package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class GoogleSearchResultsPage {

    private final String searchString;

    public GoogleSearchResultsPage(String searchString) {
        this.searchString = searchString;
    }

    public String getTitle() {
        return title();
    }

    public String getResultCount() {
        return $(By.id("resultStats"))
                .should(visible)
                .text().replaceAll("About|results| |,", "");
    }

    public String getSearchString() {
        return searchString;
    }
}
