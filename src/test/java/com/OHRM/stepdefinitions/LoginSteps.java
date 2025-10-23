package com.OHRM.stepdefinitions;


import com.OHRM.context.TestContext;
import com.OHRM.utils.AllureManager;
import com.OHRM.utils.LoggerUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {
    private final TestContext context;

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        String baseUrl = context.getBaseUrl();
        LoggerUtil.info("Navigation vers l'URL: " + baseUrl);
        AllureManager.logStep("Navigation vers la page de connexion");
        context.getSeleniumUtils().navigateTo(baseUrl);
    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        LoggerUtil.info("Saisie des identifiants - Username: " + username);
        AllureManager.logStep("Saisie des identifiants: " + username);
        context.getLoginPage().enterUsername(username);
        context.getLoginPage().enterPassword(password);
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        LoggerUtil.info("Clic sur le bouton de connexion");
        AllureManager.logStep("Clic sur le bouton de connexion");
        context.getLoginPage().clickLogin();
    }

    // Méthodes de vérification pour le succès
    @Then("login should be successful")
    public void loginShouldBeSuccessful() {
        Assertions.assertTrue(context.getLoginPage().isDashboardDisplayed(),
            "L'utilisateur n'est pas redirigé vers le dashboard !");
        LoggerUtil.info("Connexion réussie - Dashboard affiché");
        AllureManager.logStep("Vérification de la connexion réussie");
    }

    @Then("user should be redirected to dashboard")
    public void userShouldBeRedirectedToDashboard() {
        LoggerUtil.info("Vérification de la redirection vers le dashboard");
        AllureManager.logStep("Vérification de la redirection vers le dashboard");
    }

    // Méthodes de vérification pour l'échec
    @Then("login should fail")
    public void loginShouldFail() {
        Assertions.assertTrue(context.getLoginPage().isErrorDisplayed(),
            "Aucun message d'erreur affiché !");
        LoggerUtil.info("Échec de connexion détecté");
        AllureManager.logStep("Vérification de l'échec de connexion");
    }

    @Then("error message should be {string}")
    public void errorMessageShouldBe(String expectedMessage) {
        String actualMessage = context.getLoginPage().getErrorMessage().trim();

        // Vérification multi-cas : message global ou message de champ
        boolean isMatch = actualMessage.equalsIgnoreCase(expectedMessage)
                || actualMessage.contains(expectedMessage);

        Assertions.assertTrue(isMatch,
                "❌ Message d'erreur incorrect ! Attendu: '" + expectedMessage + "', mais obtenu: '" + actualMessage + "'");

        LoggerUtil.info("✅ Message d'erreur vérifié avec succès: " + actualMessage);
        AllureManager.logStep("Vérification du message d'erreur affiché: " + actualMessage);
    }

    // Méthode de vérification pour le lien "Forgot password"
    @Then("forgot password link should be displayed")
    public void forgotPasswordLinkShouldBeDisplayed() {
        Assertions.assertTrue(context.getLoginPage().isForgotPasswordLinkDisplayed(),
            "Le lien 'Forgot your password?' n'est pas affiché !");
        LoggerUtil.info("Lien 'Forgot your password?' vérifié");
        AllureManager.logStep("Vérification du lien 'Forgot your password?'");
    }
}