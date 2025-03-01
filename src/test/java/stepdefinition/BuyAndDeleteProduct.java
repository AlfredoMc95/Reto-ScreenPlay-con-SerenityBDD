package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.BuyAndDeleteProductSteps;

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
}
