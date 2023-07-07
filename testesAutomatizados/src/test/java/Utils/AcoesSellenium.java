package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AcoesSellenium {
    public static void click(WebDriver driver, By by, int espera){
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(espera))).until(ExpectedConditions.elementToBeClickable(by));
        element.click();

    }
    public WebElement enviarDados(WebDriver driver, By by, String valor, int espera){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(espera));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        WebElement element = driver.findElement(by);

        element.sendKeys(valor);
        return element;
    }

}
