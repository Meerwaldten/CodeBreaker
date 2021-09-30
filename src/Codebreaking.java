import java.util.Locale;
import java.util.Scanner;


public class Codebreaking {
    public static void main(String[] args) {
    String alphabet = "abcdefghijklmnopqrstuxwyzæøå";

    System.out.println(ceasarEncoder("hej"));
    System.out.println(ceasarEncoder("æøå"));
    System.out.println(ceasarDecoder("æøå"));
    System.out.println(ceasarDecoder("abc"));
    numberCypherEncoder("hej", alphabet);
    numberCypherEncoder("abc", alphabet);
    letterCypherEncoder();
    }

    // metode til at få input fra user.
    public static String getInputFromUser (){
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
    }
// encoder til cæsar, den shifter alle bogstaver 3 gange den ene vej.
    public static char[] ceasarEncoder (String toBeEncoded){
        int shift = 3; // hvor mange karaktere der shiftes / rykkes.
        String alphabet = "abcdefghijklmnopqrstuxwyzæøåabc"; // Tilføjede abc som det sidste, in case man ville encode æøå.
        String lowerCaseString = toBeEncoded.toLowerCase(Locale.ROOT); // Sætter det til små bogstaver så der
        char[] stringToCharArray = lowerCaseString.toCharArray();
        char[] encodedCharArray = new char [lowerCaseString.length()];
        for (int i = 0; i < lowerCaseString.length(); i++) {
            String charToEncode = stringToCharArray[i] + "";
            int indexOfCharToEncode = alphabet.indexOf(charToEncode);
            encodedCharArray[i] = alphabet.charAt(((indexOfCharToEncode)+shift)%alphabet.length());
            
        }
        return encodedCharArray;

    }

// decoder, som er samme metoder, men shifter alle bogstaver 3 gange den modsatte vej.
    public static char[] ceasarDecoder (String toBeEncoded){
        int shift = 3; // Stadig hvor mange gange vi rykker bogstavet.
        String alphabet = "abcdefghijklmnopqrstuxwyzæøå";
        String lowerCaseString = toBeEncoded.toLowerCase(Locale.ROOT);
        char[] stringToCharArray = lowerCaseString.toCharArray();
        char[] encodedCharArray = new char [lowerCaseString.length()];
        for (int i = 0; i < lowerCaseString.length(); i++) {
            String charToEncode = stringToCharArray[i] + "";
            int indexOfCharToEncode = alphabet.indexOf(charToEncode);
            int indexOfCharToBeDecoded = indexOfCharToEncode - shift;
            if (indexOfCharToBeDecoded < 0){ // if sætning for at forhindre vi får i minus, når vi fx skal encode a, b eller c.
                indexOfCharToBeDecoded += alphabet.length();
            }
            encodedCharArray[i] = alphabet.charAt((indexOfCharToBeDecoded)%alphabet.length());

        }
        return encodedCharArray;

    }

    // Laver tal til bogstaver :)))
    public static void letterCypherEncoder (){
        System.out.println();
        System.out.println("Please type in the numbers you want encoded in the format of '1,2,3,4,5'.");
        String stringToEncode = getInputFromUser(); // metode til at få en string.
        String[] arrayToEncode = stringToEncode.split(","); // sletter alle "," og laver et array.
        int arrayLength = arrayToEncode.length;
        int[] arrayEncoded = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arrayEncoded[i]=Integer.parseInt(arrayToEncode[i]);
        }
        System.out.println(numberToLetter(arrayEncoded));

    }
    // anden del af metoden til at lave tal til bogstaver.
    public static String numberToLetter (int[] arrayToBeEncoded){
        String alphabet = "abcdefghijklmnopqrstuxwyzæøå";
        String encodedCypher = "";
        for (int i = 0; i < arrayToBeEncoded.length; i++) {
            char encodedChars = alphabet.charAt(arrayToBeEncoded[i]-1); // -1 for at rette index som starter på 0.
            encodedCypher += encodedChars; // += bygger langsomt stringen op

        }
        return encodedCypher;
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
        Scanner scanner = new Scanner(System.in);
        char[] encodedChar = toBeEncoded.toCharArray();
        for (int i = 0; i < toBeEncoded.length(); i++) {
            System.out.printf(characterToNumber(encodedChar[i], alphabet)+";");
        }
        System.out.println("");
    }

}
