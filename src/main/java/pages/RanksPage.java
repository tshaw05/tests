package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RanksPage {

    private WebDriver driver;

    private By griffinText = By.xpath(
            "//*[@id=\"app\"]/div[1]/div[3]/div[1]/div/div/div/div/h1[1]");

    public RanksPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getElementText() {
        return driver.findElement(griffinText).getText();
    }

    public LoginPage clickEnrollNow() {
        driver.findElement(By.linkText("Enroll Now")).click();
        return new LoginPage(driver);
    }
}
