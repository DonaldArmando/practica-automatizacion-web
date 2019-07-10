package co.com.ceiba.userinterface;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("https://gitlab.com/")
public class GitLabHomePage extends PageObject{


    public static final Target NEW_PROJECT = Target
            .the("new project button")
            .located(By.xpath("//*[@id=\"content-body\"]/div/div[1]/div/a"));


}
