package extrato;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.PageObject;

public class ExtratoPage extends PageObject{
	public ExtratoPage (WebDriver browser) {
		super(browser);
	}
	public void clica(String click) {
		browser.findElement(By.xpath(click)).click();
	}
	public String verificaMensagem(String mensagemAtual) {
		String mensagem = browser.findElement(By.xpath(mensagemAtual)).getText();
        return mensagem;
		
	}
	

}
