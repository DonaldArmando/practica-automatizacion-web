package co.com.ceiba.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GitLabCreatedRepository {

    public static final Target PROJECT_NAME_CREATED = Target
            .the("name of project")
            .located(By.xpath("//*[@id=\"content-body\"]/div/div[1]/div[1]/div[1]/div[2]/div[1]/h1"));


}
