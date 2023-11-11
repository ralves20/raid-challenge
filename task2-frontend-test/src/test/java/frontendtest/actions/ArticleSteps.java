package frontendtest.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import frontendtest.pageobjects.HomeForm;

public class ArticleSteps extends UIInteractionSteps {

    @Step("Opens the first article")
    public void opensAnArticle() {
        find(HomeForm.FIRST_ARTICLE_HEADINGS).click();
    }

}
