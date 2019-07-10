package co.com.ceiba.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("https://gitlab.com/projects/new")
public class GitLabCreateNewRepository extends PageObject {


    public static final Target PROJECT_NAME = Target
            .the("Project name field")
            .located(By.id("project_name"));

    public static final Target PROJECT_SLUG = Target
            .the("project slug field")
            .located(By.id("project_path"));

    public static final Target PROJECT_DESCRIPTION = Target
            .the("project description field")
            .located(By.id("project_description"));

    public static final Target PROJECT_VISIBILITY_LEVEL_PRIVATE = Target
            .the("project visibility private level radio button")
            .located(By.id("project_visibility_level_0"));

    public static final Target PROJECT_VISIBILITY_LEVEL_INTERNAL = Target
            .the("project visibility internal level radio button")
            .located(By.id("project_visibility_level_10"));

    public static final Target PROJECT_VISIBILITY_LEVEL_PUBLIC = Target
            .the("project visibility public level radio button")
            .located(By.id("project_visibility_level_20"));

    public static final Target INITIALIZE_README = Target
            .the("project initialize readme check")
            .located(By.id("project_initialize_with_readme"));

    public static final Target CREATE_FROM_TEMPLATE = Target
            .the("project create from template tab")
            .located(By.id("create-from-template-tab"));

    public static final Target TEMPLATE_SPRING = Target
            .the("project template spring button")
            .located(By.xpath("//*[@id=\"built-in\"]/div[2]/div[3]/label"));

    public static final Target BLANK_PROJECT = Target
            .the("project blank project tab")
            .located(By.id("create-from-template-tab"));

    public static final Target CREATE_PROJECT = Target
            .the("create project button")
            .located(By.name("commit"));


}
