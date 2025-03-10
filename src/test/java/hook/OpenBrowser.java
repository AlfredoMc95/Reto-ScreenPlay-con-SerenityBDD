package hook;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenBrowser implements Task {

    private String url;

    public OpenBrowser(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(Open.url(url));
    }

    public static OpenBrowser openUrl(String url) {
        return Tasks.instrumented(OpenBrowser.class, url);
    }
}
