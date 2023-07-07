package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Cadastro{
	public String email;
	public String nome;
	public String senha;
	public String confirmaSenha;
	public Conta conta;
	
}
