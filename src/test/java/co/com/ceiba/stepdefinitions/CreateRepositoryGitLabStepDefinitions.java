package co.com.ceiba.stepdefinitions;

import co.com.ceiba.model.builder.ProjectBuilder;
import co.com.ceiba.model.builder.UserBuilder;
import co.com.ceiba.questions.RepositorioCreated;
import co.com.ceiba.tasks.CreateRepositoryTask;
import co.com.ceiba.tasks.LoginTask;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static org.hamcrest.core.Is.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateRepositoryGitLabStepDefinitions {

    private final String DONALD = "Donald";
    private final String GITLAB_USER = "donaaldtorres@gmail.com";
    private final String PASSWORD = "Armando20109210";
    private final String CHROME_WEBDRIVER_PATH = "C:\\Workspace\\practica-automatizacion-web\\chromedriver.exe";

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^Donald quiere crear un repositorio$")
    public void authenticating() {
        theActorCalled(DONALD)
                .wasAbleTo(
                        LoginTask.authenticating(
                                UserBuilder
                                        .conUsername(GITLAB_USER)
                                        .conPassword(PASSWORD)
                                        .build()
                        )
                );
    }

    @When("^Donald creo el repositorio$")
    public void createRepository() {
        theActorInTheSpotlight().attemptsTo(
                CreateRepositoryTask.creating(
                        ProjectBuilder
                                .name("PROYECTO PRUEBA_5")
                                .description("DESCRIPCION PRUEBA 5")
                                .slug("SLUG_PRUEBA_5")
                                .initializeReadme(true)
                                .build()
                )
        );
    }

    @Then("^Donald debe ver el repositorio creado$")
    public void shouldSeeNewRepository() {
        theActorInTheSpotlight()
                .should(seeThat(
                        RepositorioCreated.repositorioCreated(),
                        is("PROYECTO PRUEBA_5")
                        )
                );
    }

}
