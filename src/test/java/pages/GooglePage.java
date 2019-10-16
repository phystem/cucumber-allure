package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GooglePage {

    public GooglePage openApp() {
        open("https://www.google.com");
        return this;
    }

    public GoogleSearchResultsPage search(String searchString) {
        $("[name=q]")
                .should(visible)
                .val(searchString)
                .pressEnter();
        return new GoogleSearchResultsPage(searchString);
    }

}
