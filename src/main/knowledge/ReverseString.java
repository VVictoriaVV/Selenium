public class ReverseString {
    public static void main(String[] args) {
        String originalString = "Hello, Selenium!";

        // Reverse the string using a for loop
        //  String reversedString = "";
        for (int i = originalString.length() - 1; i >= 0; i--) {
            //  reversedString +=
            System.out.println(originalString.charAt(i));  // Append each character from the end to the beginning
        }

        // Print the reversed string (for debugging purposes
       // System.out.println("Reversed String: " + reversedString);
    }
    public void getReverseWord(){
        String originalString = "Viktoria";

        // Reverse the string using a for loop
        String reversedString = "";
        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString += originalString.charAt(i);  // Append each character from the end to the beginning
        }

        // Print the reversed string (for debugging purposes)
        System.out.println("Reversed String: " + reversedString);  // Expected output: "airotkiV"
    }
    public void getReverseWordByBuilder(){
        // String to reverse
        String originalString = "Hello, Selenium!";

        // Reverse the string using StringBuilder (or you can use any other method)
        String reversedString = new StringBuilder(originalString).reverse().toString();

        // Print the reversed string (for debugging purposes)
        System.out.println("Reversed String: " + reversedString);
    }
}
