import java.security.SecureRandom;
import java.util.Random;

public class GenerateRandomUsernameAndPassword {
    public static void main(String[] args) throws IllegalAccessException {
        generateRandomPassword(20);
        generateRandomPwd(20);
    }

    static void generateRandomPassword(int length) {
        String pwd = new Random().ints(10, 33, 122)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(pwd);
    }

    static String generateRandomPwd(int length) throws IllegalAccessException {
        if(length <= 0) {
            throw new IllegalAccessException("Password length must be a positive number");
        }

        SecureRandom random = new SecureRandom();
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String digits = "0123456789";
        String alphanum = upper + lower + digits;

        String password = random.ints(length, 0, alphanum.length())
                .mapToObj(alphanum::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        System.out.println(password);
        return password;
    }
}
