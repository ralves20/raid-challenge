package frontendtest.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import frontendtest.pageobjects.HomeForm;

public class NavigateSteps extends UIInteractionSteps {

    HomeForm homeForm;

    @Step("User opens the DuckDuckGo home page")
    public void opensTheHomePage() {
        homeForm.open();
    }
}
