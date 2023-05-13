package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.login.LoginHelpPage;
import pages.login.LoginPage;

import static org.assertj.core.api.Assertions.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PropertiesManager;;

public class LoginSteps {

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);

    LoginPage loginPage = new LoginPage();

    LoginHelpPage loginHelpPage = new LoginHelpPage();

    @When("User logs in with their credentials")
    public void userLogsInWithTheirCredentials() {
        loginPage.enterLoginCredentials(PropertiesManager.getProperty("valid.email"),
                PropertiesManager.getProperty("valid.password"));
    }

    @When("User enters {} and {} to login")
    public void userEntersAndToLogin(String email, String password) {
        loginPage.enterLoginCredentials(email, password);
    }

    @Then("User will be unable to login")
    public void userWillBeUnableToLogin() {
        assertThat(loginPage.getLoginErrorMessage())
                .isEqualTo("We didn't recognize that email and/or password.Need help?");
        assertThat(loginPage.isOnLoginPage()).isTrue();
    }

    @And("User enters their valid email to send password reset link")
    public void userEntersTheirEmailToSendPasswordResetLink() {
        loginHelpPage.enterRecoveryEmailIntoEmailField(PropertiesManager.getProperty("valid.email"));
        loginHelpPage.clickSendPasswordResetButton();
    }

    @When("User clicks Need Help button")
    public void userClicksButton() {
        loginPage.clickNeedHelpButton();
    }

    @Then("Send password reset link has been sent successfully")
    public void sendPasswordResetLinkHasBeenSentSuccessfully() {
        assertThat(loginHelpPage.getCheckYourEmailHeader()).isEqualTo("Check Your Email");
    }
}

