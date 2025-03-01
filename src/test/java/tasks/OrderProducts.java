package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import userinterface.ProductsPage;

public class OrderProducts implements Task {

    private final String orderCriteria;

    public OrderProducts(String orderCriteria) {
        this.orderCriteria = orderCriteria;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                SelectFromOptions.byValue(orderCriteria).from(ProductsPage.PRODUCTS_ORDER)
        );
    }

    public static OrderProducts byCriteria(String orderCriteria) {
        return Tasks.instrumented(OrderProducts.class, orderCriteria);
    }
}
