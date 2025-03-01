package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static constants.Constants.ACTOR;
import static constants.Constants.URL;
import static hook.OpenBrowser.openUrl;
import static org.hamcrest.Matchers.containsString;

public class UsuarioBloqueado {

    @Given("que el usuario se encuentra en la página de ingreso de Swag Labs")
    public void userLogin() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                openUrl(URL)
        );
    }

    @When("ingresa con {string} y {string} a la pagina")
    public void userFillsCredentials(String user, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                tasks.Login.failedLogin(user, password)
        );
    }

    @Then("el sistema debe mostrar un mensaje de Usuario bloqueado y no permitir el acceso")
    public void ErrorMessage() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( questions.LoginError.value(), containsString("Sorry, this user has been locked out."))
        );
    }



}
