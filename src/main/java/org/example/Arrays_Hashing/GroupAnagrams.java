package org.example.Arrays_Hashing;

import java.util.*;

public class GroupAnagrams {

    // Sorting
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sordetS = new String(charArr);
            res.putIfAbsent(sordetS, new ArrayList<>());
            res.get(sordetS).add(s);
        }
        return new ArrayList<>(res.values());
    }

    //Hash Table
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }




    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        // Sorting
        System.out.println(ga.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        // Hash Table
        System.out.println(ga.groupAnagrams2(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
