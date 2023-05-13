package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.codeborne.selenide.Selenide.$;

public class ProfileHomePage {

    private static final Logger log = LoggerFactory.getLogger(ProfileHomePage.class);

    SelenideElement profileName = $("a[class='uni-subhead']");

    SelenideElement huiUserMenu = $("div[class='hui-globaluseritem__display-name']");

    SelenideElement logOutButton = $("a[data-qa-id='webnav-usermenu-logout']");

    public boolean isOnProfilePage() {
        return profileName.shouldBe(Condition.visible).isDisplayed();
    }

    public void clickLogout() {
        huiUserMenu.hover();
        logOutButton.shouldBe(Condition.visible);
        logOutButton.scrollTo().click();
    }
}
