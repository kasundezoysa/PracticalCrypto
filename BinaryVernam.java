public class BinaryVernam{

public static void main(String args[]){
char plain[]={'K','A','S','U','N'};
char cipher[]=new char[5];
char key[]={10,25,33,44,56};
int i,p,c;

//Encryption
System.out.print("Encryption: ");
for(i=0;i<plain.length;i++){
 cipher[i]= (char) (plain[i]^key[i]);
 System.out.print(cipher[i]);
}

System.out.print("\nDecryption: ");

for(i=0;i<cipher.length;i++){
 p=cipher[i]^key[i];
 System.out.print((char)p);
}
System.out.println("");

}
}
