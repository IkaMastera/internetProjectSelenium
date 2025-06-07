import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappearingElementsTest {
    public static void main(String[] args) {
          // Set up WebDriver (Make sure chromedriver is in PATH or project folder)
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe")
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            driver.get("https://the-internet.herokuapp.com/disappearing_elements");

            // Defined menu items
            List<String> expectedItems = Arrays.asList("Home", "About", "Contact Us", "Portfolio", "Gallery");
            List<String> actualItems = new ArrayList<>();

             // Find all menu elements
            List<WebElement> menuElements = driver.findElements(By.cssSelector("ul li a"));

            for (WebElement item : menuElements) {
                actualItems.add(item.getText().trim());
            }

            System.out.println("Actual Items: " + actualItems);

            // Check for missing items
            for (String expected : expectedItems) {
                if (!actualItems.contains(expected)) {
                    System.out.println("❌ Missing: " + expected);
                } else {
                    System.out.println("✅ Found: " + expected);
                }
            }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    driver.quit();
                
        }
    }
}
