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
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe")
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try{
            driver.get("https://the-internet.herokuapp.com/disappearing_elements");

            // Defined menu items
            List<String> expectedItems = Arrays.asList("Home", "About", "Contact Us", "Portfolio", "Gallery");
            List<String> actualItems = new ArrayList<>();
        }
    }
}
