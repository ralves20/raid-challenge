package frontendtest.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://vue-vuex-realworld.netlify.app/#/")
public class HomeForm extends PageObject {
    public static final By ARTICLE_HEADINGS =  By.xpath("//div[contains(@class, 'article')]/descendant::h1");

    public static final By FIRST_ARTICLE_HEADINGS =  By.xpath("(//div[contains(@class, 'article')]/descendant::h1)[1]");


    public static final By FIRST_SIGN_UP_BUTTON = By.xpath("//a[contains(text(), 'Sign up')]");
    public static final By USERNAME_FIELD = By.xpath("//input[@placeholder='Username']");
    public static final By EMAIL_FIELD = By.xpath("//input[@placeholder='Email']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@placeholder='Password']");

    public static final By SIGN_UP_BUTTON = By.xpath("//button[contains(text(), 'Sign up')]");

    public static final By GLOBAL_FEED = By.xpath("//div[@class='home-page']/descendant::a[contains(text(), 'Global')]");
}
