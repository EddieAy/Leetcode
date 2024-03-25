package ch0Review.ch4String;

import java.util.Arrays;

public class P28FindIndex {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P28FindIndex().getNext("ABABC")));
    }
    public int strStr(String haystack, String needle) {
        int i = 0,j = 0;
        int[] next = getNext(needle);
        while (i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else if(j > 0){
                j = next[j - 1];
            }else {
                i += 1;
            }

            if(j == needle.length()){
                return i - j;
            }

        }

        return -1;
    }

    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int k = 0;
        next[0] = 0;
        int i = 1;
        while (i < needle.length()){
            if(needle.charAt(i) == needle.charAt(k)){
                k++;
                next[i] = k;
                i++;
            }else {
                if(k == 0){
                    next[i] = 0;
                    i++;
                }else {
                    //我懂了！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
                    /*

                     A B A C A B A B
                     0 0 1 0 1 2 3 ?


                    * 走到 这里 说明  B与C 已经匹配不上了
                    * 但是 其实还能找到短的 比如 A B
                    此时的前后缀的长度为k  说明前面从头开始 有k个 后面也有k个
                    k - 1 对应的是 下标
                    它也有一个前后缀长度
                    此时k=1    等于又重新开始找

                    * */
                    k = next[k - 1];
                }
            }
        }
        return next;
    }
}
