/*
Kasun De Zoysa @ UCSC
*/
import java.io.*;
import java.util.*;

public class birthdayAttck{

  public static void main(String args[]) {  
  Random rand = new Random();
  int n;
  //for (int t = 0; t < 10; t++) {
   Set<Integer> b = new HashSet<Integer>();
   while (true) {
        n = rand.nextInt(365);
        if (!b.add(n)) break;
    }
    System.out.println("SET->"+b);
    System.out.println("Birthbday->"+n+" Size->"+b.size());
 // }
}
}
