package org.example.Arrays_Hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {

    //Brute Force
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // Sorting
    public int[] twoSum2(int[] nums, int target) {
        int[][] A = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            A[i][0] = nums[i]; // number value
            A[i][1] = i; // original index of the number
        }
        // Sorting the array of pairs by number value
        Arrays.sort(A, Comparator.comparingInt(a -> a[0]));

        int i = 0, j = nums.length - 1;
        while(i < j) {
            int sum = A[i][0] + A[j][0];
            if (sum == target) {
                return new int[]{Math.min(A[i][1], A[j][1]),
                        Math.max(A[i][1], A[j][1])};
            } else if( sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[0];
    }


    // Hash Map (Two Pass)
    public int[] twoSum3(int[] nums, int target) {
        // value -> index
        HashMap<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }

        // for each number in nums find the difference between the
        // target and the number and check if the difference is in the map
        // and its index is not equal to the current index of the number
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indices.containsKey(diff) && indices.get(diff) != i) {
                return new int[]{i, indices.get(diff)};
            }
        }
        return new int[0];
    }

    // Hash Map (One Pass)
    public int[] twoSum4(int[] nums, int target) {
        // value -> index
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if(prevMap.containsKey(diff)) {
                return new int[]{prevMap.get(diff), i};
            }
            prevMap.put(num, i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        // Brute Force
        int[] nums = ts.twoSum(new int[]{3,4,5,6}, 7);
        System.out.println(nums[0] + " " + nums[1]);

        // Sorting
        nums = ts.twoSum2(new int[]{3,4,5,6}, 7);
        System.out.println(nums[0] + " " + nums[1]);

        // Hash Map (Two Pass)
        nums = ts.twoSum3(new int[]{3,4,5,6}, 7);
        System.out.println(nums[0] + " " + nums[1]);

        // Hash Map (One Pass)
        nums = ts.twoSum4(new int[]{3,4,5,6}, 7);
        System.out.println(nums[0] + " " + nums[1]);


    }
}
