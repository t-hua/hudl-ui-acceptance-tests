package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;

import static org.assertj.core.api.Assertions.*;


public class HomeSteps {
    private static final Logger log = LoggerFactory.getLogger(HomeSteps.class);
    HomePage homePage = new HomePage();

    @Given("User navigates to the Login page")
    public void userNavigatesToTheLoginPage() {
        homePage.clickLoginSelect();
        homePage.clickHudlLoginLogo();
    }

    @Given("User clicks on the {} footer link")
    public void userClicksOnTheLoginFooterLink(String footerLink) {
        homePage.clickFooterLinkFromList(footerLink);
    }

    @Given("User accepts all cookies")
    public void userAcceptsAllCookies() {
        homePage.clickAcceptAllCookies();
        homePage.clickSkipToMainContent();
    }

    @Then("User is on Home page")
    public void userIsOnHomePage() {
        assertThat(homePage.isOnHomePage()).isTrue();
    }
}
