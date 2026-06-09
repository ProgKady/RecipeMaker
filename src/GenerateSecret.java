import dev.samstevens.totp.secret.DefaultSecretGenerator;
import dev.samstevens.totp.secret.SecretGenerator;

public class GenerateSecret {

    public static void main(String[] args) {

        SecretGenerator generator =
                new DefaultSecretGenerator();

        String secret = generator.generate();

        System.out.println(secret);
    }
}

//JHED4OISOJYKP6B63GM2FQXLAFGG7ART