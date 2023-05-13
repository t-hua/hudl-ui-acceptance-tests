package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePage {

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    private SelenideElement acceptCookiesButton = $("#onetrust-accept-btn-handler");

    private SelenideElement skipToMainContentButton = $("a.skip-nav[href='#maincontent']");

    private SelenideElement loginSelect = $("body > div.outer > header > div > div > a");

    private SelenideElement hudlLoginLogo = $("a[data-qa-id='login-hudl']");

    private SelenideElement mainSiteLogo = $("a[data-qa-id='site-logo'");

    private ElementsCollection listOfFooterLinks = $$("a[class='footer-link']");


    public void clickAcceptAllCookies() {
        acceptCookiesButton.shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .scrollTo()
                .click();
    }

    public void clickSkipToMainContent() {
        skipToMainContentButton.shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .scrollTo()
                .click();
    }

    public void clickLoginSelect() {
        loginSelect.shouldBe(Condition.visible)
                .scrollTo().click();
    }

    public void clickHudlLoginLogo() {
        hudlLoginLogo.shouldBe(Condition.visible)
                .scrollTo().click();
    }

    public void clickFooterLinkFromList(String footerLink) {
        for (int i = 0; i < listOfFooterLinks.size(); i++) {
            String footerText = listOfFooterLinks.get(i).getText();
            if (footerText.contains(footerLink)) {
                listOfFooterLinks.get(i).shouldBe(Condition.visible)
                        .scrollTo()
                        .click();
            }
        }
    }

    public boolean isOnHomePage() {
        mainSiteLogo.shouldBe(Condition.visible);
        loginSelect.shouldBe(Condition.visible);
        return mainSiteLogo.exists() && mainSiteLogo.isDisplayed()
                && loginSelect.exists() && loginSelect.isDisplayed();
    }
}

