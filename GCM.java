/*

Kasun De Zoysa @ UCSC
*/
import java.io.*;
import java.security.*;
import javax.crypto.*;
import java.util.Formatter;
import javax.crypto.spec.*;

public class GCM{

    public static void main(String[]    args) throws Exception {
       String msg= "Hello123";
       byte[] input =msg.getBytes();
       byte[] aadData = "10.4.5.6".getBytes() ;


//Generate a key
   KeyGenerator    generator = KeyGenerator.getInstance("AES");
   generator.init(256);
   Key key = generator.generateKey();
 
//Set a IV
   byte iv[] = new byte[16];
   SecureRandom secRandom = new SecureRandom() ;
   secRandom.nextBytes(iv);
   GCMParameterSpec ivSpec = new GCMParameterSpec(128, iv) ;

// encryption pass
     Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
     cipher.init(Cipher.ENCRYPT_MODE, key,ivSpec);
     cipher.updateAAD(aadData) ;
     byte[] cipherText = cipher.doFinal(input);

 System.out.println("Cipher text length: " +cipherText.length);
 System.out.println("Cipher text: " +byteArray2Hex(cipherText));

 // decryption pass
    cipher.init(Cipher.DECRYPT_MODE, key,ivSpec);
    cipher.updateAAD(aadData) ;
    byte[] plainText= cipher.doFinal(cipherText);

    System.out.println("Plain text length: "+plainText.length);
    String s= new String(plainText);
    System.out.println("plain text: " + s);

    }


   private static String byteArray2Hex(byte[] data) {
     Formatter formatter = new Formatter();
     for (byte b : data) formatter.format("%02x", b);
     return formatter.toString();
  }
}
