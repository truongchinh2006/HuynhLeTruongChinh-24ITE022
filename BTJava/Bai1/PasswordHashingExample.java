import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PasswordHashingExample {

    public static String hashWithMD5(String input) {
        return hashWithAlgorithm(input, "MD5");
    }

    public static String hashWithSHA256(String input) {
        return hashWithAlgorithm(input, "SHA-256");
    }

    private static String hashWithAlgorithm(String input, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] hashedBytes = md.digest(input.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Thuật toán không hỗ trợ: " + algorithm);
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        String md5Hashed = hashWithMD5(password);
        String sha256Hashed = hashWithSHA256(password);

        System.out.println("Mã hóa MD5: " + md5Hashed);
        System.out.println("Mã hóa SHA-256: " + sha256Hashed);
    }
}
