package home;

import static constants.EndpointsCadastro.*;
import static constants.EndpointsLogin.*;
import static constants.EndpointsHome.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cadastro.CadastroPage;
import dataFactory.DynamicFactory;
import login.LoginPage;
import model.Cadastro;


public class HomeTest {
	private CadastroPage paginaDeCadastro;

	Cadastro usuario;
	private LoginPage paginaDeLogin;
	private HomePage paginaHome;
	String numeroConta;
	String saldo;
	@BeforeEach
	public void beforeEach() throws InterruptedException {
		this.paginaDeCadastro = new CadastroPage();
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getSenha(), usuario.getConfirmaSenha());
		this.paginaDeLogin= paginaDeCadastro.realizaCadastro(BOTAO_CADASTRAR);
		Thread.sleep(2000);
		numeroConta = paginaDeCadastro.verificaMensagem(NUMERO_CONTA_CADASTRO);
		numeroConta = numeroConta.replaceAll("A conta ", "");
		numeroConta = numeroConta.replaceAll(" foi criada com sucesso", "");
		paginaDeCadastro.clica(FECHAR_MODAL_CADASTRO);
		Thread.sleep(2000);
		paginaDeLogin.fazerLogin(usuario.getEmail(), usuario.getSenha());
		this.paginaHome = paginaDeLogin.realizaLogin(BOTAO_LOGIN);
		Thread.sleep(2000);
		saldo = paginaHome.verificaMensagem(SALDO);
	}
	@Test
	public void testarBotaoDeExtrato() throws InterruptedException {
		paginaHome.clica(BOTAO_EXTRATO);
		Thread.sleep(1000);
		Assertions.assertTrue(this.paginaHome.isPaginaDeExtrato());
	}
	@Test
	public void testarBotaoDeTransferencia() throws InterruptedException {
		paginaHome.clica(BOTAO_TRANSFERENCIA_HOME);
		Thread.sleep(1000);
		Assertions.assertTrue(this.paginaHome.isPaginaDeTransferencia());
	}
	@Test
	public void testarBotaoDeLogout() throws InterruptedException {
		paginaHome.clica(BOTAO_SAIR);
		Thread.sleep(1000);
		Assertions.assertTrue(this.paginaHome.isPaginaDeLogin());
	}
	@Test
	public void testarNomeDoUsuario() throws InterruptedException {
		String nome = this.paginaHome.verificaMensagem(NOME_USUARIO);
		nome = nome.replaceAll("Olá ", "");
		nome = nome.replaceAll(",", "");
		
		Thread.sleep(1000);
		Assertions.assertEquals(usuario.getNome(),nome);
	}
	@Test
	public void testarNumeroDaConta() throws InterruptedException {
		String conta = this.paginaHome.verificaMensagem(NUMERO_DA_CONTA);
		
		Thread.sleep(1000);
		Assertions.assertEquals(numeroConta,conta);
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}
	

}
