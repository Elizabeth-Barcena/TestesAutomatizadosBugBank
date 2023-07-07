package Page;

import Utils.AcoesSellenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroPage extends AcoesSellenium {
    private WebDriver driver;

    public CadastroPage(WebDriver driver){
        this.driver = driver;
    }
    public static final By inputCadastro = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]");
    public static final By inputEmail= By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input");
    public static final By inputNome = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input");
    public void cadastrarUsuario(){
        click(driver, inputCadastro, 10);
        enviarDados(driver, inputEmail, "teste@teste.com", 10);
        enviarDados(driver, inputNome, "teste", 10);
    }
}
