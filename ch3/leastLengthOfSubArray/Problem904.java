package ch3.leastLengthOfSubArray;

import java.util.HashMap;

public class Problem904 {
    public static void main(String[] args) {

    }

    public int totalFruit(int[] fruits) {

        int left = 0;
        int right = 0;
        int maxlength = 0;

        HashMap<Integer,Integer> window = new HashMap<>();
        for (;right < fruits.length;right++){
//            if (!window.containsKey(fruits[right])){
//                window.put(fruits[right],1);
//            }else {
//                int value = window.get(fruits[right]);
//                window.put(fruits[right],value + 1);
//            }
//            window.put(fruits[right],window.getOrDefault(fruits[right],0) + 1);

            while(window.size() > 2){
                window.put(fruits[left],window.get(fruits[left]) - 1);
                //就是 size 大于2 以后 要开始移动左边了 例如  3 3 2 2 2 1     走到1的时候 开始移除 3
                if (window.get(fruits[left]) == 0){
                    window.remove(fruits[left]);
                }
                left++;
            }

            maxlength = Math.max(maxlength,right - left + 1);
        }

        return maxlength;
    }
}
