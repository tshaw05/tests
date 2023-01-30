package base;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests{

    @DataProvider(name = "badEmailAddresses")
    /*
    - A collection of test strings for use with the invalidEmailEntered
      test method
     */
    public Object[][] createData() {
        return new Object[][] {
                {"a"},
                {"1"},
                {"@"},
                {"."},
                {".com"}
        };
    }

    @Test
    /*
    - Attempts to sign in without entering any characters when prompted
      for an email address
    - Checks that the webpage gives the expected error message for a
      blank entry
     */
    private void noEmailEntered() {
        var loginPage = homePage.clickEnrollNow();
        loginPage.clickSignInWithEmail();
        loginPage.clickNextButton();
        assertEquals(loginPage.getEmailAddressErrorText(),
                        "Enter your email address to continue",
                "Invalid/missing error message: text mismatch");
    }

    @Test(dataProvider = "badEmailAddresses")
    /*
    - Attempts to sign in using an invalid email address
    - Checks that the webpage gives the expected error message for an
      invalid email address
    - All strings within the badEmailAddresses Data Provider are tested
     */
    private void invalidEmailEntered(String badEmail) {
        var loginPage = homePage.clickEnrollNow();
        loginPage.clickSignInWithEmail();
        loginPage.enterEmail(badEmail);
        loginPage.clickNextButton();
        assertEquals(loginPage.getEmailAddressErrorText(),
                "That email address isn't correct",
                "Invalid/missing error message: text mismatch");
    }
}