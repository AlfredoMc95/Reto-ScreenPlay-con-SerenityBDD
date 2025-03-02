package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.BuyAndDeleteProductSteps;

import java.util.List;
import java.util.Map;

public class BuyAndDeleteProduct {
    private static final Logger LOGGER = LoggerFactory.getLogger(BuyAndDeleteProduct.class);

    BuyAndDeleteProductSteps buyAndDeleteProductSteps = new BuyAndDeleteProductSteps();

    @Given("Given que el usuario inicia sesión en Swag Labs con {string} y {string}")
    public void userLogin(String user, String password) {
        LOGGER.debug("Usuario intenta loguearse con usuario: {} y contraseña: {}", user, password);
        buyAndDeleteProductSteps.userLogin(user, password);
    }

    @When("ordena los productos por {string}")
    public void orderBy(String orderType) {
        LOGGER.debug("Usuario intenta ordenar los productos por {}", orderType);
        buyAndDeleteProductSteps.orderBy(orderType);
    }

    @And("agrega los siguientes productos al carrito:")
    public void agregaLosSiguientesProductosAlCarrito(List<Map<String, String>> productsTable) {
        LOGGER.debug("Usuario agrega los productos al carrito");
        buyAndDeleteProductSteps.addProducts(productsTable);
    }

    @And("revisa el carrito de compras")
    public void revisaElCarritoDeCompras() {
        LOGGER.debug("Usuario verifica productos seleccionados en el carrito");
        buyAndDeleteProductSteps.selectBuycar();
    }

    @And("elimina {string} del carrito")
    public void eliminaDelCarrito(String product) {
        LOGGER.debug("Elimina producto {} del carrito", product);
        buyAndDeleteProductSteps.deleteProduct(product);
    }
}
