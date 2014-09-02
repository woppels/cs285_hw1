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
        
        // Iterate through all possible times (hours, minutes, seconds)
        // I switched from byte i => int i because I am not sure how java increments byte variables
        for(int i = 0; i <= 24; i++) 
        {
      	  for(int j = 0; j <= 60; j++)
      	  {
      		  for(int k = 0; k <= 60; k++)
      		  {
      			  key[0] = (byte) i; key[1] = (byte) j; key[2] = (byte) k;
      			  
      			  // Check that the range of keys printed is: 0-24,0-60,0-60
      			  //for(int y = 0; y < 3; y++) System.out.print(key[y]+" ");
      			  //System.out.println();
      			  
      			  // Initialize rest of the key based on the first three bytes. 
      			  for(int x = 3; x < 16; x++) { key[x] = (byte)(key[x - 1] ^ key[x - 3]); }
      		      // Decrypt using the time of day guessed.
      			  boolean check = true;
      			  byte[] plainText = decrypt(cipherText, key);
      		      for (int z = 0; z < plainText.length; z++)
      		      {
      		    	  if(isAsciiPrintable(plainText[z]) == false) { check = false; }
      		      }
      		      
      		      // Only print if all values are valid ascii
      			  if(check) 
      			  { 
      				  for(int y = 0; y < 3; y++) System.out.print(key[y]+" ");
      				  System.out.println("Plaintext: " + new String(plainText, "UTF-8") + "\n");
      			  } 
      		      
      		  }
      	  }
        }
        System.out.println("Done.");
                
      } catch (Exception e) {
        e.printStackTrace();
      } 
    }
  }
