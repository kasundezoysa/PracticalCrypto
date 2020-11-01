/*
Kasun De Zoysa @ UCSC
*/
import java.io.*;
import java.security.*;
import javax.crypto.*;
import java.util.Formatter;


public class ECB{

    public static void main(String[]    args) throws Exception {
       String msg= "Hello123hello123";
       byte[] input =msg.getBytes();


 //Generate a key
 KeyGenerator    generator = KeyGenerator.getInstance("AES");
 generator.init(128);
 Key key = generator.generateKey();


        // encryption pass
 Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
     cipher.init(Cipher.ENCRYPT_MODE, key);
     byte[] cipherText = cipher.doFinal(input);

 System.out.println("Cipher text length: " +cipherText.length);
 System.out.println("Cipher text: " +byteArray2Hex(cipherText));

 // decryption pass
    cipher.init(Cipher.DECRYPT_MODE, key);
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
