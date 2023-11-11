import com.qa.lemonade.change.screenplay.interactions.questions.common.TheValueFromPropConfig;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.Map;

public class RequestsForLemonades implements Task {
    private final String quantityOfLemonades;
    private final String providedBill;

    public RequestsForLemonades(String quantityOfLemonades, String providedBill) {
        this.quantityOfLemonades = quantityOfLemonades;
        this.providedBill = providedBill;
    }

    public static RequestsForLemonadesBuilder inTheQuantityOf(String quantityOfLemonades) {
        return new RequestsForLemonadesBuilder(quantityOfLemonades);
    }

    @Override
    @Step("{0} requests for #quantityOfLemonades by providing the value of #providedBill of bills")
    public <T extends Actor> void performAs(T actor) {

        final String lemonadesPostEndpoint = actor
                .asksFor(TheValueFromPropConfig.andGet("endpoints.lemonades.post.request-item"));

        Map<String, String> headerContent = new HashMap<>();
        headerContent.put("Content-Type", "application/json");

        Map<String, String> bodyContent = new HashMap<>();
        bodyContent.put("bill_value", providedBill);
        bodyContent.put("position_in_line", "");
        bodyContent.put("requested_lemonades", quantityOfLemonades);

        actor.remember("quantityRequestedOfLemonades", quantityOfLemonades);
        actor.remember("billValueUsedToPayByCustomer", providedBill);

        actor.attemptsTo(
                Post.to(lemonadesPostEndpoint)
                        .with(requestSpecification -> requestSpecification
                                .headers(headerContent)
                                .body(bodyContent))
        );


    }

    public static class RequestsForLemonadesBuilder {

        private final String quantityOfLemonades;

        public RequestsForLemonadesBuilder(String quantityOfLemonades) {
            this.quantityOfLemonades = quantityOfLemonades;
        }

        public RequestsForLemonades byProvidingTheBills(String providedBills) {
            return Instrumented.instanceOf(RequestsForLemonades.class).withProperties(quantityOfLemonades, providedBills);
        }

    }
}
