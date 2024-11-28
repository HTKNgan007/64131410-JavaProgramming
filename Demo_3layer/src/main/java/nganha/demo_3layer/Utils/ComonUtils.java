package nganha.demo_3layer.Utils;

import nganha.demo_3layer.Model_DTO.NhanVien;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static nganha.demo_3layer.Utils.DSUtils.DBConnect;

public class ComonUtils {
  public static String hashPassword(String password) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
      return bytesToHex(encodedHash);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Error: SHA-256 algorithm not found.", e);
    }
  }

  // Chuyển byte array sang chuỗi hex
  private static String bytesToHex(byte[] bytes) {
    StringBuilder hexString = new StringBuilder();
    for (byte b : bytes) {
      String hex = Integer.toHexString(0xff & b);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }
    return hexString.toString();
  }

}
