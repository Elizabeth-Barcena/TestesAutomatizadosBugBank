package dataFactory;

import java.util.Locale;

import com.github.javafaker.Faker;

import model.Cadastro;

public class DynamicFactory {
	private static Faker faker = new Faker(Locale.ENGLISH);

	public static Cadastro gerarUser() {

		Cadastro cadastro = new Cadastro();

		cadastro.setEmail(faker.internet().emailAddress());
		cadastro.setNome(faker.name().fullName());
		cadastro.setSenha("12345*Abcd");
		cadastro.setConfirmaSenha("12345*Abcd");
		System.out.println(cadastro);
		return cadastro;
	}
}
