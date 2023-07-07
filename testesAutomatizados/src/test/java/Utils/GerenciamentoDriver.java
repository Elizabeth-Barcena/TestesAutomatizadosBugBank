package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class GerenciamentoDriver {
    protected static WebDriver driver;
    public static WebDriver browser(String browser) {

        if (browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        return driver;

    }
}
