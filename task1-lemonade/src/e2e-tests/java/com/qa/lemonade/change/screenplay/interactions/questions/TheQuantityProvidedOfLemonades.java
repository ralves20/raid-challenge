import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("the quantity provided from the quantity requested of #quantityOfLemonades lemonades")
public class TheQuantityProvidedOfLemonades implements Question<String> {

    String quantityOfLemonades;

    public TheQuantityProvidedOfLemonades(String quantityOfLemonades) {
        this.quantityOfLemonades = quantityOfLemonades;
    }

    public static TheQuantityProvidedOfLemonades requested(String quantityOfLemonades) {
        return new TheQuantityProvidedOfLemonades(quantityOfLemonades);
    }

    @Override
    public String answeredBy(Actor actor) {

        return quantityOfLemonades;
    }
}
