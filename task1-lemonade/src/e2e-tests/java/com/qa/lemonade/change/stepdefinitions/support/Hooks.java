import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Hooks {

    @Before(order = 0)
    public void beforeAllScenarios() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        String theRestApiBaseUrl = environmentVariables.getProperty("environments.default.base.url");
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(
                CallAnApi.at(theRestApiBaseUrl)));
    }

}
