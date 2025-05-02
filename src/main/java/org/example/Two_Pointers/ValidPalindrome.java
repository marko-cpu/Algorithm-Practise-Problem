package org.example.Two_Pointers;

public class ValidPalindrome {

    //Reverse String
    //Time: O(n)
    //Space: O(n)
    public boolean isPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newStr.append(Character.toLowerCase(c));
            }
        }
        return newStr.toString().equals(newStr.reverse().toString());
    }

    //Two Pointers
    //Time: O(n)
    //Space: O(1)
    public boolean isPalindrome2(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !alphaNum(s.charAt(left))) {
                left++;
            }
            while (right > left && !alphaNum(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9');
    }


public static void main(String[] args) {

    ValidPalindrome vp = new ValidPalindrome();
    System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));

    //Two Pointers
    System.out.println(vp.isPalindrome2("A man, a plan, a canal: Panama"));
    System.out.println(vp.isPalindrome2("AN::::A"));
}
}

