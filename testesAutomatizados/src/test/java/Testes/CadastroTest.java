package Testes;

import Page.CadastroPage;
import Utils.GerenciamentoDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class CadastroTest {
    private WebDriver driver;
    GerenciamentoDriver gerenciamentoDriver;
    CadastroPage cadastroPage;
    @Before
    public void setup(){
        gerenciamentoDriver = new GerenciamentoDriver();
        driver = GerenciamentoDriver.browser("Edge");
        cadastroPage = new CadastroPage(driver);
    }
    @Test
    public void criarUsuarioComTodosOsCamposValidos(){
        driver.get("https://bugbank.netlify.app/");
        cadastroPage.cadastrarUsuario();
    }

    /*@Test
    public void criarUsuarioComTodosOsCamposValidos(){
        System.setProperty("webdriver.edge.drive", "drivers/msedgedriver.exe");
        WebDriver navegador = new EdgeDriver();
        navegador.navigate().to("http://bugbank.netlify.app");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys(  "teste@teste.com");

        navegador.findElement(By.name("name")).sendKeys(  "Teste");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")).sendKeys(  "123456");

        navegador.findElement(By.name("passwordConfirmation")).sendKeys(  "123456");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")).submit();

    }
    @Test
    public void criarUmUsuarioSemOCampoEmail() {
        System.setProperty("webdriver.edge.drive", "drivers/msedgedriver.exe");
        WebDriver navegador = new EdgeDriver();

        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        navegador.navigate().to("http://bugbank.netlify.app");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();

        navegador.findElement(By.name("name")).sendKeys("Teste");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")).sendKeys("123456");

        navegador.findElement(By.name("passwordConfirmation")).sendKeys("123456");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")).submit();

        String mensagem = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/p")).getText();
        System.out.println("Mensagem recebida:" + mensagem);
        Assert.assertEquals("Email não pode ser vazio", mensagem);
    }

    @Test
    public void criarUsuarioSemOcampoNome() throws InterruptedException{
        System.setProperty("webdriver.edge.drive", "drivers/msedgedriver.exe");
        WebDriver navegador = new EdgeDriver();

        navegador.navigate().to("http://bugbank.netlify.app");


        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys(  "teste@teste.com");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")).sendKeys(  "123456");

        navegador.findElement(By.name("passwordConfirmation")).sendKeys(  "123456");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")).submit();
        Thread.sleep(1000);
        String mensagem = navegador.findElement(By.xpath("//*[@id=\"modalText\"]")).getText();
        System.out.println("Mensagem recebida:" + mensagem);
        Assertions.assertEquals("Nome não pode ser vazio.", mensagem);
    }

    @Test
    public void criarUsuarioSemOcampoSenha() throws InterruptedException{
        System.setProperty("webdriver.edge.drive", "drivers/msedgedriver.exe");
        WebDriver navegador = new EdgeDriver();

        navegador.navigate().to("http://bugbank.netlify.app");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys(  "teste@teste.com");

        navegador.findElement(By.name("passwordConfirmation")).sendKeys(  "123456");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")).submit();
        Thread.sleep(1000);
        String mensagem = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/p")).getText();
        System.out.println("Mensagem recebida:" + mensagem);
        Assertions.assertEquals("Senha não pode ser vazio.", mensagem);
    }
    @Test
    public void criarUsuarioSemOcampoConfirmaçãodeSenha() throws InterruptedException{
        System.setProperty("webdriver.edge.drive", "drivers/msedgedriver.exe");
        WebDriver navegador = new EdgeDriver();

        navegador.navigate().to("http://bugbank.netlify.app");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys(  "teste@teste.com");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")).sendKeys(  "123456");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")).submit();
        Thread.sleep(1000);
        String mensagem = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/p")).getText();
        System.out.println("Mensagem recebida:" + mensagem);
        Assertions.assertEquals("Confirmação de senha não pode ser vazio.", mensagem);
    }
    @Test
    public void criarContaComSaldo()throws InterruptedException{

            System.setProperty("webdriver.edge.drive", "drivers/msedgedriver.exe");
            WebDriver navegador = new EdgeDriver();
            navegador.navigate().to("http://bugbank.netlify.app");
            navegador.manage().window().maximize();
            navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();

            navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys(  "teste@teste.com");

            navegador.findElement(By.name("name")).sendKeys(  "Teste");

            navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")).sendKeys(  "123456");

            navegador.findElement(By.name("passwordConfirmation")).sendKeys(  "123456");

            navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[6]/label")).click();

            navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")).click();

        }

    @Test
    public void testeFazerLogin(){
        System.setProperty("webdriver.edge.drive", "drivers/msedgedriver.exe");
        WebDriver navegador = new EdgeDriver();
        navegador.navigate().to("http://bugbank.netlify.app");

        navegador.findElement(By.name("email")).sendKeys(  "teste@teste.com");

        navegador.findElement(By.name("password")).sendKeys(  "123456");

        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]")).click();


    }*/
    @After
    public void fim(){
        //driver.quit();
    }


}
