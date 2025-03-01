package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.actors.OnStage;

import static constants.Constants.ACTOR_NORMAL;
import static constants.Constants.URL;
import static hook.OpenBrowser.openUrl;

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
}
