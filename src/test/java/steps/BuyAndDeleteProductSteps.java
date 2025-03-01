package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.AddProducts;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static constants.Constants.ACTOR_NORMAL;
import static constants.Constants.URL;
import static hook.OpenBrowser.openUrl;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuyAndDeleteProductSteps {
    @Step("Ingresar credenciales: {0} / {1}")
    public void userLogin(String user, String password) {
        OnStage.theActorCalled(ACTOR_NORMAL).attemptsTo(
                openUrl(URL),
                tasks.Login.LoginUser(user, password)
        );
    }

    @Step("Ordena productos: {0}")
    public void orderBy( String orderType) {
        OnStage.theActorCalled(ACTOR_NORMAL).attemptsTo(
                tasks.OrderProducts.byCriteria(orderType)
        );
    }

    @Step("Agrega productos al carrito")
    public void addProducts(List<Map<String, String>> productsTable) {
        List<String> productNames = productsTable.stream()
                .map(row -> row.get("Producto").trim())
                .collect(Collectors.toList());

        theActorInTheSpotlight().attemptsTo(
                AddProducts.toCart(productNames)
        );
    }
}
