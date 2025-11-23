package org.example.Sliding_Window;

public class BestTimeToBuyAndSellStock {

    //Brute Force
    //Time complexity O(n^2)
    //Space complexity O(1)
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int sell = prices[j];
                res = Math.max(res, sell - buy);
            }
        }
        return res;

    }

    //Two Pointers
    //Time complexity O(n)
    //Space complexity O(1)
    public int maxProfit2(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                maxP = Math.max(maxP, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return maxP;
    }

    //Dynamic Programming
    //Time complexity O(n)
    //Space complexity O(1)
    public int maxProfit3(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

        for(int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxP;
    }

    public static void main(String[] args) {

        BestTimeToBuyAndSellStock bt = new BestTimeToBuyAndSellStock();
        System.out.println(bt.maxProfit(new int[]{7,1,5,3,6,4}));

        System.out.println(bt.maxProfit2(new int[]{7,1,5,3,6,4}));

    }
}
