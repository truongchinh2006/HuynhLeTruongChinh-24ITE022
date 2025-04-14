public interface CryptoProcessor {
    String encode(String plainText) throws Exception;
    String decode(String cipherText) throws Exception;
}
