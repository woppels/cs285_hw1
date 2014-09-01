import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class HW1_P2_EsparzaMichael {  
  private static final byte[] cipherText = 
		  new byte[] { 57, -2, 104, 88, 14, 37, -79, -73, 115, 62, 49, 89, -78, 5, -96, 99, 
	  				   -7, 38, 42, 104, 123, 14, 82, 74, -81, 44, 91, -51, -57, -95, 37, 106, 
	  				   -85, 23, 87, 57, -13, -7, 37, 120, 65, 39, 111, 110, -125, -37, 120, 39,  };
 
  public static byte[] decrypt(byte[] cipherBlocks, byte[] key) throws Exception{
    Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "SunJCE");
    SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
    cipher.init(Cipher.DECRYPT_MODE, keySpec);
    return cipher.doFinal(cipherBlocks);
  }

  public static void main(String [] args) {
    try {
      byte[] key = new byte[16];
      
      key[0] = 0; // such encryption, many combinations, so secure, wow!
      key[1] = 0;
      key[2] = 0;
      
      for (int i = 3; i < 16; i++)
        key[i] = (byte)(key[i - 1] ^ key[i - 3]); 
        
      byte[] plainText = decrypt(cipherText, key);
      System.out.println(new String(plainText, "UTF-8"));
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
