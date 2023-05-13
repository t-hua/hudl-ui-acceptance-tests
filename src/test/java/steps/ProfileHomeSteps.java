package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ProfileHomePage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.PropertiesManager;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.*;

public class ProfileHomeSteps {

    private static final Logger log = LoggerFactory.getLogger(ProfileHomeSteps.class);

    ProfileHomePage profileHomePage = new ProfileHomePage();

    @Then("User is on the Profile Home page")
    public void userIsOnTheHomePage() {
        String url = PropertiesManager.getProperty("profileHome.url");

        assertThat(profileHomePage.isOnProfilePage()).isTrue();
        assertThat(getWebDriver().getCurrentUrl()).isEqualTo(url);
    }

    @And("User clicks on Logout")
    public void userClicksOnLogout() {
        profileHomePage.clickLogout();
    }
}
