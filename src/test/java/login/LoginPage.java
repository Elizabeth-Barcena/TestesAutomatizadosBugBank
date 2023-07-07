package login;

import helper.PageObject;
import home.HomePage;

import static constants.EndpointsCadastro.*;
import static constants.EndpointsLogin.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends PageObject {
	public LoginPage(WebDriver browser) {
		super(null);
        browser.navigate().to(URL_LOGIN);
	}

	public void fazerLogin(String email, String senha) {
		browser.findElement(By.xpath(EMAIL_LOGIN)).sendKeys(email);
		browser.findElement(By.xpath(SENHA_LOGIN)).sendKeys(senha);
		
	}
	public HomePage realizaLogin(String click) {
		browser.findElement(By.xpath(click)).click();
		return new HomePage(this.browser);
	}
	public void clica(String click) {
		browser.findElement(By.xpath(click)).click();
	}

	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}
	
}
