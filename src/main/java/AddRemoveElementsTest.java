import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AddRemoveElementsTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));

        if(!deleteButton.isDisplayed()){
            throw new AssertionError("Delete button should be displayed after clicking Add Element");
        }
        System.out.println("Test passed: Delete button is displayed.");

        deleteButton.click();

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        if(!deleteButtons.isEmpty()){
            throw new AssertionError("Delete button should no longer be present after deletion");
        }
        System.out.println("Test passed: Delete button has been removed.");
    }
}
