package stepdefs;

import io.cucumber.java8.En;
import org.junit.jupiter.api.Assertions;


public class FridaySteps implements En {

    String today;

    String actualAnswer;

    public FridaySteps() {
        Given("today is {string}", (String givenDay) -> today = givenDay);

        When("I ask whether it's Friday yet", () -> {
            actualAnswer = "Friday".equals(today) ? "TGIF" : "Nope";
        });

        Then("I should be told {string}", (String expectedAnswer) -> {
            Assertions.assertEquals(expectedAnswer, actualAnswer);
        });
    }
}
