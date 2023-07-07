package transferencia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constants.EndpointTransferencia.*;
import helper.PageObject;

public class TransferenciaPage extends PageObject{
	
	public TransferenciaPage(WebDriver browser) {
		super(browser);
	}
	public void fazerTranferencia(String numeroConta, String digito, String valor, String descricao) {
		browser.findElement(By.xpath(NUMERO_DA_CONTA)).sendKeys(numeroConta);
		browser.findElement(By.xpath(DIGITO_CONTA)).sendKeys(digito);
		browser.findElement(By.xpath(VALOR_DA_TRANSFERENCIA)).sendKeys(valor);
		browser.findElement(By.xpath(DESCRIÇÃO)).sendKeys(descricao);
	}
	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().equals(URL_TRANSFERENCIA);
	}
	public boolean isPaginaExtrato() {
		return browser.getCurrentUrl().equals(URL_EXTRATO);
	}
	public void clica(String click) {
		browser.findElement(By.xpath(click)).click();
	}
	public String verificaMensagem(String mensagemAtual) {
		String mensagem = browser.findElement(By.xpath(mensagemAtual)).getText();
        return mensagem;
		
	}
	
	
}
