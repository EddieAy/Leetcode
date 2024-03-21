package ch0Review.ch1Array;

import java.util.HashMap;
import java.util.Map;

public class P904FruitIntoBaskets {

    public static void main(String[] args) {
        int a = new P904FruitIntoBaskets().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
    }
    public int totalFruit(int[] fruits) {
        int i = 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int j = 0; j < fruits.length; j++) {
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while (map.size() > 2){
                map.put(fruits[i],map.get(fruits[i]) - 1);
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
