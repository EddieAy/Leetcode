package ch11Greedy;

public class Problem134GasStation {
    /*
    *
    * 2 2 2 -3 -3
    * 1 1 -1
    *
    * */

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(new Problem134GasStation().canCompleteCircuit2(gas,cost));
    }
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int totalGas = 0;
            int j = 0;
            while (j < n){
                int index = (i + j) % n;
                totalGas += gas[index] - cost[index];
                if(totalGas < 0){
                    break;
                }
                j++;
            }
            if(j == n){
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost){
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if(curSum < 0){
                start = i + 1;
                curSum = 0;
            }
        }
        if(totalSum < 0) return -1;
        return start;
    }
}
