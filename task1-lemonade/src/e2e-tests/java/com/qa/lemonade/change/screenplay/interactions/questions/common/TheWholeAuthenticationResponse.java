import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Subject("the complete response body of the last executed request")
public class TheWholeAuthenticationResponse implements Question<Map<String, Object>> {

    private Map<String, Object> mapOfStringsFrom(Map<String, Object> map) {
        return map.entrySet()
                .stream()
                .collect(toMap(Map.Entry::getKey,
                        entry -> entry.getValue().toString()));
    }

    public static TheWholeAuthenticationResponse body() {
        return new TheWholeAuthenticationResponse();
    }

    @Override
    public Map<String, Object> answeredBy(Actor actor) {
        return mapOfStringsFrom(SerenityRest.lastResponse().getBody().as(Map.class));
    }
}
