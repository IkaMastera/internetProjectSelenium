import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try{
            driver.get("https://the-internet.herokuapp.com/checkboxes");

            List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

            for(WebElement checkbox : checkBoxes) {
                if(!checkbox.isSelected()){
                    checkbox.click();
                    System.out.println("Checkbox selected.");
                }else{
                    System.out.println("Checkbox already selected.");
                }
            }

            Thread.sleep(2000);

            for(WebElement checkbox : checkBoxes){
                if(checkbox.isSelected()){
                    checkbox.click();
                    System.out.println("Checkbox deselected.");
                }
            }

            Thread.sleep(2000);
        } catch(InterruptedException e){
            e.printStackTrace();
        } finally{
            driver.quit();
        }
    }
}
