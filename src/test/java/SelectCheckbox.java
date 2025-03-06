import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SelectCheckbox {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://demo.guru99.com/test/radio.html");

        // Locate all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        // Select only the first two checkboxes
        for (int i = 0; i < 2 && i < checkboxes.size(); i++) {
            if (!checkboxes.get(i).isSelected()) {  // Check if already selected
                checkboxes.get(i).click();
                System.out.println("Checkbox " + (i + 1) + " selected: " + checkboxes.get(i).isSelected());
            }
        }


    }
}

