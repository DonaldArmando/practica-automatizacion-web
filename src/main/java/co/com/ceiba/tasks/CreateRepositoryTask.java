package co.com.ceiba.tasks;

import co.com.ceiba.exceptions.LoadedPageExeptions;
import co.com.ceiba.model.Project;
import co.com.ceiba.model.enums.Visibility;
import co.com.ceiba.userinterface.GitLabCreateNewRepository;
import co.com.ceiba.userinterface.GitLabHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CreateRepositoryTask implements Task {

    private static final String CREATE_REPOSITORY_NOT_LOADED_CORRECTLY = "La pagina de creacion de repositorio no cargo correctamente";

    private Project project;
    private GitLabCreateNewRepository gitLabCreateNewRepository;

    public CreateRepositoryTask(Project project) {
        this.project = project;
    }

    @Override
    @Step("{0} performs create repository")
    public <T extends Actor> void performAs(T theActor) {

        theActor.attemptsTo(
                Click.on(GitLabHomePage.NEW_PROJECT)
        );

        theActor.should(
                seeThat(the(GitLabCreateNewRepository.BLANK_PROJECT), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, CREATE_REPOSITORY_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabCreateNewRepository.CREATE_FROM_TEMPLATE), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, CREATE_REPOSITORY_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabCreateNewRepository.CREATE_PROJECT), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, CREATE_REPOSITORY_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabCreateNewRepository.INITIALIZE_README), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, CREATE_REPOSITORY_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabCreateNewRepository.PROJECT_DESCRIPTION), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, CREATE_REPOSITORY_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabCreateNewRepository.PROJECT_NAME), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, CREATE_REPOSITORY_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabCreateNewRepository.PROJECT_SLUG), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, CREATE_REPOSITORY_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabCreateNewRepository.PROJECT_VISIBILITY_LEVEL_INTERNAL), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, CREATE_REPOSITORY_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabCreateNewRepository.PROJECT_VISIBILITY_LEVEL_PRIVATE), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, CREATE_REPOSITORY_NOT_LOADED_CORRECTLY),
                seeThat(the(GitLabCreateNewRepository.PROJECT_VISIBILITY_LEVEL_PUBLIC), isVisible())
                        .orComplainWith(LoadedPageExeptions.class, CREATE_REPOSITORY_NOT_LOADED_CORRECTLY)
        );

        theActor.attemptsTo(
                Enter.theValue(project.getName()).into(GitLabCreateNewRepository.PROJECT_NAME),
                Enter.theValue(project.getSlug()).into(GitLabCreateNewRepository.PROJECT_SLUG),
                Enter.theValue(project.getDescription()).into(GitLabCreateNewRepository.PROJECT_DESCRIPTION),
                Click.on(projectVsisibility(project.getVisibility())),
                Check.whether(project.getInitializeReadme() == Boolean.TRUE)
                        .andIfSo(Click.on(GitLabCreateNewRepository.INITIALIZE_README)),
                Click.on(GitLabCreateNewRepository.CREATE_PROJECT)
        );


    }


    private Target projectVsisibility(Visibility visibility) {

        Target target = null;

        if (visibility.equals(Visibility.INTERNAL)) {
            target = GitLabCreateNewRepository.PROJECT_VISIBILITY_LEVEL_INTERNAL;
        }
        if (visibility.equals(Visibility.PRIVATE)) {
            target = GitLabCreateNewRepository.PROJECT_VISIBILITY_LEVEL_PRIVATE;
        }
        if (visibility.equals(Visibility.PUBLIC)) {
            target = GitLabCreateNewRepository.PROJECT_VISIBILITY_LEVEL_PUBLIC;
        }

        return target;
    }

    public static CreateRepositoryTask creating(Project project) {
        return instrumented(CreateRepositoryTask.class, project);
    }

}
