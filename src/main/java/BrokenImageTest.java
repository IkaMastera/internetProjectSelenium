import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.util.List;

public class BrokenImageTest {
    public static void main(String[] args) {
        // Set up ChromeDriver (ensure chromedriver is in PATH or specify path)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update this if not in PATH
        WebDriver driver = new ChromeDriver();

        // Navigate to the page
        driver.get("https://the-internet.herokuapp.com/broken_images");

        // Find all images
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total images found: " + images.size());

        // Check each image
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement img : images) {
            String imgUrl = img.getAttribute("src");
            if (imgUrl == null || imgUrl.isEmpty()) {
                System.out.println("Image has no src attribute: " + img.getAttribute("outerHTML"));
                continue;
            }

            // Method 1: Check if image is broken using JavaScript
            Boolean isBroken = (Boolean) js.executeScript(
                    "return arguments[0].naturalWidth === 0 || arguments[0].naturalHeight === 0;", img
            );

            // Method 2: Check HTTP status
            int statusCode = getHttpStatus(imgUrl);

            if (isBroken || statusCode != 200) {
                System.out.println("Broken image detected: " + imgUrl + " (HTTP Status: " + statusCode + ")");
            } else {
                System.out.println("Image is valid: " + imgUrl + " (HTTP Status: " + statusCode + ")");
            }
        }

        // Clean up
        driver.quit();
    }

    private static int getHttpStatus(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (Exception e) {
            return -1; // Indicate an error
        }
    }
}
