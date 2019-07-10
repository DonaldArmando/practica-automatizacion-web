package co.com.ceiba.tasks;

import co.com.ceiba.userinterface.GitLabHomePage;
import co.com.ceiba.exceptions.LoadedPageExeptions;
import co.com.ceiba.model.User;
import co.com.ceiba.userinterface.GitLabLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class LoginTask implements Task {

    private static final String LOGIN_PAGE_NOT_LOADED_CORRECTLY = "La pagina de login no cargo correctamente";
    private static final String HOME_PAGE_NOT_LOADED_CORRECTLY = "La pagina home no cargo correctamente";

    private final User user;
    private GitLabLoginPage gitLabLoginPage;


    public LoginTask(User user) {
        this.user = user;
    }

    @Override
    @Step("{0} performs an autentication")
    public <T extends Actor> void performAs(T theActor) {

        theActor.attemptsTo(
                Open.browserOn(gitLabLoginPage)
        );

        theActor.should(
                seeThat(the(GitLabLoginPage.USERNAME_OR_EMAIL_ADDRESS), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, LOGIN_PAGE_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabLoginPage.PASSWORD), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, LOGIN_PAGE_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabLoginPage.SIGN_IN), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, LOGIN_PAGE_NOT_LOADED_CORRECTLY)
        );

        theActor.attemptsTo(
                Enter.theValue(user.getUsername()).into(GitLabLoginPage.USERNAME_OR_EMAIL_ADDRESS),
                Enter.theValue(user.getPassword()).into(GitLabLoginPage.PASSWORD),
                Click.on(GitLabLoginPage.SIGN_IN)
        );

        theActor.should(
                seeThat(the(GitLabHomePage.NEW_PROJECT), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, HOME_PAGE_NOT_LOADED_CORRECTLY)
        );

    }

    public static LoginTask authenticating(User user) {
        return instrumented(LoginTask.class, user);
    }


}
