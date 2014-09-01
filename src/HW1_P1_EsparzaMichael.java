public class HW1_P1_EsparzaMichael {
  private static final String cipherText = "TVC TPCUEIPC YVCET KE JIPKCN VCPC:\n" +
    "EUKD RPWS EOCDCTWH KEDUHN TW TVC CUET-EWITVCUET.\n" +
    "URTCP TMW NUQE, QWI MKDD RKHN U NCECPTCN KEDUHN.\n" +
    "YDKSJ TW TVC VKGVCET LWKHT WR TVC KEDUHN UHN DWWO RWP U DUPGC YDKRR TW TVC HWPTV.\n" +
    "MUDO U VIHNPCN QUPNE TWMUPNE TVC YDKRR UHN ETWL UT TVC TUDD TPCC.\n" +
    "MUDO TCH RCCT TW TVC CUET, UHN QWI MKDD RKHN U PWYO MKTV UH B LUKHTCN WH KT.\n" +
    "TVC TPCUEIPC KE JIPKCN WHC RWWT JCDWM TVC PWYO.\n";
  
  static final int alphaIndex = (int) 'A';
  static final int alphaLength = (int) 'Z' + 1 - (int) 'A';
  
  private static char decrypt(char cipher) {
    int index = (int) cipher - alphaIndex;
    // ... decrypt ...
    // There is a scan of my handwritten work in the .zip file. 
    int temp = (7 * index - 10) % alphaLength;
    return (char) (temp + alphaIndex);
  }
  
  public static void main(String [] args) {
    for (char cipher : cipherText.toCharArray())
      if (Character.isLetter(cipher))
        System.out.print(decrypt(cipher));
      else
        System.out.print(cipher);
  }  
}
