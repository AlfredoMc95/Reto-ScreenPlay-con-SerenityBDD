package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.UsuarioBloqueadoSteps;
import static constants.Constants.BLOCKED_USERNAME;
import static constants.Constants.PASSWORD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsuarioBloqueado {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioBloqueado.class);

    UsuarioBloqueadoSteps usuarioBloqueadoSteps = new UsuarioBloqueadoSteps();

    @Given("que el usuario se encuentra en la página de ingreso")
    public void userLogin() {
        LOGGER.info("El usuario está en la página de login");
        usuarioBloqueadoSteps.userLogin();
    }

    @When("ingresa con usuario bloqueado")
    public void userFillsCredentials() {
        LOGGER.debug("Usuario intenta loguearse con usuario: {} y contraseña: {}", BLOCKED_USERNAME, PASSWORD);
        usuarioBloqueadoSteps.userFillsCredentials(BLOCKED_USERNAME, PASSWORD);
    }

    @Then("el sistema debe mostrar un mensaje de Usuario bloqueado y no permitir el acceso")
    public void ErrorMessage() {
        LOGGER.error("Usuario bloqueado. No se permite el acceso.");
        usuarioBloqueadoSteps.errorMessage();
    }
}
