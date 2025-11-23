package org.example.Sliding_Window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutReapitingCharacters {


    //Brute Force
    // Time complexity O(n * m)
    //Space complexity O(m)
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < s.length() ; j++) {
                if(charSet.contains(s.charAt(j))) {
                    break;
                }
                charSet.add(s.charAt(j));
            }
            res = Math.max(res, charSet.size());
        }
        return res;
    }

    //SLiding Window
    //Time complexity O(n)
    //Space complexity O(m)
    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int i = 0; i < s.length() ; i++) {
            while(charSet.contains(s.charAt(i))) {
                charSet.remove(s.charAt(i));
                l++;
            }
            charSet.add(s.charAt(i));
            res = Math.max(res, i - l + 1);
        }
        return res;
    }

    //Sliding Window (Optimal)
    //Time complexity O(n)
    //Space complexity O(m)
    public int lengthOfLongestSubstring3(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            if(mp.containsKey(s.charAt(r))) {
                l = Math.max(mp.get(s.charAt(r)) + 1, l);
            }
            mp.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }


    public static void main(String[] args) {

        LongestSubstringWithoutReapitingCharacters lswrc = new LongestSubstringWithoutReapitingCharacters();
        //Brute Force
        System.out.println(lswrc.lengthOfLongestSubstring("abcabcbb"));

        //Sliding Window
        System.out.println(lswrc.lengthOfLongestSubstring2("abcabcbb"));

        //Sliding Window (Optimal)
        System.out.println(lswrc.lengthOfLongestSubstring3("abcabcbb"));
    }
}
