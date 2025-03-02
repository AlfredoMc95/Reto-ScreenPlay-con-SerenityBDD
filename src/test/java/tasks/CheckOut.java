package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.CarPage;

public class CheckOut implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Click.on(CarPage.CHECKOUT_BUTTON)
        );
    }

    public static CheckOut on() {
        return Tasks.instrumented(CheckOut.class);
    }
}
