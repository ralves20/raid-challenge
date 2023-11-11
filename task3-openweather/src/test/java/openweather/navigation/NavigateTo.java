package test.java.starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theGooglePage() {
        return Task.where("{0} opens the Google home page",
                Open.browserOn().the(test.java.starter.navigation.GooglePage.class));
    }
}
