package home;


import static constants.EndpointsHome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import extrato.ExtratoPage;
import helper.PageObject;
import transferencia.TransferenciaPage;

import static constants.EndpointsCadastro.URL_LOGIN;

public class HomePage extends PageObject{
	public HomePage(WebDriver browser) {
		super(browser);
	}
	
	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().equals(PAGINA_HOME);
	}
	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}
	public boolean isPaginaDeTransferencia() {
		return browser.getCurrentUrl().equals(URL_TRANSFERENCIA);
	}
	public boolean isPaginaDeExtrato() {
		return browser.getCurrentUrl().equals(URL_EXTRATO);
	}
	public String verificaMensagem(String mensagemAtual) {
		String mensagem = browser.findElement(By.xpath(mensagemAtual)).getText();
        return mensagem;
		
	}
	public void clica(String click) {
		browser.findElement(By.xpath(click)).click();
	}
	public TransferenciaPage realizaTransferencia(String click) {
		browser.findElement(By.xpath(click)).click();
		return new TransferenciaPage(this.browser);
	}
	public ExtratoPage mostraExtrato(String click) {
		browser.findElement(By.xpath(click)).click();
		return new ExtratoPage(this.browser);
	}
}
