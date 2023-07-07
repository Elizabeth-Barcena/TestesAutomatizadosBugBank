package extrato;

import static constants.EndpointTransferencia.BOTAO_TRANSFERENCIA;
import static constants.EndpointsCadastro.*;
import static constants.EndpointsLogin.BOTAO_LOGIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cadastro.CadastroPage;
import dataFactory.DynamicFactory;
import home.HomePage;
import login.LoginPage;
import model.Cadastro;
import model.Conta;
import extrato.ExtratoPage;

import transferencia.TransferenciaPage;
import static constants.EndpointExtrato.*;
public class ExtratoTest {
	private CadastroPage paginaDeCadastro;
	Cadastro usuario;
	Cadastro usuario2;
	Conta conta = new Conta();
	private LoginPage paginaDeLogin; 
	private HomePage paginaHome;
	private TransferenciaPage paginaDeTransferencia;
	private ExtratoPage paginaDeExtrato;
	@BeforeEach
	public void beforeEach() throws InterruptedException {
		this.paginaDeCadastro = new CadastroPage();
		usuario = DynamicFactory.gerarUser();
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		paginaDeCadastro.cadastrarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getSenha(), usuario.getConfirmaSenha());
		Thread.sleep(1000);
		paginaDeCadastro.clica(TOGGLE_CADASTRO);
		Thread.sleep(2000);
		this.paginaDeLogin= paginaDeCadastro.realizaCadastro(BOTAO_CADASTRAR);
		Thread.sleep(2000);
		
		conta.setNumeroDaConta(paginaDeCadastro.retornarNumeroConta(MENSAGEM_CADASTRO)); 
		conta.setDigito(paginaDeCadastro.retornarDigitoConta(MENSAGEM_CADASTRO));
		usuario.setConta(conta);
		System.out.println(usuario);
		Thread.sleep(2000);
		paginaDeCadastro.clica(FECHAR_MODAL_CADASTRO);
		paginaDeCadastro.clica(BOTAO_REGISTRAR);
		Thread.sleep(2000);
		
		paginaDeCadastro.limparCampos();
		Thread.sleep(2000);
		
		usuario2 = DynamicFactory.gerarUser();
		paginaDeCadastro.cadastrarUsuario(usuario2.getEmail(), usuario2.getNome(), usuario2.getSenha(), usuario2.getConfirmaSenha());
		this.paginaDeLogin= paginaDeCadastro.realizaCadastro(BOTAO_CADASTRAR);
		Thread.sleep(2000);
		
		conta.setNumeroDaConta(paginaDeCadastro.retornarNumeroConta(MENSAGEM_CADASTRO)); 
		conta.setDigito(paginaDeCadastro.retornarDigitoConta(MENSAGEM_CADASTRO));
		usuario2.setConta(conta);
		System.out.println(usuario2);
		
		Thread.sleep(1000);
		
		paginaDeCadastro.clica(FECHAR_MODAL_CADASTRO);
		paginaDeLogin.fazerLogin(usuario2.getEmail(), usuario2.getSenha());
		this.paginaHome = paginaDeLogin.realizaLogin(BOTAO_LOGIN);
		Thread.sleep(2000);
		this.paginaDeExtrato = paginaHome.mostraExtrato(BOTAO_EXTRATO);
	}
	@Test
	public void verificaSaldo() {
		Assertions.assertEquals("R$ 1.000,00",this.paginaDeExtrato.verificaMensagem(SALDO));
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeCadastro.fechar();
	}
}
