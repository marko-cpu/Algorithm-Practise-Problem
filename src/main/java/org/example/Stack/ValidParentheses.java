package org.example.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    // Brute Force
    // Time complexity O(n^2)
    // Space complexity O(n)
    public boolean isValid(String s) {
        while (s.contains("()") || s.contains("{}") ||
        s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }

    // Stack
    // Time complexity O(n)
    // Space complexity O(n)
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();

        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if(!stack.isEmpty() && stack.peek() == closeToOpen.get(c)){
                    stack.pop();
                } else {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }



    public static void main(String[] args) {

        ValidParentheses validParentheses = new ValidParentheses();

        // Brute Force
        System.out.println(validParentheses.isValid("([)]"));

        // Stack
        System.out.println(validParentheses.isValid2("[()]"));

    }
}
