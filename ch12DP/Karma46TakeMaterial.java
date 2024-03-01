package ch12DP;

import java.util.Scanner;

public class Karma46TakeMaterial {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem2(weight,value,bagSize);
    }

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){

        // 创建dp数组
        int goods = weight.length;  // 获取物品的数量
        int[][] dp = new int[goods][bagSize + 1];

        // 初始化dp数组
        // 创建数组后，其中默认的值就是0
/*        Arrays.sort(weight);
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }*/

        for (int j = 0; j <= bagSize; j++) {
            if (j >= weight[0]) {
                dp[0][j] = value[0];  // 当背包容量大于等于第一个物品的重量时，可以选择装入该物品
            } else {
                dp[0][j] = 0;  // 否则，背包内无法装入该物品，价值为0
            }
        }

        // 填充dp数组
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (j < weight[i]) {
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i-1][j];
                } else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    /*
    * 不能正序可以这么理解:
       虽然是一维数组，但是性质和二维背包差不多。
       * 我们先来理解倒序遍历，从最后一个元素往前看，看到的都是“上一层的元素”然后每遍历到一个元素，就把当前元素赋值成“当前层”的。
       * 这样得到的背包，因为每个元素加上的都是上一层的对应的物品value，所以不会重复。
       * 因为二维数组是根据左上元素来求的，一维数组自然就是靠左边来求的。
       * 倒序的时候左边元素再刷新前都是上一层的数据，但正序就不一样了，正序的时候，左边的元素刚刚刷新过，也就是左边的元素已经是本层的了，
       * 意味着什么 这样会导致一个物品反复加好几次。
    * */
    public static void testWeightBagProblem2(int[] weight, int[] value, int bagWeight){
        int[] dp = new int[bagWeight + 1];
        dp[0] = 0;
        //本来 应该每个值都赋一个 不影响后面比较max的最小值 敲定为0   但是这里不用赋值为0 默认都是0
        /*
         * dp[j] = max(dp[j],dp[j - weight[i]] + value[i])
         *
         * */
        int len = weight.length;
        for (int i = 0; i < len; i++) {
            for (int j = bagWeight; j >= weight[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j - weight[i]] + value[i]);
            }
        }
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }
}
