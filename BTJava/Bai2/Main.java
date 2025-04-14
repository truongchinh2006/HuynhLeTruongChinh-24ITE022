public class Main {
    public static void main(String[] args) {
        try {
            String message = "Hello, Java Encryption!";

            System.out.println("----- AES -----");
            Encryptable aes = new AESEncryption();
            String aesEncrypted = aes.encrypt(message);
            String aesDecrypted = aes.decrypt(aesEncrypted);
            System.out.println("Mã hóa: " + aesEncrypted);
            System.out.println("Giải mã: " + aesDecrypted);

            System.out.println("\n----- RSA -----");
            Encryptable rsa = new RSAEncryption();
            String rsaEncrypted = rsa.encrypt(message);
            String rsaDecrypted = rsa.decrypt(rsaEncrypted);
            System.out.println("Mã hóa: " + rsaEncrypted);
            System.out.println("Giải mã: " + rsaDecrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
