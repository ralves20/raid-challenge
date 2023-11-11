package test.java.starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.waits.Wait;
import org.junit.Assert;
import openweather.search.TheOpenWeatherTemperatureStatus;
import test.java.starter.search.TheTemperatureOnGoogle;
import test.java.starter.search.TheOpenWeatherTemperature;

import java.time.Duration;

public class SearchStepDefinitions {

    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) {
        String city = "any";
        String apiKey = "be95e7db400d35111223d61d62e699d8";
        String theRestApiBaseUrl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey+"&units=metric";
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @And("{actor} searches for {string}")
    public void heSearchesFor(Actor actor, String term) {
        actor.attemptsTo(
                Wait.until(
                        WebElementQuestion.the(test.java.starter.search.SearchForm.SEARCH_FIELD) , WebElementStateMatchers.isPresent()).forNoMoreThan(Duration.ofSeconds(30)),
                test.java.starter.search.LookForInformation.about(term)
        );
    }

    @When("{actor} verifies the temperature in the location that he searched")
    public void heVerifiesTheTemperatureInTheLocationThatHeSearched(Actor actor) {
        String temperatureOnGoogle = actor.asksFor(
                TheTemperatureOnGoogle.forCurrentLocation()
        );
        actor.remember("googleTemperature", temperatureOnGoogle);
    }

    @Then("{actor} should see that the temperature is the same as the existant in the OpenWeatherMap for {string}")
    public void heShouldSeeThatTheTemperatureIsTheSameAsTheExistantInTheOpenWeatherMapFor(Actor actor, String city) {
        String googleTemperature = actor.recall("googleTemperature");
        String theOpenWeatherTemperatureForCity = actor.asksFor(TheOpenWeatherTemperature.forCityOf(city));
        System.out.println(theOpenWeatherTemperatureForCity);

        Assert.assertTrue("The temperature for google is: "+googleTemperature+" and the temperature from OpenWeatherAPI is: "+theOpenWeatherTemperatureForCity+""
                ,theOpenWeatherTemperatureForCity.contains(googleTemperature));

    }

    @When("{actor} performs a wrong request for the openweather to get the temperature")
    public void hePerformsAWrongRequestForTheOpenweatherToGetTheTemperature(Actor actor) {

        String invalidCity = "@#@#)(*@#)@(*@)#(*@#)(";

        Integer theOpenWeatherTemperatureStatus = actor.asksFor(TheOpenWeatherTemperatureStatus.forCityOf(invalidCity));
        actor.remember("lastTemperatureStatusCode", theOpenWeatherTemperatureStatus);
        System.out.println(theOpenWeatherTemperatureStatus);

    }

    @Then("{actor} should see that the request returns a bad request {int} error")
    public void heShouldSeeThatTheRequestReturnsAError(Actor actor, Integer statusExp) {
        Integer lastTemperatureStatusCode = actor.recall("lastTemperatureStatusCode");
        Assert.assertEquals("Temperature returns a bad request", lastTemperatureStatusCode, statusExp);
    }

    @When("{actor} performs a unauthorized request for the openweather to get the temperature")
    public void hePerformsAUnauthorizedRequestForTheOpenweatherToGetTheTemperature(Actor actor) {

        String city = "any";
        String apiKey = "INVALID-KEY";
        String theRestApiBaseUrl = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey+"&units=metric";
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource(theRestApiBaseUrl)
        );
        Integer openWeatherTemp = SerenityRest.lastResponse().statusCode();
        actor.remember("lastTemperatureStatusCode", openWeatherTemp);

    }

    @Then("{actor} should see that the request returns a unauthorized {int} error")
    public void heShouldSeeThatTheRequestReturnsAUnauthorizedError(Actor actor, Integer statusExp) {
        Integer lastTemperatureStatusCode = actor.recall("lastTemperatureStatusCode");
        Assert.assertEquals("Temperature returns a bad request", lastTemperatureStatusCode, statusExp);
    }


    @When("{actor} performs a not found request for the openweather to get the temperature")
    public void hePerformsANotFoundRequestForTheOpenweatherToGetTheTemperature(Actor actor) {

        String notFoundCity = "NOTFOUNDCITY";

        Integer theOpenWeatherTemperatureStatus = actor.asksFor(TheOpenWeatherTemperatureStatus.forCityOf(notFoundCity));
        actor.remember("lastTemperatureStatusCode", theOpenWeatherTemperatureStatus);
    }

    @Then("{actor} should see that the request returns a not found {int} error")
    public void heShouldSeeThatTheRequestReturnsANotFoundError(Actor actor, Integer statusExp) {
        Integer lastTemperatureStatusCode = actor.recall("lastTemperatureStatusCode");
        Assert.assertEquals("Temperature returns a bad request", lastTemperatureStatusCode, statusExp);
    }
}
