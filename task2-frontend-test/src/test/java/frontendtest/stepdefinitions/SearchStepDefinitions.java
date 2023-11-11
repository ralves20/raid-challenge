package frontendtest.stepdefinitions;

import frontendtest.actions.ArticleSteps;
import frontendtest.actions.NavigateSteps;
import frontendtest.actions.SignUpSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinitions {

    @Steps
    NavigateSteps navigate;


    @Steps
    SignUpSteps signUp;

    @Steps
    ArticleSteps article;

    @Given("^(?:.*) is researching things on the internet")
    public void researchingThings() {
        navigate.opensTheHomePage();
    }

    @Given("^(?:.*) is on the Vuex Website")
    public void bernardoIsOnTheVuexWebsite() {
        navigate.opensTheHomePage();
    }

    @When("he tries to sign up filling all the information properly")
    public void heTriesToSignUpFillingAllTheInformationProperly() {
        String user = signUp.generatesRandomString();
        String email = user+"@testemailautomation.com";
        String pass = user+"@123";
        signUp.signsUp(user, email, pass);
    }

    @Then("he should be able to successfully create an user on the application")
    public void heShouldBeAbleToSuccessfullyCreateAnUserOnTheApplication() {
        assertThat(signUp.getSearchResults().size() > 1);
    }

    @When("he opens the first article on the list")
    public void heOpensTheFirstArticleOnTheList() {
        article.opensAnArticle();
    }

    @Then("he should see that the article is all properly showed")
    public void heShouldSeeThatTheArticleIsAllProperlyShowed() {
        assertThat(signUp.getSearchResults()).anyMatch(title -> !title.equalsIgnoreCase(""));
    }
}
