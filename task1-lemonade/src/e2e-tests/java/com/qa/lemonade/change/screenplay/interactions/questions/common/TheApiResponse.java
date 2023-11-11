import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class TheApiResponse {

    public static Question<Integer> statusCode() {
        return Question.about("the status code of the last executed request")
                .answeredBy(actor -> SerenityRest.lastResponse().statusCode());
    }

    public static TheWholeAuthenticationResponse body() {
        return new TheWholeAuthenticationResponse();
    }

    public static Question<String> fieldName(String field) {
        return Question.about("the field #field on the response of the last executed request")
                .answeredBy(actor -> SerenityRest.lastResponse().jsonPath().get(field));
    }

}
