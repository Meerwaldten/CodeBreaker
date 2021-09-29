import java.util.Scanner;


public class Codebreaking {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String alphabet = "abcdefghijklmnopqrstuxwyzæøå";

    numberCypherEncoder("hej", alphabet);

    System.out.println(letterCypherEncoder(2, alphabet));
    //System.out.println(letterCypherEncoder(4, alphabet));
    letterCypherEncoder1(1,alphabet);

    }


    public static char letterCypherEncoder (int encoding, String alphabet){
        while (encoding < 0){
            encoding = encoding + alphabet.length();
        }
        char[] alphabetAsChars = alphabet.toCharArray();
        char encodedNumber = alphabetAsChars[encoding-1];
        return encodedNumber;
    }

    public static void letterCypherEncoder1 (int encoding1, String alphabet){

        for (int i = 0; i < alphabet.length(); i++) {
            System.out.println(letterCypherEncoder(encoding1, alphabet));
        }
    }


    // Laver en char om til en int. aka, bogstav til tal.
    public static int characterToNumber (char encoded, String alphabet){
       int encodedAsNumber = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            if (alphabet.charAt(i) == encoded){
                encodedAsNumber = i+1;
            }
        }
        return encodedAsNumber;
    }
    // bruger metoden over til at tage imod en string, for derefter at køre metoden på hver enkelt bogstav i din string og returnere et tal.
    public static void numberCypherEncoder (String toBeEncoded, String alphabet){
        char[] encodedChar = toBeEncoded.toCharArray();
        for (int i = 0; i < toBeEncoded.length(); i++) {
            System.out.println(characterToNumber(encodedChar[i], alphabet));
        }
    }

}
