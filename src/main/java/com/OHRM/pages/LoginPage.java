package com.OHRM.pages;

import com.OHRM.base.AbstractPage;
import com.OHRM.utils.WaitUtils;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {

    private static final By USERNAME_FIELD = By.name("username");
    private static final By PASSWORD_FIELD = By.name("password");
    private static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    private static final By INVALID_CREDENTIALS_MESSAGE = By.cssSelector("p.oxd-alert-content-text");
    private static final By REQUIRED_FIELD_MESSAGES = By.cssSelector("span.oxd-input-field-error-message");
    private static final By DASHBOARD_HEADER = By.xpath("//h6[normalize-space()='Dashboard']");
    private static final By FORGOT_PASSWORD_LINK = By.cssSelector("p.orangehrm-login-forgot-header");

    public void enterUsername(String username) {
        type(USERNAME_FIELD, username);
    }

    public void enterPassword(String password) {
        type(PASSWORD_FIELD, password);
    }

    public void clickLogin() {
        click(LOGIN_BUTTON);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    /** ✅ Vérifie si un message d’erreur (Invalid ou Required) est affiché */
    public boolean isErrorDisplayed() {
        try {
            return isDisplayed(INVALID_CREDENTIALS_MESSAGE) || isDisplayed(REQUIRED_FIELD_MESSAGES);
        } catch (Exception e) {
            return false;
        }
    }

    /** ✅ Récupère le texte du message d’erreur, qu’il soit global ou champ vide */
    public String getErrorMessage() {
        try {
            if (isDisplayed(INVALID_CREDENTIALS_MESSAGE)) {
                return getText(INVALID_CREDENTIALS_MESSAGE);
            } else if (isDisplayed(REQUIRED_FIELD_MESSAGES)) {
                return getText(REQUIRED_FIELD_MESSAGES);
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isDashboardDisplayed() {
        try {
            WaitUtils.waitForElementToBeVisible(DASHBOARD_HEADER);
            return isDisplayed(DASHBOARD_HEADER);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isForgotPasswordLinkDisplayed() {
        try {
            WaitUtils.waitForElementToBeVisible(FORGOT_PASSWORD_LINK);
            return isDisplayed(FORGOT_PASSWORD_LINK);
        } catch (Exception e) {
            return false;
        }
    }
}
