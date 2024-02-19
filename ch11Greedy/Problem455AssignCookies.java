package ch11Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem455AssignCookies {

    public static void main(String[] args) {
        
    }
    //要求： 必须饼干大于胃口  并且尽量的多
    /*
    1 2
    1 2 3
    * 初步思考：都排序 然后最大饼干给最大的胃口
    * */
    public int findContentChildren(int[] appetite, int[] cookie) {
        Arrays.sort(appetite);
        Arrays.sort(cookie);

        int index = cookie.length - 1;
        int satisfied = 0;
        for (int i = appetite.length - 1; i >= 0 ; i++) {
            if(index >=0 && appetite[i] <= cookie[index]){
                index--;
                satisfied++;
            }
        }
        return satisfied;

    }
}
