package co.com.ceiba.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/create_repository.feature",
        glue = {"co.com.ceiba.stepdefinitions"},
        snippets = SnippetType.CAMELCASE
)
public class CreateRepositoryGitLabRunner {

}

