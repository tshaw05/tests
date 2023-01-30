package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    /*
    Locators for the following web elements:
    1. "Sign in With Email" button
    2. Text input box for email address
    3. "Next" button
    4. Text box that gives email error messages
     */
    private By signInWithEmailLink = By.xpath(
            "//*[@id='firebaseui-auth-container']/div/div[1]/form/ul/li[2]/button");
    private By emailInputBox = By.className("firebaseui-id-email");
    private By nextButton = By.xpath(
            "//*[@id='firebaseui-auth-container']/div/form/div[3]/div/button[2]");
    private By emailAddressErrorText = By.className("firebaseui-id-email-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInWithEmail() {
        driver.findElement(signInWithEmailLink).click();
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    /*
    - Enters a given String (emailAddress) into the email input text box
     */
    public void enterEmail(String emailAddress) {
        driver.findElement(emailInputBox).sendKeys(emailAddress);
    }

    /*
    - Returns the text of the email address error message web element
     */
    public String getEmailAddressErrorText() {
        return driver.findElement(emailAddressErrorText).getText();
    }
}
