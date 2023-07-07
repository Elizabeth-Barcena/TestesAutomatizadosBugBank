package login;

import static constants.EndpointsCadastro.*;
import static constants.EndpointsLogin.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cadastro.CadastroPage;
import dataFactory.DynamicFactory;
import model.Cadastro;

public class LoginTest {
	private CadastroPage paginaDeCadastro;
	Cadastro usuario;
	private LoginPage paginaDeLogin; 
	@BeforeEach
	public void beforeEach() throws InterruptedException {
		this.paginaDeCadastro = new CadastroPage();
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getSenha(), usuario.getConfirmaSenha());
		this.paginaDeLogin= paginaDeCadastro.realizaCadastro(BOTAO_CADASTRAR);
		Thread.sleep(2000);
		paginaDeCadastro.clica(FECHAR_MODAL_CADASTRO);
		Thread.sleep(2000);
	}
	
	@Test
	public void fazerLoginComUsuarioValido() throws InterruptedException {
		paginaDeLogin.fazerLogin(usuario.getEmail(), usuario.getSenha());
		paginaDeLogin.clica(BOTAO_LOGIN);
		Thread.sleep(2000);
		
		Assertions.assertFalse(this.paginaDeLogin.isPaginaAtual());
		
	}
	@Test
	public void fazerLoginComSenhaIncorreta() throws InterruptedException {
		paginaDeLogin.fazerLogin(usuario.getEmail(), "senhaIncorreta");
		paginaDeLogin.clica(BOTAO_LOGIN);
		Thread.sleep(2000);
		 assertAll("teste",
					()-> assertTrue(this.paginaDeCadastro.isPaginaAtual()), 
					()-> assertEquals("Usuário ou senha inválido.\n"+"Tente novamente ou verifique suas informações!",this.paginaDeCadastro.verificaMensagem(MENSAGEM_LOGIN))
	        );
		
	}
	@Test
	public void fazerLoginComEmailIncorreto() throws InterruptedException {
		paginaDeLogin.fazerLogin("testeIncorreto@teste.com", usuario.getSenha());
		paginaDeLogin.clica(BOTAO_LOGIN);
		Thread.sleep(2000);
		 assertAll("teste",
					()-> assertTrue(this.paginaDeCadastro.isPaginaAtual()), 
					()-> assertEquals("Usuário ou senha inválido.\n"+"Tente novamente ou verifique suas informações!",this.paginaDeCadastro.verificaMensagem(MENSAGEM_LOGIN))
	        );
		
	}
	@Test
	public void fazerLoginComSenhaVazia() throws InterruptedException {
		paginaDeLogin.fazerLogin(usuario.getEmail(), "");
		paginaDeLogin.clica(BOTAO_LOGIN);
		Thread.sleep(2000);
		 assertAll("teste",
					()-> assertTrue(this.paginaDeCadastro.isPaginaAtual()), 
					()-> assertEquals("É campo obrigatório",this.paginaDeCadastro.verificaMensagem(MENSAGEM_LOGIN_SENHA))
	        );
		
	}
	@Test
	public void fazerLoginComCampoEmailVazio() throws InterruptedException {
		paginaDeLogin.fazerLogin("", usuario.getSenha());
		paginaDeLogin.clica(BOTAO_LOGIN);
		Thread.sleep(2000);
		 assertAll("teste",
					()-> assertTrue(this.paginaDeCadastro.isPaginaAtual()), 
					()-> assertEquals("É campo obrigatório",this.paginaDeCadastro.verificaMensagem(MENSAGEM_LOGIN_EMAIL))
	        );
		
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}

}
