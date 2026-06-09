import org.mindrot.jbcrypt.BCrypt;

public class GenerateHash {

    public static void main(String[] args) {

        String password = "00";

        String hash = BCrypt.hashpw(password, BCrypt.gensalt());

        System.out.println(hash);
    }
}

//00=$2a$10$kRFgc1bnaAe7sQ68lzsQTeeLAXXAo0PS.LHDaZ24zwCxk4g4uFtmC