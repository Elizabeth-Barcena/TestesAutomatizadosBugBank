package dataFactory;
import model.Login;
import com.github.javafaker.Faker;

import java.util.Locale;

public class DynamicFactory {
    private static Faker faker = new Faker(Locale.ENGLISH);

    public static Login gerarUser() {

        Login accountUser = new Login();
        accountUser.setUserName(faker.name().fullName());
        accountUser.setPassword("12345*Abcd");

        return accountUser;
    }
}
