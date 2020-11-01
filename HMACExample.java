/*
Kasun De Zoysa @ UCSC
*/
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

import java.util.*;


public class HMACExample{



public static void main(String args[]) {

 try {

    String key1 = "MIS@UCSC";
    SecretKeySpec sk1 = new SecretKeySpec(key1.getBytes(), "HMACSHA256");

    // Create a MAC object using HMAC-MD5 and initialize with key
    Mac mac1 = Mac.getInstance("HMACSHA256");
    mac1.init(sk1);


    String data1 = "Hello kasun";

    byte[] digest1 = mac1.doFinal(data1.getBytes());

    System.out.println("Orig. HMAC: ");
    for(byte b:digest1) System.out.format("%02x",b);
    System.out.println("");

    //Verification
    String key2 = "MIS@UCSC";
    SecretKeySpec sk2 = new SecretKeySpec(key2.getBytes(), "HMACSHA256");

    Mac mac2 = Mac.getInstance("HMACSHA256");
    mac2.init(sk2);
    
    String data2 = "Hello kasun";

    byte digest2[] = mac2.doFinal(data2.getBytes());


    System.out.println("New HMAC: ");
    for(byte b:digest2) System.out.format("%02x",b);
    System.out.println("");

    if(Arrays.equals(digest1,digest2)) 
     System.out.println("Digest Verified");

    else  
     System.out.println("Digest Verification failed!");



  } catch (Exception e) {

     System.out.println(e);

  }

 }

}

