package userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class UserDataPage {
    public static final Target USERNAME_FIELD = Target.the("Username field").locatedBy("//input[@id='first-name']");
    public static final Target LASTNAME_FIELD = Target.the("Lastname field").locatedBy("//input[@id='last-name']");
    public static final Target ZIPCODE_FIELD = Target.the("Zipcode field").locatedBy("//input[@id='postal-code']");
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button").locatedBy("//input[@value='CONTINUE']");
}
