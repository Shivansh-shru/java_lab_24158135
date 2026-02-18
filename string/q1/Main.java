import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String:");
        String str = sc.nextLine();

        String changedCase = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch))
                changedCase += Character.toLowerCase(ch);
            else
                changedCase += Character.toUpperCase(ch);
        }
        System.out.println("The string after changing the case is " + changedCase);

        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        System.out.println("The string after reversing is " + reversed);

        System.out.println("Enter the second string for comparison:");
        String str2 = sc.nextLine();
        int diff = str.compareTo(str2);
        System.out.println("The difference between ASCII value is " + diff);

        System.out.println("Enter the string to be inserted into first string:");
        String insert = sc.nextLine();
        String combined = str + " " + insert;
        System.out.println("The string after insertion is : " + combined);

        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());

        System.out.println("Enter a character:");
        char ch = sc.next().charAt(0);
        int pos = str.indexOf(ch);
        if (pos >= 0)
            System.out.println("Position of entered character: " + pos);
        else
            System.out.println("Entered character is not present");

        String check = str.replaceAll(" ", "");
        String rev = "";
        for (int i = check.length() - 1; i >= 0; i--) {
            rev += check.charAt(i);
        }
        if (check.equalsIgnoreCase(rev))
            System.out.println("Entered string is palindrome");
        else
            System.out.println("Entered string is not a palindrome");

        int words = 0, vowels = 0, consonants = 0;
        String lower = str.toLowerCase();

        String[] wordArray = lower.trim().split("\\s+");
        if (str.trim().length() != 0)
            words = wordArray.length;

        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    vowels++;
                else
                    consonants++;
            }
        }

        System.out.println("No. of words: " + words);
        System.out.println("No. of vowels: " + vowels);
        System.out.println("No. of consonants: " + consonants);
    }
}
