import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImageTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try{
            driver.get("https://the-internet.herokuapp.com/broken_images");
        }catch{

        }

    }
}
