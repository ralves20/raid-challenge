package frontendtest.actions;

import frontendtest.pageobjects.HomeForm;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SignUpSteps extends UIInteractionSteps {

    @Step("User signs up using user '{0}' with email '{0}' and password '{0}'")
    public void signsUp(String user, String email, String pass) {
        find(HomeForm.FIRST_SIGN_UP_BUTTON).click();
        withTimeoutOf(Duration.ofSeconds(10))
                .waitFor(presenceOfElementLocated(HomeForm.USERNAME_FIELD));
        find(HomeForm.USERNAME_FIELD).sendKeys(user);
        find(HomeForm.EMAIL_FIELD).sendKeys(email);
        find(HomeForm.PASSWORD_FIELD).sendKeys(pass);
        find(HomeForm.SIGN_UP_BUTTON).click();
        withTimeoutOf(Duration.ofSeconds(10))
                .waitFor(presenceOfElementLocated(HomeForm.GLOBAL_FEED));    }

    @Step("User generates a random String")
    public String generatesRandomString(){
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }


    @Step("Check the search results")
    public List<String> getSearchResults() {
        return findAll(HomeForm.ARTICLE_HEADINGS).texts();
    }
}
