package org.example.zadania_rekrutacyjne;

public class IsPalindromeDemo {
    public static void main(String[] args) {
        String input1 = "oko";
        String input2 = "amam";
        String input3 = "";
        String input4 = "am am";
        String input5 = "o k o";
        String input6 = "1111";

        boolean isPalindrome1 = isPalindrome(input1);
        boolean isPalindrome2 = isPalindrome(input2);
        boolean isPalindrome3 = isPalindrome(input3);
        boolean isPalindrome4 = isPalindrome(input4);
        boolean isPalindrome5 = isPalindrome(input5);
        boolean isPalindrome6 = isPalindrome(input6);

        System.out.println(isPalindrome1);
        System.out.println(isPalindrome2);
        System.out.println(isPalindrome3);
        System.out.println(isPalindrome4);
        System.out.println(isPalindrome5);
        System.out.println(isPalindrome6);
    }

    private static boolean isPalindrome(String input) {
        String reversedInput = new StringBuilder(input).reverse().toString();
        if (reversedInput.equals(input)) {
            return true;
        } else {
            return false;
        }
    }
}
