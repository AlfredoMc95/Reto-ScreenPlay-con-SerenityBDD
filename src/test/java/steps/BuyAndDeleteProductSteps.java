package steps;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import tasks.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static constants.Constants.ACTOR_NORMAL;
import static constants.Constants.URL;
import static hook.OpenBrowser.openUrl;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class BuyAndDeleteProductSteps {
    @Step("Ingresar credenciales:")
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

    @Step("Selecciona carrito de compras")
    public void selectBuycar() {
        OnStage.theActorCalled(ACTOR_NORMAL).attemptsTo(
                SelectBuyCar.on()
        );
    }

    @Step("Elimina producto {0} del carrito")
    public void deleteProduct(String product) {
        theActorInTheSpotlight().attemptsTo(
                DeleteProduct.forProduct(product)
        );
    }

    @Step("Procede al checkout")
    public void checkout() {
        OnStage.theActorCalled(ACTOR_NORMAL).attemptsTo(
                CheckOut.on()
        );
    }

    @Step("Ingresa los datos del usuario:")
    public void userData(String name, String lastname, String zipcode) {
        theActorInTheSpotlight().attemptsTo(
                FillUserData.with(name,lastname,zipcode)
        );
    }

    @Step("Confirma el pedido")
    public void confirmOrder() {
        theActorInTheSpotlight().attemptsTo(
                ConfirmOrder.on()
        );
    }

    @Step("el sistema debe mostrar un mensaje de pedido confirmando")
    public void confirmPurchase() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( questions.ConfirmPurchase.value(), containsString("THANK YOU FOR YOUR ORDER"))
        );
    }
}
