package org.example.hw1;

import java.util.Scanner;

/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.*
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 */


public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str = scanner.nextLine();
        String strOut = reverseWords(str);
        System.out.println(strOut);
    }

    private static String reverseWords(String str) {
        String res = "";
        String[] words = str.trim().replaceAll("\\s+", " ").split(" ");
        for (int i = words.length - 1; i > 0; i--) {
            res += words[i] + " ";
        }
        res += words[0];
        return res;
    }
}
