import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);

        WebElement hotSpot = driver.findElement(By.id("hot-spot"));

        actions.contextClick(hotSpot).perform();

        System.out.println("Context Menu displayed");

        driver.quit();
    }
}
