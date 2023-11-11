import com.qa.lemonade.change.model.LemonadeStandProducts;
import com.qa.lemonade.change.repository.LemonadeStandProductsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class LemonadeStandServiceTests {

    public LemonadeStandService lemonadeStandService = new LemonadeStandService();


    @Mock
    private LemonadeStandProductsRepository lemonadeStandProductsRepositoryMock;

    LemonadeStandProducts lemonadeStandProducts;


    @Test
    public void testOfSaveProductWithAllProperValuesShouldSetTheIdOfTheItemCorrectly() {
        lemonadeStandProducts = createAnLemonadeStandProductObjectHelper("01", "1", "2", "5");

        lemonadeStandService.saveProduct(lemonadeStandProducts);

        assertThat(lemonadeStandProducts.getId(), is(equalTo("01")));
    }

    @Test
    public void testOfSaveProductWithAllProperValuesShouldSetThePositionInLineCorrectly() {
        lemonadeStandProducts = createAnLemonadeStandProductObjectHelper("01", "1", "2", "5");

        lemonadeStandService.saveProduct(lemonadeStandProducts);

        assertThat(lemonadeStandProducts.getPositionInLine(), is(equalTo("2")));
    }

    @Test
    public void testOfSaveProductWithAllProperValuesShouldSetTheBillValueCorrectly() {
        lemonadeStandProducts = createAnLemonadeStandProductObjectHelper("01", "1", "2", "5");

        lemonadeStandService.saveProduct(lemonadeStandProducts);

        assertThat(lemonadeStandProducts.getBillValue(), is(equalTo("5")));
    }

    @Test
    public void testOfSaveProductWithAllProperValuesShouldSetTheCorrectQuantityOfRequestedLemonades() {
        lemonadeStandProducts = createAnLemonadeStandProductObjectHelper("01", "1", "2", "5");

        lemonadeStandService.saveProduct(lemonadeStandProducts);

        assertThat(lemonadeStandProducts.getRequestedLemonades(), is(equalTo("1")));
    }

    @Test
    public void testOfDeleteProductServiceWithAValidValueShouldDeleteTheItemCorrectly() {
        lemonadeStandProducts = createAnLemonadeStandProductObjectHelper("10", "1", "2", "5");
        lemonadeStandService = new LemonadeStandService();
        lemonadeStandService.setProductRepository(lemonadeStandProductsRepositoryMock);

        lemonadeStandService.deleteProduct("10");

        assertThat(lemonadeStandService.getProduct("10"), is(equalTo(Optional.empty())));
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
