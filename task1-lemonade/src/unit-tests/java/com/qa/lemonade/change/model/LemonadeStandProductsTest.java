import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
public class LemonadeStandProductsTest {

    @Test
    public void testOfSetIdWithAValidIdAsParamShouldSetTheIdOfTheCurrentLemonadeStandObject() {
        var lemonadeStandProducts = new LemonadeStandProducts();
        var id = "1";

        lemonadeStandProducts.setId(id);

        assertThat(lemonadeStandProducts.getId(), is(equalTo(id)));
    }

    @Test
    public void testOfSetBillValueWithAValidValueAsParamShouldSetTheCorrectValueOnTheCurrentLemonadeObject() {
        var lemonadeStandProducts = new LemonadeStandProducts();
        var billValueOnTest = "10";

        lemonadeStandProducts.setBillValue(billValueOnTest);

        assertThat(lemonadeStandProducts.getBillValue(), is(equalTo(billValueOnTest)));
    }

    @Test
    public void testOfSetRequestedLemonadesWithAValidValueAsParamShouldSetTheCorrectValueOfRequestedLemonades() {
        var lemonadeStandProducts = new LemonadeStandProducts();
        var requestedLemonadesValue = "2";

        lemonadeStandProducts.setRequestedLemonades(requestedLemonadesValue);

        assertThat(lemonadeStandProducts.getRequestedLemonades(), is(equalTo(requestedLemonadesValue)));
    }

    @Test
    public void testOfSetPositionInLineWithAValidValueAsParamShouldSetTheCorrectPositionInLineOnTheLemonadeStand() {
        var lemonadeStandProducts = new LemonadeStandProducts();
        var positionInLineNumber = "5";

        lemonadeStandProducts.setPositionInLine(positionInLineNumber);

        assertThat(lemonadeStandProducts.getPositionInLine(), is(equalTo(positionInLineNumber)));
    }

}
