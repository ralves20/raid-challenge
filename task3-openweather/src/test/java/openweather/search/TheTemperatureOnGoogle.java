package test.java.starter.search;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextValue;

import static test.java.starter.search.SearchForm.TEMPERATURE_RESULT;

public class TheTemperatureOnGoogle implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return TextValue.of(TEMPERATURE_RESULT).answeredBy(actor);
    }

    public static TheTemperatureOnGoogle forCurrentLocation(){
        return new TheTemperatureOnGoogle();
    }
}
