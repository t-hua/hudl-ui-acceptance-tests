package pages.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class LoginHelpPage {

    SelenideElement emailField = $("input[data-qa-id='password-reset-input']");

    SelenideElement sendPasswordResetButton = $("button[data-qa-id='password-reset-submit-btn']");

    SelenideElement checkYourEmailHeader =
            $("#app > section > div.styles_pageContainer_31NnIgZuiQzDKnKlPaGLsi > div > div > div > h3");

    public void enterRecoveryEmailIntoEmailField(String email) {
        emailField.shouldBe(Condition.visible)
                .sendKeys(email);
    }

    public void clickSendPasswordResetButton() {
        sendPasswordResetButton.shouldBe(Condition.enabled)
                .click();
    }

    public String getCheckYourEmailHeader() {
        checkYourEmailHeader.shouldBe(Condition.visible);
        return checkYourEmailHeader.getOwnText();
    }

}
