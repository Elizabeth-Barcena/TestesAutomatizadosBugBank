 package cadastro;

import org.openqa.selenium.By;
import helper.PageObject;
import login.LoginPage;
import static constants.EndpointsCadastro.*;

import java.util.regex.Pattern;

public class CadastroPage extends PageObject {
	public CadastroPage() {
		super(null);
        browser.navigate().to(URL_LOGIN);
	}
	
	public void cadastrarUsuario(String email, String nome, String senha, String confirmacaoSenha) {
		browser.findElement(By.xpath(EMAIL_CADASTRO)).sendKeys(email);
		browser.findElement(By.xpath(NOME_CADASTRO)).sendKeys(nome);
		browser.findElement(By.xpath(SENHA_CADASTRO)).sendKeys(senha);
		browser.findElement(By.xpath(CONFIRMACAO_SENHA_CADASTRO)).sendKeys(confirmacaoSenha);

	}
	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}
	public void fecharModal() {
		browser.findElement(By.xpath(FECHAR_MODAL_CADASTRO)).click();
	}
	public String verificaMensagem(String mensagemAtual) {
		String mensagem = browser.findElement(By.xpath(mensagemAtual)).getText();
        return mensagem;
		
	}
	public void clica(String click) {
		browser.findElement(By.xpath(click)).click();
	}
	public void submit(String click) {
		browser.findElement(By.xpath(click)).submit();
	}
	public LoginPage realizaCadastro(String click) {
		browser.findElement(By.xpath(click)).click();
		return new LoginPage(this.browser);
	}
	public boolean isMensagensDeValidacaooVisivel() {
		String pageSource = browser.getPageSource();
		return pageSource.contains("Email não pode ser vazio");
	}
	public boolean isPaginaHome() {
		return browser.getCurrentUrl().equals(URL_HOME);
	}
	public void navegaParaPaginaDeLogin() {
		this.browser.navigate().to(URL_LOGIN);
	}
	public void limparCampos() {
		browser.findElement(By.xpath(EMAIL_CADASTRO)).clear();
		browser.findElement(By.xpath(NOME_CADASTRO)).clear();
		browser.findElement(By.xpath(SENHA_CADASTRO)).clear();
		browser.findElement(By.xpath(CONFIRMACAO_SENHA_CADASTRO)).clear();
	}
	public String retornarNumeroConta(String caminho) {

		String texto = this.browser.findElement(By.xpath(caminho)).getText();

		Pattern pattern = Pattern.compile("\\b\\d+(?=-)");

		java.util.regex.Matcher matcher = pattern.matcher(texto);

		if (matcher.find()) {

		String numero = matcher.group();

		return numero;
		}

		return "";
	}
	public String retornarDigitoConta(String caminho) {

		String texto = this.browser.findElement(By.xpath(caminho)).getText();

		Pattern pattern = Pattern.compile("(?<=-)\\d+");

		java.util.regex.Matcher matcher = pattern.matcher(texto);

		if (matcher.find()) {

		String numero = matcher.group();

		return numero;

		}

		return "";

		}
	

}
