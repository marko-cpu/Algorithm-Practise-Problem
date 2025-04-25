package org.example.Arrays_Hashing;

import java.util.*;

public class LongestConsecutiveSequence {

    //Brute Force
    //Time complexity O(n^2)
    //Space complexity O(n)
    public int longestConsecutive(int[] nums) {
        int res = 0;
        //Set store unique elements
        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            store.add(num);
        }

        for (int num : nums) {
            int streak = 0, curr = num;
            while (store.contains(curr)) {
                streak++;
                curr++;
            }
            res = Math.max(res, streak);
        }
        return res;
    }

    //Sorting
    //Time Complexity O(n log n)
    //Space Complexity O(1) or O(n) depending on the sorting algorithm
    public int longestConsecutive2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while( i < nums.length) {
            if(curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            while (i < nums.length && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }

    //HashSet
    //Time Complexity O(n)
    //Space Complexity O(n)
    public int longestConsecutive3(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for( int num : numSet) {
            if(!numSet.contains(num - 1 )) {
                int length = 1;
                while(numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    //HashMap
    //Time Complexity O(n)
    //Space Complexity O(n)
    public int longestConsecutive4(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;

        for(int num : nums) {
            if(!mp.containsKey(num)) {
                mp.put(num, mp.getOrDefault(num - 1,0) +
                        mp.getOrDefault(num + 1, 0) + 1);

                mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));

                mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));

                res = Math.max(res, mp.get(num));
            }
        }
        return res;
    }


    public static void main(String[] args) {

        //Brute Force
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
       // System.out.println(lcs.longestConsecutive(new int[]{100,4,200,1,3,2}));

        //Sorting
        //System.out.println(lcs.longestConsecutive2(new int[]{100,4,200,1,3,2}));

        //HashSet
        System.out.println(lcs.longestConsecutive3(new int[]{100,4,200,1,3,2}));


    }
}
