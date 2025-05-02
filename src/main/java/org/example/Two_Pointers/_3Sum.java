package org.example.Two_Pointers;

import java.util.*;

public class _3Sum {

    //Brute Force
    //Time complexity O(n^3)
    //Space complexity O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        res.add(tmp);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    //HashMap
    //Time complexity O(n^2)
    //Space complexity O(n)
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.get(nums[i]) - 1);
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length ; j++) {
                count.put(nums[j], count.get(nums[j]) - 1);
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int target = -(nums[i] + nums[j]);
                if(count.getOrDefault(target, 0) > 0) {
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
            for (int j = i + 1; j < nums.length ; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);
            }
        }
        return res;
    }

    //Two Pointers
    //Time complexity O(n^2)
    //Space complexity O(n) or O(1) depending on the sorting algorithm
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        _3Sum ts = new _3Sum();
        //Brute Force
        System.out.println(ts.threeSum(new int[]{-1,0,1,2,-1,-4}));

        //HashMap
        System.out.println(ts.threeSum2(new int[]{-1,0,1,2,-1,-4}));

        //Two Pointers
        System.out.println(ts.threeSum3(new int[]{-1,0,1,2,-1,-4}));

    }

}

