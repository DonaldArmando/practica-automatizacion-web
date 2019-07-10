package co.com.ceiba.userinterface;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://gitlab.com/users/sign_in")
public class GitLabLoginPage extends PageObject {

    public static final Target USERNAME_OR_EMAIL_ADDRESS = Target
            .the("Username or email address field")
            .located(By.id("user_login"));

    public static final Target PASSWORD = Target
            .the("password field")
            .located(By.id("user_password"));

    public static final Target SIGN_IN = Target
            .the("sign in button")
            .located(By.name("commit"));

}
