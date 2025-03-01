package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import static constants.Constants.ACTOR_BLOCKED;
import static constants.Constants.URL;
import static hook.OpenBrowser.openUrl;

import static org.hamcrest.Matchers.containsString;

public class UsuarioBloqueadoSteps {

    @Step("Abrir la página de Swag Labs")
    public void userLogin() {
        OnStage.theActorCalled(ACTOR_BLOCKED).attemptsTo(
                openUrl(URL)
        );
    }

    @Step("Ingresar credenciales: {0} / {1}")
    public void userFillsCredentials(String user, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                tasks.Login.LoginUser(user, password)
        );
    }

    @Step("Verificar mensaje de usuario bloqueado")
    public void errorMessage() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat( questions.LoginError.value(), containsString("Sorry, this user has been locked out."))
        );
    }
}
