package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ConfirmPurchasePage extends PageObject {
    public static final Target CONFIRM_MESSAGE = Target.the("Confirm MESSAGE").locatedBy("//h2[@class='complete-header']");
}
