package pages.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    SelenideElement emailField = $("#email");

    SelenideElement passwordField = $("#password");

    SelenideElement loginButton = $("#logIn");

    SelenideElement loginErrorMessage = $("p[data-qa-id='error-display']");

    SelenideElement needHelpButton = $("a[data-qa-id='need-help-link'");


    public void enterLoginCredentials(String email, String password) {
        emailField.shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .sendKeys(email);
        passwordField.shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .sendKeys(password);
        loginButton.shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .click();
    }

    public String getLoginErrorMessage() {
        loginErrorMessage.shouldBe(Condition.visible);
        return loginErrorMessage.getText();
    }

    public boolean isOnLoginPage() {
        return emailField.exists() && passwordField.exists() && loginButton.exists();
    }

    public void clickNeedHelpButton() {
        needHelpButton.shouldBe(Condition.visible)
                .click();
    }
}
