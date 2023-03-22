package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /*
    - Clicks the link labelled "Enroll Now"
    - Returns a new Login Page object to interact with the linked page
     */
    public LoginPage clickEnrollNow() {
        clickLink("Enroll Now");
        return new LoginPage(driver);
    }

    public RanksPage clickAboutRanks() {
        clickLink("About Ranks");
        return new RanksPage(driver);
    }

    /*
    - Clicks a link with label specified by the linkText String
     */
    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
