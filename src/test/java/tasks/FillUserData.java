package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.UserDataPage;


public class FillUserData implements Task {

    public FillUserData(String name, String lastName, String zipCode) {
        this.name = name;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }


    private final String name;
    private final String lastName;
    private final String zipCode;


    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(name).into(UserDataPage.USERNAME_FIELD),
                Enter.theValue(lastName).into(UserDataPage.LASTNAME_FIELD),
                Enter.theValue(zipCode).into(UserDataPage.ZIPCODE_FIELD),
                Click.on(UserDataPage.CHECKOUT_BUTTON)
        );
    }

    public static FillUserData with(String name, String lastName, String zipCode) {
        return new FillUserData(name,lastName,zipCode);
    }
}
