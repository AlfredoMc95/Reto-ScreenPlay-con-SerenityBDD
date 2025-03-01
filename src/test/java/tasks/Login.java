package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.LoginPage;

public class Login implements Task {

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;


    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Clear.field(LoginPage.USERNAME_FIELD),
                Clear.field(LoginPage.PASSWORD_FIELD),
                Enter.keyValues(username).into(LoginPage.USERNAME_FIELD),
                Enter.keyValues(password).into(LoginPage.PASSWORD_FIELD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    public static Login failedLogin(String username, String password) {
        return Tasks.instrumented(Login.class, username, password);
    }
}
