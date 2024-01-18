package ch6.Hash.HappyNumber;

import java.util.*;

public class Problem202 {
    public static void main(String[] args) {
        System.out.println(isHappy2(19));
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int num = result(n);
        while (!set.contains(num)){
            set.add(num);
            num = result(num);
            if(num == 1) return true;
        }
        return false;
    }
    public static boolean isHappy2(int n) {
        int fast;
        int slow;
        fast = result(result(n));
        slow = result(n);

        while (slow != fast){
            fast = result(result(fast));
            slow = result(slow);
        }
        return slow == 1;
    }

    public static int result(int num){
        int sum = 0;
        while (num > 0){
            int temp = num % 10;
            sum += (temp * temp);
            num /= 10;
        }
        return sum;
    }
}
