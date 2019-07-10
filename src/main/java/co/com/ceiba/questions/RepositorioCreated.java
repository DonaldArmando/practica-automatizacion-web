package co.com.ceiba.questions;

import co.com.ceiba.userinterface.GitLabCreatedRepository;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RepositorioCreated implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return GitLabCreatedRepository.PROJECT_NAME_CREATED.resolveFor(actor).getText();
    }

    public static RepositorioCreated repositorioCreated() {
        return new RepositorioCreated();
    }



}
