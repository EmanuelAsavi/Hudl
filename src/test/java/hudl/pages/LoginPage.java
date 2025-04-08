package hudl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@data-qa-id='login-select']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@data-qa-id='login-hudl']")
    public WebElement loginHudlLogo;

    @FindBy(css = "input[inputmode='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    public WebElement continueButton;

    @FindBy(css = "#password")
    public WebElement passwordInputBox;

    @FindBy(css = "#error-element-password")
    public WebElement incorrectUsernameOrPasswordMessage;

    @FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
    public WebElement forgotPasswordButton;

    @FindBy(xpath = "//a[@aria-label='Edit email address']")
    public WebElement editButtonLoginPage;

    @FindBy(xpath = "//button[@data-action='toggle']")
    public WebElement showHidePasswordLogin;

    @FindBy(xpath = "//input[@id='password' and @type='password']")
    public WebElement showPasswordButton;

    @FindBy(xpath = "//input[@id='password' and @type='text']")
    public WebElement hidePasswordButton;

    @FindBy(xpath = "//h1[@role='presentation']")
    public WebElement confirmationMessage;

    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Resend Email')]")
    public WebElement resendEmailButton;

    @FindBy(xpath = "//button[@data-provider='google']")
    public WebElement continueWithGoogleButton;

    @FindBy(xpath = "//button[@data-provider='facebook']")
    public WebElement continueWithFacebookButton;

    @FindBy(xpath = "//button[@data-provider='apple']")
    public WebElement continueWithAppleButton;

    @FindBy(xpath = "//span[@id='error-element-username']")
    public WebElement warningMessageLogin;

}