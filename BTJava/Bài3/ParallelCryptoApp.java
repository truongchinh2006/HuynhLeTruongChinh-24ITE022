public class ParallelCryptoApp {
    public static void main(String[] args) {
        String inputData = "Dữ liệu được xử lý song song!";

        try {
            AESHandler handler = new AESHandler();

            Thread threadEncrypt = new Thread(() -> {
                try {
                    String encoded = handler.encode(inputData);
                    System.out.println("[Mã hóa] Kết quả: " + encoded);

                    Thread threadDecrypt = new Thread(() -> {
                        try {
                            String decoded = handler.decode(encoded);
                            System.out.println("[Giải mã] Kết quả: " + decoded);
                        } catch (Exception e) {
                            System.err.println("[Giải mã] Lỗi: " + e.getMessage());
                        }
                    });

                    threadDecrypt.start();

                } catch (Exception e) {
                    System.err.println("[Mã hóa] Lỗi: " + e.getMessage());
                }
            });

            threadEncrypt.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
