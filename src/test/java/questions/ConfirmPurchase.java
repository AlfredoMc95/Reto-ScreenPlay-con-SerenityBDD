package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterface.ConfirmPurchasePage;

public class ConfirmPurchase implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ConfirmPurchasePage.CONFIRM_MESSAGE).answeredBy(actor);
    }

    public static Question<String> value() {
        return new ConfirmPurchase();
    }
}
