package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import java.time.Duration;

public class BaseTests {

    protected static WebDriver driver;
    protected static HomePage homePage;
    private static String url = "https://testautomationu.applitools.com/";

    @BeforeClass
    /*
    Creates new instance of the Chrome Driver
    Opens url provided by the url variable
    Creates new Home Page object to interact with the page provided by the url
     */
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        homePage = new HomePage(driver);
    }


    @AfterClass
    /*
    Closes instance of Chrome Driver
     */
    public static void tearDown() {
        driver.quit();
    }
}
