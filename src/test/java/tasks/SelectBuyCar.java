package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.ProductsPage;

public class SelectBuyCar implements Task {

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Click.on(ProductsPage.BUY_CAR_BUTTON)
        );
    }

    public static SelectBuyCar on() {
        return Tasks.instrumented(SelectBuyCar.class);
    }
}
