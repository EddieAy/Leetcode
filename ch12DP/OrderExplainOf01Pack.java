package ch12DP;

public class OrderExplainOf01Pack {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3}; // 物品的重量
        int[] values = {6, 10, 12}; // 物品的价值
        int bagCapacity = 5; // 背包的容量

        // 0-1背包问题的倒序解法
        System.out.println("0-1背包问题（倒序）:");
        int[] dpReverse = new int[bagCapacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = bagCapacity; j >= weights[i]; j--) {
                dpReverse[j] = Math.max(dpReverse[j], dpReverse[j - weights[i]] + values[i]);
            }
            printArray(dpReverse);
        }

        // 0-1背包问题的正序解法，这会导致错误，因为它多次使用了同一个物品
        System.out.println("0-1背包问题（正序 - 错误的）:");
        int[] dpForward = new int[bagCapacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = weights[i]; j <= bagCapacity; j++) {
                dpForward[j] = Math.max(dpForward[j], dpForward[j - weights[i]] + values[i]);
            }
            printArray(dpForward);
        }
    }

    private static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
