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

  public static boolean isAsciiPrintable(byte ch) {
      return ch > 31 && ch < 127;
  }
  public static void main(String [] args) {
    try {
      byte[] key = new byte[16];
      
      for(byte i = -11; i < 13; i++)
      {
    	  for(byte j = 0; j < 60; j++)
    	  {
    		  for(byte k = 0; k < 60; k++)
    		  {
    			  key[0] = i; key[1] = j; key[2] = k;
    			  for(int x = 3; x < 16; x++) { key[x] = (byte)(key[x - 1] ^ key[x - 3]); }
    			  boolean check = true; 
    		      byte[] plainText = decrypt(cipherText, key);
    		      for(int y = 0; y < plainText.length; y++) 
    		      {
    		    	  if(isAsciiPrintable(plainText[y]) == false) { check = false; }
    		      }
    		      if(check)
    		      {
    		    	  System.out.println(new String(plainText, "UTF-8"));
    		    	  System.out.println();
    		      }
    		  }
    	  }
      }
        
      if(isAsciiPrintable(cipherText[0]) == true) System.out.println("hello");
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
