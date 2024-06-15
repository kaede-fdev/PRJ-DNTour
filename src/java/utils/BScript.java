package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class BScript {

    private static final int ITERATIONS = 10000; // Số lần lặp lại
    private static final int SALT_LENGTH = 16; // Độ dài của salt

    public static String hashPassword(String password) {
        try {
            // Tạo salt ngẫu nhiên
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);

            // Mã hóa mật khẩu với salt và số lần lặp lại
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedBytes = md.digest(password.getBytes());

            // Kết hợp salt và mật khẩu đã mã hóa thành một mảng byte
            byte[] combined = new byte[hashedBytes.length + salt.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hashedBytes, 0, combined, salt.length, hashedBytes.length);

            // Sử dụng Base64 để chuyển đổi mảng byte thành chuỗi String
            return Base64.getEncoder().encodeToString(combined);
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static boolean checkPassword(String originalPassword, String hashedPassword) {
        try {
            // Giải mã chuỗi đã mã hóa thành mảng byte
            byte[] combined = Base64.getDecoder().decode(hashedPassword);
            byte[] salt = new byte[SALT_LENGTH];
            byte[] hashedBytes = new byte[combined.length - SALT_LENGTH];
            System.arraycopy(combined, 0, salt, 0, SALT_LENGTH);
            System.arraycopy(combined, SALT_LENGTH, hashedBytes, 0, hashedBytes.length);

            // Mã hóa mật khẩu gốc với salt và số lần lặp lại
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] checkBytes = md.digest(originalPassword.getBytes());

            // So sánh mật khẩu đã mã hóa với mật khẩu gốc đã mã hóa
            for (int i = 0; i < hashedBytes.length; i++) {
                if (hashedBytes[i] != checkBytes[i]) {
                    return false;
                }
            }
            return true;
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
