package stepDefinitions;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestSetup {

    public static WebDriver driver;
    public static String baseUrl = "http://localhost:5173";

    @Before
    public void setUp() {
        driver = new EdgeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @After
    public void shutDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
