package openweather.search;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class TheOpenWeatherTemperatureStatus implements Question<Integer> {

    String city;
    public TheOpenWeatherTemperatureStatus(String city){
        this.city = city;
    }
    @Override
    public Integer answeredBy(Actor actor) {

        String apiKey = "be95e7db400d35111223d61d62e699d8";
        String theRestApiBaseUrl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey+"&units=metric";
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource(theRestApiBaseUrl)
        );
        Integer openWeatherTemp = SerenityRest.lastResponse().statusCode();

        return openWeatherTemp;
    }

    public static TheOpenWeatherTemperatureStatus forCityOf(String city){
        return new TheOpenWeatherTemperatureStatus(city);
    }
}
