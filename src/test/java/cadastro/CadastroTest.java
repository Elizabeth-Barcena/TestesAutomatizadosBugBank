package cadastro;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dataFactory.DynamicFactory;
import login.LoginPage;
import model.Cadastro;
import static constants.EndpointsCadastro.*;
import static constants.EndpointsLogin.BOTAO_LOGIN;

public class CadastroTest{
	 private CadastroPage paginaDeCadastro;
	 private LoginPage paginaDeLogin;
	 Cadastro usuario;
	
	@BeforeEach
	public void beforeEach() {
		this.paginaDeCadastro = new CadastroPage();
		
	}

	@Test
    public void criarUsuarioComTodosOsCamposValidos() throws InterruptedException {
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getSenha(), usuario.getConfirmaSenha());
		Thread.sleep(2000);
		paginaDeCadastro.clica(TOGGLE_CADASTRO);
		Thread.sleep(2000);
		paginaDeCadastro.clica(BOTAO_CADASTRAR);
		paginaDeCadastro.clica(FECHAR_MODAL_CADASTRO);
		 
		Assertions.assertTrue(this.paginaDeCadastro.isPaginaAtual()); 
	}
	@Test
    public void criarUsuarioComCampoEmailVazio(){
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario("", usuario.getNome(), usuario.getSenha(), usuario.getConfirmaSenha());
		
		 assertAll("teste",
				 ()-> assertTrue(this.paginaDeCadastro.isPaginaAtual()),
				 ()-> assertEquals("Email não pode ser vazio",this.paginaDeCadastro.verificaMensagem(MENSAGEM_EMAIL_CADASTRO))
				);
	}
	@Test
    public void criarUsuarioComCampoNomeVazio()throws InterruptedException{
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), "", usuario.getSenha(), usuario.getConfirmaSenha());
		paginaDeCadastro.clica(BOTAO_CADASTRAR);
		Thread.sleep(1000);
		
		 assertAll("teste",
				()-> assertTrue(this.paginaDeCadastro.isPaginaAtual()), 
				()-> assertEquals("Nome não pode ser vazio.",this.paginaDeCadastro.verificaMensagem(MENSAGEM_NOME_CADASTRO))
        );
	}
	@Test
    public void criarUsuarioComCampoSenhaVazio()throws InterruptedException{
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), usuario.getNome(), "", usuario.getConfirmaSenha());
		paginaDeCadastro.clica(BOTAO_CADASTRAR);
		Thread.sleep(1000);
		 assertAll("teste",
				 ()->assertTrue(this.paginaDeCadastro.isPaginaAtual()), 
				 ()->assertEquals("Senha não pode ser vazio.",this.paginaDeCadastro.verificaMensagem(MENSAGEM_SENHA_CADASTRO))
				 );
	}
	@Test
    public void criarUsuarioComCampoConfirmaçãoDeSenhaVazio()throws InterruptedException{
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getSenha(), "");
		paginaDeCadastro.clica(BOTAO_CADASTRAR);
		Thread.sleep(1000);
		 assertAll("teste",
				 ()->assertTrue(this.paginaDeCadastro.isPaginaAtual()), 
				 ()->assertEquals("Confirmação de senha não pode ser vazio.",this.paginaDeCadastro.verificaMensagem(MENSAGEM_CONFIRMACAO_SENHA))
				 );
	}
	@Test
    public void criarUsuarioComCampoEmailInvalido()throws InterruptedException{
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario("teste", usuario.getNome(), usuario.getSenha(), usuario.getConfirmaSenha());
		paginaDeCadastro.clica(BOTAO_CADASTRAR);
		Thread.sleep(1000);
		
		 assertAll("teste",
				 ()->assertTrue(this.paginaDeCadastro.isPaginaAtual()), 
				 ()->assertEquals("Formato inválido",this.paginaDeCadastro.verificaMensagem(MENSAGEM_FORMATO_INVALIDO))
				 );
	}
	@Test
    public void criarUsuarioComSenhaDiferentes()throws InterruptedException{
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getSenha(), "senhadiferente");
		paginaDeCadastro.clica(BOTAO_CADASTRAR);
		Thread.sleep(1000);
		
		 assertAll("teste",
				 ()->assertTrue(this.paginaDeCadastro.isPaginaAtual()), 
				 ()->assertEquals("As senhas não são iguais.",this.paginaDeCadastro.verificaMensagem(MENSAGEM_SENHAS_IGUAIS))
				 );
	}
	
	@Test
	public void criarUsuarioQueJaExiste()throws InterruptedException {
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getSenha(), usuario.getConfirmaSenha());
		paginaDeCadastro.clica(BOTAO_CADASTRAR);
		paginaDeCadastro.clica(FECHAR_MODAL_CADASTRO);
		Thread.sleep(1000);
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.clica(BOTAO_CADASTRAR);
		Thread.sleep(1000);
		Assertions.assertEquals("Esse usuário já existe",this.paginaDeCadastro.verificaMensagem(MENSAGEM_CADASTRO));
	}
	@Test
    public void criarUsuarioComSaldo() throws InterruptedException{
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getSenha(), usuario.getConfirmaSenha());
		Thread.sleep(1000);
		paginaDeCadastro.clica(TOGGLE_CADASTRO);
		Thread.sleep(2000);
		this.paginaDeLogin = paginaDeCadastro.realizaCadastro(BOTAO_CADASTRAR);
		Thread.sleep(2000);
		paginaDeCadastro.clica(FECHAR_MODAL_CADASTRO);
		paginaDeLogin.fazerLogin(usuario.getEmail(), usuario.getSenha());
		paginaDeLogin.clica(BOTAO_LOGIN);
		Thread.sleep(2000);
		Assertions.assertEquals("R$ 1.000,00",this.paginaDeCadastro.verificaMensagem(SALDO_DA_CONTA));
	}
	@Test
    public void criarUsuarioSemSaldo() throws InterruptedException{
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getSenha(), usuario.getConfirmaSenha());
		Thread.sleep(2000);
		this.paginaDeLogin = paginaDeCadastro.realizaCadastro(BOTAO_CADASTRAR);
		Thread.sleep(2000);
		paginaDeCadastro.clica(FECHAR_MODAL_CADASTRO);
		paginaDeLogin.fazerLogin(usuario.getEmail(), usuario.getSenha());
		paginaDeLogin.clica(BOTAO_LOGIN);
		Thread.sleep(2000);
		Assertions.assertEquals("R$ 0,00",this.paginaDeCadastro.verificaMensagem(SALDO_DA_CONTA));
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeCadastro.fechar();
	}

}
