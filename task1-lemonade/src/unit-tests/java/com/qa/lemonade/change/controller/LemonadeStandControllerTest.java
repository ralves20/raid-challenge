import com.qa.lemonade.change.model.LemonadeStandProducts;
import com.qa.lemonade.change.service.LemonadeStandService;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LemonadeStandControllerTest {

    @InjectMocks
    private LemonadeStandController lemonadeStandController;

    @Mock
    private LemonadeStandService lemonadeStandService;

    private LemonadeStandProducts lemonadeStandProducts;

    @Test
    public void testOfLemonadeStandControllerWithValidValueOnProductShouldReturnTheValueCorrectly() {
        lemonadeStandProducts = createAnLemonadeStandProductObjectHelper("10", "1", "2", "5");

        when(lemonadeStandService.getProduct("10")).thenReturn(lemonadeStandProducts);

        final var response = lemonadeStandController.getProduct("10");

        assertThat(response.getStatusCode().value(), is(equalTo(HttpStatus.SC_OK)));
    }


    private LemonadeStandProducts createAnLemonadeStandProductObjectHelper(String id, String lemonades, String position, String billValue) {
        final LemonadeStandProducts lemonadeStandProducts;
        lemonadeStandProducts = new LemonadeStandProducts();
        lemonadeStandProducts.setId(id);
        lemonadeStandProducts.setRequestedLemonades(lemonades);
        lemonadeStandProducts.setPositionInLine(position);
        lemonadeStandProducts.setBillValue(billValue);

        return lemonadeStandProducts;
    }
}
