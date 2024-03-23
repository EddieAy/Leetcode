package ch0Review.ch3Hash;

import java.util.HashSet;
import java.util.Set;

public class P202HappyNumber {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        Set<Integer> set = new HashSet<>();
        int happyNum = n;
        while (!set.contains(happyNum)){
            set.add(happyNum);
            if(happyNum == 1){
                return true;
            }
            happyNum = getHappyNum(happyNum);
        }
        return false;
    }

    private int getHappyNum(int happyNum) {
        int sum = 0;
        while (happyNum > 0){
            int res = happyNum % 10;
            sum += res * res;
            happyNum /= 10;
        }
        return sum;
    }
}
