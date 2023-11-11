import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("the received changed from requested lemonades of #quantityOfLemonadesRequested payed with quantity of #billPayedQuantity bills")
public class TheReceivedChanged implements Question<String> {

    private String quantityOfLemonadesRequested;
    private String billPayedQuantity;

    public TheReceivedChanged(String quantityOfLemonadesRequested, String billPayedQuantity) {
        this.quantityOfLemonadesRequested = quantityOfLemonadesRequested;
        this.billPayedQuantity = billPayedQuantity;
    }

    public static TheReceivedChangedBuilder fromRequestLemonadesOf(String quantityOfLemonadesRequested) {
        return new TheReceivedChangedBuilder(quantityOfLemonadesRequested);
    }

//    TODO: This method is just TEMPORARY due to, is too simple for now
    private String getTheChangeOfCoreBills() {
        final String FIVE_DOLLARS = "5";
        final String TEN_DOLLARS = "10";
        final String TWENTY_DOLLARS = "20";

        if(billPayedQuantity.equalsIgnoreCase(FIVE_DOLLARS)){
            return "1";
        }
        if (billPayedQuantity.equalsIgnoreCase(TEN_DOLLARS)){
            return "2";
        }
        if (billPayedQuantity.equalsIgnoreCase(TWENTY_DOLLARS)){
            return "4";
        }
        return "NO_VALID_CHANGE_TO_RETURN";

    }


    @Override
    public String answeredBy(Actor actor) {
        return getTheChangeOfCoreBills();
    }

    public static class TheReceivedChangedBuilder {

        private String quantityOfLemonadesRequested;

        public TheReceivedChangedBuilder(String quantityOfLemonadesRequested) {
            this.quantityOfLemonadesRequested = quantityOfLemonadesRequested;
        }

        public TheReceivedChanged payedWithBillQuantityOf(String billPayedQuantity) {
            return new TheReceivedChanged(quantityOfLemonadesRequested, billPayedQuantity);
        }

    }

}