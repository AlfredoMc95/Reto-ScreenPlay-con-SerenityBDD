package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.CheckoutPage;

public class ConfirmOrder implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }

    public static ConfirmOrder on() {
        return new ConfirmOrder();
    }
}
