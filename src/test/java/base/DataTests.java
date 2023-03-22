package base;

import org.testng.annotations.Test;

public class DataTests extends BaseTests{

    @Test
    /*
    - Basic test to demonstrate taking a value from one webpage and
      using it on another page
    - Attempts to navigate to the About Ranks page and
      take text value of the 'Griffin' text box
    - Navigates to the Login Page and enters the stored text value
      in the 'Email' field
     */
    private void getTextContent() {
        var ranksPage = homePage.clickAboutRanks();
        String elementText = ranksPage.getElementText();

        var loginPage = ranksPage.clickEnrollNow();
        loginPage.clickSignInWithEmail();
        loginPage.enterEmail(elementText);
    }
}
