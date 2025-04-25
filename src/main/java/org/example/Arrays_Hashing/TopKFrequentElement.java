package org.example.Arrays_Hashing;

import java.util.*;

public class TopKFrequentElement {

    // 1. Sorting
    public int[] topKFrequent(int[] nums, int k) {

        // Count the frequency of each element
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Sort the elements by frequency in descending order and store them in a list
        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        // Return the top k elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }

    // 2.Min-Heap
    public int[] topKFrequent2(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

    // 3. Bucket Sort
    public int[] topKFrequent3(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i< freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {

        // 1. Sorting
        TopKFrequentElement topk = new TopKFrequentElement();
        System.out.println(Arrays.toString(topk.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));

        // 2. Min-Heap
        System.out.println(Arrays.toString(topk.topKFrequent2(new int[]{1, 1, 1, 2, 2, 3}, 2)));

        // 3. Bucket Sort
        System.out.println(Arrays.toString(topk.topKFrequent3(new int[]{1, 1, 1, 2, 2, 3}, 2)));

    }
}
