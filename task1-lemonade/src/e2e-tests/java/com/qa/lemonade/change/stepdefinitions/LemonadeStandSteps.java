import TheQuantityProvidedOfLemonades;
import TheReceivedChanged;
import TheApiResponse;
import RequestsForLemonades;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LemonadeStandSteps {

    @Then("^(?:s)?he is authenticated properly on the identity service with the proper profile$")
    public void heIsAuthenticatedProperlyOnTheIdentityServiceWithTheProperProfile() {
        theActorInTheSpotlight().should(
                seeThat(TheApiResponse.statusCode(), is(equalTo(200))));
    }

    @Given("^that (.*) has (?:his|her) lemonade stand properly set up with everything that (?:s)?he needs to work on$")
    public void thatToniHasHisLemonadeStandProperlySetUpWithEverythingThatHeNeedsToWorkOn(String actor) {
        theActorCalled(actor).describedAs("the lemonade stand owner");
    }

    @When("^the customer asks for the quantity of (.*) lemonade\\(s\\) but pays using an allowed bill of (.*)$")
    public void theCustomerAsksForTheQuantityOfQuantityOfLemonadesLemonadeSButPaysUsingAnAllowedBillOfProvidedBill(String quantityOfLemonades, String providedBill) {
        theActorInTheSpotlight().attemptsTo(
                RequestsForLemonades.inTheQuantityOf(quantityOfLemonades).byProvidingTheBills(providedBill)
        );
    }

    @Then("^(.*) should provide to the customer the quantity of (.*) lemonade\\(s\\)$")
    public void actorShouldProvideToTheCustomerTheQuantityOfQuantityOfLemonadesLemonadeS(String actor, String quantityOfLemonades) {
        theActorInTheSpotlight().should(
                seeThat(
                        TheQuantityProvidedOfLemonades.requested(quantityOfLemonades), is(equalTo(2))
                )
        );
    }

    @And("^the customer must receive a value of (.*) change(?: because there were no validation for fake bills due to in this busy workday it's possible to receive it from consumers)?$")
    public void theCustomerMustReceiveAChangeOfChangeToProvide(String changeToProvide) {
        String quantityRequestedOfLemonades = theActorInTheSpotlight().recall("quantityRequestedOfLemonades");
        String billValueUsedToPayByCustomer = theActorInTheSpotlight().recall("billValueUsedToPayByCustomer");

        theActorInTheSpotlight().should(
                seeThat(
                        TheReceivedChanged.fromRequestLemonadesOf(quantityRequestedOfLemonades)
                                .payedWithBillQuantityOf(billValueUsedToPayByCustomer),
                        is(equalTo(changeToProvide))
                )
        );
    }
}
