package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.CarPage;

import static userinterface.CarPage.DELETE_FROM_CART_BUTTON;


public class DeleteProduct  implements Task {
    private final String productName;

    public DeleteProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(DELETE_FROM_CART_BUTTON(productName)));
    }

    public static DeleteProduct forProduct(String productName) {
        return new DeleteProduct(productName);
    }
}
