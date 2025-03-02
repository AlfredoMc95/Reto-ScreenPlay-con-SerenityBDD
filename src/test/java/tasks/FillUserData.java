package tasks;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.UserDataPage;

import java.util.List;
import java.util.Map;

public class FillUserData implements Task {

    public FillUserData(DataTable dataTable) {
        List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
        this.name = userData.get(0).get("Nombre");
        this.lastName = userData.get(0).get("Apellido");
        this.zipCode = userData.get(0).get("Código Postal");
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

    public static FillUserData with(DataTable dataTable) {
        return new FillUserData(dataTable);
    }
}
