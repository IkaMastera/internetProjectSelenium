import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try{
            String username = "admin";
            String password = "admin";
            String authUrl = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";

            driver.get(authUrl);

            String bodyText = driver.findElement(By.tagName("body")).getText();

            // Validating The Authentication
            if(bodyText.contains("Congratulations")){
                System.out.println("Test passed: Basic authentication was successful.");
            }else{
                throw new AssertionError("Test failed: Basic authentication did not succeed.");
            }
        } catch(Exception e){
            System.err.println(e.getMessage());
        } finally {
            driver.quit();
        }



    }
}
