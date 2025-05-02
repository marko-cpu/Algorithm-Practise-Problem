package org.example.Two_Pointers;

public class ContainerWithMostWater {


    //Brute Force
    //Time complexity O(n^2)
    //Space complexity O(1)
    public int maxArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length ; j++) {
                res = Math.max(res, Math.min(heights[i],heights[j]) * (j - i));
            }
        }
        return res;
    }

    //Two Pointers
    //Time complexity O(n)
    //Space complexity O(1)
    public int maxArea2(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        while(l < r) {
            int area = Math.min(heights[l],heights[r])  * (r-l);
            res = Math.max(res, area);
            if(heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        //Brute Force
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        System.out.println(cwmw.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

        //Two Pointers
        System.out.println(cwmw.maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
