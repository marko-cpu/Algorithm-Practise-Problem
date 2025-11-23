package org.example.Sliding_Window;

import java.util.HashMap;
import java.util.HashSet;

public class LongestRepeatingCharacterReplacement {

    //Brute Force
    // Time complexity O(n^2)
    //Space complexity O(m)
    public int characterReplacement(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxf = 0;
            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxf = Math.max(maxf, count.get(s.charAt(j)));
                if (j - i + 1 - maxf <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }


    // Sliding Window
    // Time complexity O(m * n)
    //Space complexity O(m)
    public int lengthOfLongestSubstring2(String s, int k) {
        int res = 0;
        HashSet<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        for (char c : charSet) {
            int count = 0, l = 0;
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    count++;
                }

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }

                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }


    //Sliding Window (Optimal)
    // Time complexity O(n)
    //Space complexity O(m)
    public int lengthOfLongestSubstring3(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;

        int l = 0, maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            while ((r - l + 1) - maxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }


    public static void main(String[] args) {

        LongestSubstringWithoutReapitingCharacters lswrc = new LongestSubstringWithoutReapitingCharacters();
        //Brute Force
        System.out.println(lswrc.lengthOfLongestSubstring("XYYX"));
        // Sliding Window
        System.out.println(lswrc.lengthOfLongestSubstring2("XYYX"));
        //Sliding Window (Optimal)
        System.out.println(lswrc.lengthOfLongestSubstring3("XYYX"));

    }
}
