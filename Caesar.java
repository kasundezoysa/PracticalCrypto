//A Java Program to illustrate Caesar Cipher Technique
class Caesar{
	// Encrypts text using a shift od s
	public static StringBuffer encrypt(String text, int s) {
		StringBuffer result= new StringBuffer();
		char ch;
		for (int i=0; i<text.length(); i++) {
			if (Character.isUpperCase(text.charAt(i)))
				ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
			else
				ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);

			result.append(ch);
			
		}
		return result;
	}

	// Driver code
	public static void main(String[] args) {
		String text = "Hello KASUN";
		int s = 5;
		System.out.println("Text : " + text);
		System.out.println("Shift : " + s);
		System.out.println("Cipher: " + encrypt(text, s));
	}
}
