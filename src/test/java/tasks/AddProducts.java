package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.ProductsPage;

import java.util.List;



public class AddProducts implements Task {

    private final List<String> products;

    public AddProducts(List<String> products) {
        this.products = products;
    }

    public static AddProducts toCart(List<String> products) {
        return Tasks.instrumented(AddProducts.class, products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String productName : products) {
            actor.attemptsTo(
                    Click.on(ProductsPage.ADD_TO_CART_BUTTON(productName))
            );
        }
    }
}
