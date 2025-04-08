package hudl.step_definitions;

import hudl.pages.LoginPage;
import hudl.utilities.BrowserUtils;
import hudl.utilities.ConfigurationReader;
import hudl.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStepDefs {

    private static final Logger log = LoggerFactory.getLogger(LoginStepDefs.class);
    LoginPage loginPage = new LoginPage();


    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        String actualTitle = Driver.getDriver().getTitle().trim();
        String expectedTitle = "Hudl • The leader in sports technology, video analysis & data";

        Assert.assertEquals("Check the title of the page", expectedTitle, actualTitle);
    }

    @When("User click login button")
    public void user_click_login_button() {
        loginPage.loginButton.click();
    }

    @When("User click on Hudl logo")
    public void user_click_on_hudl_logo() {
        loginPage.loginHudlLogo.click();
    }

    @Then("User must be on login window on Login Page")
    public void user_must_be_on_login_window_on_login_page() {
        String actualTitle = Driver.getDriver().getTitle().trim();
        String expectedTitle = "Log In";

        Assert.assertEquals("Check the title of the page", expectedTitle, actualTitle);
    }

    @When("User enter valid email and click Continue on Login Page")
    public void user_enter_valid_email_and_click_continue_on_login_page() {
        loginPage.emailInputBox.clear();
        loginPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.continueButton.click();
    }

    @When("User enter valid password and click Continue on Login Page")
    public void user_enter_valid_password_and_click_continue_on_login_page() {
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.continueButton.click();

    }

    @Then("User must be on the Home Page o the application")
    public void user_must_be_on_the_home_page_o_the_application() {
        BrowserUtils.sleep(2);
        String expectedUrl = "https://www.hudl.com/home";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals("Verify if user is in Home page", expectedUrl, actualUrl);
    }

    @When("User enter {string} invalid email and click Continue on Login Page")
    public void user_enter_invalid_email_and_click_continue_on_login_page(String invalidEmail) {
        loginPage.emailInputBox.sendKeys(invalidEmail);
        loginPage.continueButton.click();
    }

    @Then("User should see Edit button displayed")
    public void user_should_see_edit_button_displayed() {
        Assert.assertTrue("Verify visibility of the Edit button", loginPage.editButtonLoginPage.isDisplayed());
    }

    @When("When User enter valid password and click Continue on Login Page")
    public void when_user_enter_valid_password_and_click_continue_on_login_page() {
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @Then("User click on Edit button")
    public void user_click_on_edit_button() {
        loginPage.editButtonLoginPage.click();
    }

    @When("User click on Forgot Password button")
    public void user_click_on_forgot_password_button() {
        loginPage.forgotPasswordButton.click();
    }

    @Then("User should be on reset password page")
    public void user_should_be_on_reset_password_page() {
        String expectedTitle = "Reset Password";
        String actualTitile = Driver.getDriver().getTitle();

        Assert.assertEquals("Verify if user is on Reset Password page", expectedTitle, actualTitile);
    }

    @When("User click on continue button")
    public void user_click_on_continue_button() {
        loginPage.continueButton.click();
    }

    @Then("User should see {string} confirmation message")
    public void user_should_see_confirmation_message(String confirmationMessage) {
        String expectedMessage = confirmationMessage;
        String actualMessage = loginPage.confirmationMessage.getText();

        Assert.assertEquals("Verify if email has been sent", expectedMessage, actualMessage);
    }

    @Then("User should see Resend Email button")
    public void user_should_see_resend_email_button() {
        Assert.assertTrue("Verify the presence of the resend button", loginPage.resendEmailButton.isDisplayed());
    }

    @When("User enter {string} random password")
    public void user_enter_random_password(String randomPassword) {
        loginPage.passwordInputBox.sendKeys(randomPassword);
    }

    @When("User click on Show password button")
    public void user_click_on_show_password_button() {
        loginPage.showHidePasswordLogin.click();
    }

    @Then("User should be able to see the password")
    public void user_should_be_able_to_see_the_password() {
        Assert.assertTrue("Verify if password is visible", loginPage.hidePasswordButton.isDisplayed());
    }

    @When("User click on Hide password button")
    public void user_click_on_hide_password_button() {
        loginPage.showHidePasswordLogin.click();
    }

    @Then("User should not be able to see the password")
    public void user_should_not_be_able_to_see_the_password() {
        Assert.assertTrue("Verify if password is hidden", loginPage.showPasswordButton.isDisplayed());
    }

    @When("User click on Continue with Google button")
    public void user_click_on_continue_with_google_button() {
        loginPage.continueWithGoogleButton.click();
    }

    @Then("User should be redirected to the {string} page")
    public void user_should_be_redirected_to_the_page(String redirectedAccountName) {
        BrowserUtils.sleep(1);
        String expectedAccount = redirectedAccountName;
        String actualAccount = Driver.getDriver().getCurrentUrl();

        System.out.println(expectedAccount);
        System.out.println(actualAccount);

        Assert.assertTrue("Verify if user is redirected to the correct account", actualAccount.contains(expectedAccount));
    }

    @When("User click on Continue with Facebook button")
    public void user_click_on_continue_with_facebook_button() {
        loginPage.continueWithFacebookButton.click();
    }

    @When("User click on Continue with Apple button")
    public void user_click_on_continue_with_apple_button() {
        loginPage.continueWithAppleButton.click();
    }

    @When("User enter {string} invalid password and click Continue on Login Page")
    public void user_enter_invalid_password_and_click_continue_on_login_page(String invalidPassword) {
        loginPage.passwordInputBox.sendKeys(invalidPassword);
        loginPage.continueButton.click();
    }

    @Then("User should receive {string} warning message")
    public void user_should_receive_warning_message(String warningMessage) {
        BrowserUtils.sleep(2);
        String expectedWarningMessage = warningMessage;
        String actualWarningMessage = loginPage.incorrectUsernameOrPasswordMessage.getText().trim();

        Assert.assertEquals("Verify if incorrect credentials warning message is displayed", expectedWarningMessage, actualWarningMessage);
    }

    @When("User enter invalid {string} and click Continue on Login Page")
    public void user_enter_invalid_and_click_continue_on_login_page(String invalidEmail) {
        loginPage.emailInputBox.sendKeys(invalidEmail);
        loginPage.continueButton.click();
    }

    @When("User enter only digits {string} in email field and click Continue on Login Page")
    public void user_enter_only_digits_in_email_field_and_click_continue_on_login_page(String digitInputs) {
        loginPage.emailInputBox.sendKeys(digitInputs);
        loginPage.continueButton.click();
    }

    @Then("User should see the {string} warning message")
    public void user_should_see_the_warning_message(String errorMessage) {
        String expectedWarningMessage = errorMessage;
        String actualWarningMessage = loginPage. warningMessageLogin.getText().trim();

        Assert.assertEquals("Verify if incorrect credentials warning message is displayed", expectedWarningMessage, actualWarningMessage);
    }

    @When("User use invalid {string} email and click Continue on Login Page")
    public void user_use_invalid_email_and_click_continue_on_login_page(String email) {
        loginPage.emailInputBox.sendKeys(email);
        loginPage.continueButton.click();
    }

    @When("User use invalid {string} password and click Continue on Login Page")
    public void user_use_invalid_password_and_click_continue_on_login_page(String password) {
        loginPage.passwordInputBox.sendKeys(password);
        loginPage.continueButton.click();
    }





}