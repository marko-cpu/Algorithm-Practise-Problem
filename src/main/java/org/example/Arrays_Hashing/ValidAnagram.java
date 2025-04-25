package org.example.Arrays_Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    // Sorting
    // Time: O(n log n + m log m)
    // Space complexity: O(1) or O(n + m) depending on the sorting algorithm
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }

    // Hash Table
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // Put each character in the HashMap and check if it already exists or not and increment by 1
            countS.put(s.charAt(i),countS.getOrDefault(s.charAt(i),0)+1);
            countT.put(t.charAt(i),countT.getOrDefault(t.charAt(i),0)+1);
        }
        return countS.equals(countT);

    }

    //Hash Table (Optiomal)
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // return character on postion i and subtract it by 'a'
            // to get the index in array
            // and increment by 1
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;

    }



    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram("markoo","okram"));
        System.out.println(va.isAnagram2("marko","okram"));
        // Best Solution
        System.out.println(va.isAnagram3("marko","okram"));
    }
}
