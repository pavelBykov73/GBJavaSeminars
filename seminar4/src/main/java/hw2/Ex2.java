package hw2;

import java.util.*;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class Ex2 {
    private static HashMap<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        mapInit();
        String text1 = "()";
        String text2 = "()[]{}";
        String text3 = "(]";
        String text4 = "{({})[]}";
        String text5 = "{getValue({fast}) arr [ 1 ]}";
        String text6 = "([)]{}";
        System.out.printf("test 1: %s - %b\n", text1, checkBrackets(text1));
        System.out.printf("test 2: %s - %b\n", text2, checkBrackets(text2));
        System.out.printf("test 3: %s - %b\n", text3, checkBrackets(text3));
        System.out.printf("test 4: %s - %b\n", text4, checkBrackets(text4));
        System.out.printf("test 5: %s - %b\n", text5, checkBrackets(text5));
        System.out.printf("test 6: %s - %b\n", text6, checkBrackets(text6));
    }

    /**
     * Инициализация словаря
     */
    private static void mapInit() {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    /**
     * Проверка количества и порядка скобок в строке
     * Используется map для сопоставления парных символов.
     * Остальные символы не рассматриваются
     *
     * @param s - строка
     * @return - true, если со скобками все нормально
     */
    private static boolean checkBrackets(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character s1 = s.charAt(i);
            if (map.containsValue(s1)) {
                stk.push(s1);
            } else {
                if (map.containsKey(s1)
                        && !stk.empty()
                        && stk.pop() != map.get(s1)) {
                    return false;
                }
            }
        }
        return stk.empty();
    }
}
