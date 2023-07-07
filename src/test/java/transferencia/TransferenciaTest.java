package transferencia;

import static constants.EndpointsCadastro.*;

import static constants.EndpointsLogin.*;
import static constants.EndpointTransferencia.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

public class TransferenciaTest {
	private CadastroPage paginaDeCadastro;
	Cadastro usuario;
	Cadastro usuario2;
	Conta conta = new Conta();
	private LoginPage paginaDeLogin; 
	private HomePage paginaHome;
	private TransferenciaPage paginaDeTransferencia;
	
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
		this.paginaDeTransferencia = paginaHome.realizaTransferencia(BOTAO_TRANSFERENCIA);
	}
	@Test
	public void fazerTranferenciaComCamposValidos() {
		paginaDeTransferencia.fazerTranferencia( usuario.conta.getDigito(), usuario.conta.getDigito(),"100", "Conta paga" );
		paginaDeTransferencia.clica(BOTAO_TRANSFERIR);
		Assertions.assertTrue(this.paginaDeTransferencia.isPaginaExtrato()); 
	}
	@Test
	public void fazerTranferenciaComContaInvalida() throws InterruptedException {
		paginaDeTransferencia.fazerTranferencia("123456","1", "100", "Conta paga" );
		paginaDeTransferencia.clica(BOTAO_TRANSFERIR);
		Thread.sleep(3000);
		String msg =paginaDeTransferencia.verificaMensagem(MENSAGEM_TRANSFERENCIA);
		paginaDeTransferencia.clica(FECHAR_MOD);
		assertAll("teste",
				 ()-> assertTrue(this.paginaDeTransferencia.isPaginaAtual()),
				 ()-> assertEquals("Conta inválida ou inexistente",msg)
				);
	}
	@Test
	public void fazerTranferenciaComValor0() throws InterruptedException {
		paginaDeTransferencia.fazerTranferencia(usuario.conta.getDigito(), usuario.conta.getDigito(), "0", "Conta paga" );
		paginaDeTransferencia.clica(BOTAO_TRANSFERIR);
		Thread.sleep(3000);
		String msg =paginaDeTransferencia.verificaMensagem(MENSAGEM_TRANSFERENCIA);
		paginaDeTransferencia.clica(FECHAR_MOD);
		assertAll("teste",
				 ()-> assertTrue(this.paginaDeTransferencia.isPaginaAtual()),
				 ()-> assertEquals("Valor da transferência não pode ser 0 ou negativo",msg)
				);
	}
	@Test
	public void fazerTranferenciaComValorMaiorQueSaldoEmConta() throws InterruptedException {
		paginaDeTransferencia.fazerTranferencia(usuario.conta.getDigito(), usuario.conta.getDigito(), "1500", "Conta paga" );
		paginaDeTransferencia.clica(BOTAO_TRANSFERIR);
		Thread.sleep(3000);
		String msg =paginaDeTransferencia.verificaMensagem(MENSAGEM_TRANSFERENCIA);
		paginaDeTransferencia.clica(FECHAR_MOD);
		assertAll("teste",
				 ()-> assertTrue(this.paginaDeTransferencia.isPaginaAtual()),
				 ()-> assertEquals("Você não tem saldo suficiente para essa transação",msg)
				);
	}
	@Test
	public void fazerTranferenciaParaMesmaConta() throws InterruptedException {
		paginaDeTransferencia.fazerTranferencia(usuario2.conta.getDigito(), usuario2.conta.getDigito(), "100", "Conta paga" );
		paginaDeTransferencia.clica(BOTAO_TRANSFERIR);
		Thread.sleep(3000);
		String msg =paginaDeTransferencia.verificaMensagem(MENSAGEM_TRANSFERENCIA);
		paginaDeTransferencia.clica(FECHAR_MOD);
		assertAll("teste",
				 ()-> assertTrue(this.paginaDeTransferencia.isPaginaAtual()),
				 ()-> assertEquals("Nao pode transferir pra mesma conta",msg)
				);
	}
	@Test
	public void fazerTranferenciaUtilizandoLetra() throws InterruptedException {
		paginaDeTransferencia.fazerTranferencia(usuario2.conta.getDigito()+"a", usuario.conta.getDigito(), "100", "Conta paga" );
		paginaDeTransferencia.clica(BOTAO_TRANSFERIR);
		Thread.sleep(3000);
		String msg =paginaDeTransferencia.verificaMensagem(MENSAGEM_TRANSFERENCIA);
		paginaDeTransferencia.clica(FECHAR_MOD);
		assertAll("teste",
				 ()-> assertTrue(this.paginaDeTransferencia.isPaginaAtual()),
				 ()-> assertEquals("Conta inválida ou inexistente",msg)
				);
	}
	@Test
	public void fazerTranferenciaComCampoDescriçãoVazio() throws InterruptedException {
		paginaDeTransferencia.fazerTranferencia(usuario2.conta.getDigito(), usuario.conta.getDigito(), "100", "" );
		paginaDeTransferencia.clica(BOTAO_TRANSFERIR);
		Thread.sleep(3000);
		String msg =paginaDeTransferencia.verificaMensagem(MENSAGEM_TRANSFERENCIA);
		paginaDeTransferencia.clica(FECHAR_MOD);
		assertAll("teste",
				 ()-> assertTrue(this.paginaDeTransferencia.isPaginaAtual()),
				 ()-> assertEquals("Descrição é campo obrigatório",msg)
				);
	}
	@Test
	public void fazerTranferenciaComCampoNumeroDaContaEmBranco() throws InterruptedException {
		paginaDeTransferencia.fazerTranferencia("", usuario.conta.getDigito(), "100", "Conta paga" );
		paginaDeTransferencia.clica(BOTAO_TRANSFERIR);
		Thread.sleep(3000);
		String msg =paginaDeTransferencia.verificaMensagem(MENSAGEM_TRANSFERENCIA);
		paginaDeTransferencia.clica(FECHAR_MOD);
		assertAll("teste",
				 ()-> assertTrue(this.paginaDeTransferencia.isPaginaAtual()),
				 ()-> assertEquals("Número da conta precisa ser preenchido",msg)
				);
	}
	@Test
	public void fazerTranferenciaComCampoComDigitoEmBranco() throws InterruptedException {
		paginaDeTransferencia.fazerTranferencia(usuario2.conta.getDigito(), "", "100", "Conta paga" );
		paginaDeTransferencia.clica(BOTAO_TRANSFERIR);
		Thread.sleep(3000);
		String msg =paginaDeTransferencia.verificaMensagem(MENSAGEM_TRANSFERENCIA);
		paginaDeTransferencia.clica(FECHAR_MOD);
		assertAll("teste",
				 ()-> assertTrue(this.paginaDeTransferencia.isPaginaAtual()),
				 ()-> assertEquals("Digito precisa ser preenchido",msg)
				);
	}
	//Conta inválida ou inexistente
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}

}
