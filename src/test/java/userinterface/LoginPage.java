package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target USERNAME_FIELD = Target.the("Username field").locatedBy("//input[@id='user-name']");
    public static final Target PASSWORD_FIELD = Target.the("Password field").locatedBy("//input[@id='password']");
    public static final Target LOGIN_BUTTON = Target.the("Login button").locatedBy("//input[@id='login-button']");
    public static final Target ERROR_MESSAGE = Target.the("Error message").locatedBy("//h3[@data-test='error']");
}
