package constants;

public class EndpointTransferencia {
	public static final String BOTAO_TRANSFERENCIA= "//*[@id=\"btn-TRANSFERÊNCIA\"]";
	public static final String NUMERO_DA_CONTA = "//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[1]/input";
	public static final String DIGITO_CONTA ="//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[2]/input";
	public static final String VALOR_DA_TRANSFERENCIA="//*[@id=\"__next\"]/div/div[3]/form/div[2]/input";
	public static final String DESCRIÇÃO = "//*[@id=\"__next\"]/div/div[3]/form/div[3]/input";
	public static final String BOTAO_TRANSFERIR="//*[@id=\"__next\"]/div/div[3]/form/button";
	public static final String BOTAO_VOLTAR ="//*[@id=\"btnBack\"]";
	public static final String BOTAO_SAIR="//*[@id=\"btnExit\"]";
	public static final String URL_TRANSFERENCIA ="https://bugbank.netlify.app/transfer";
	public static final String URL_EXTRATO = "https://bugbank.netlify.app/bank-statement";
	public static final String MENSAGEM_TRANSFERENCIA= "/html/body/div/div/div[5]/div/div[2]/p";
	public static final String FECHAR_MOD="//*[@id=\"btnCloseModal\"]";
}
