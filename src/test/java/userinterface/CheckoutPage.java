package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage extends PageObject {
    public static final Target FINISH_BUTTON = Target.the("Finish button").locatedBy("//a[@class='btn_action cart_button']");
}
